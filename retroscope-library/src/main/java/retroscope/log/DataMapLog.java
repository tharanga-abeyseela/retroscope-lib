package retroscope.log;

import retroscope.RetroscopeException;
import retroscope.hlc.Timestamp;
import retroscope.util.ByteArray;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by aleksey on 10/19/16.
 * DataMapLog is a log with associated hashmap for current values.
 * It allows Retroscope to keep the rolling log of data
 */
public class DataMapLog<K extends Serializable, V extends Serializable> extends Log<K, V> {

    /* we are using lock instead of synchronized keyword because:
     * - some evidence suggests it scales better under high contention
     * - it allows us to acquire lock and perform multiple gets and puts "atomically"
     */
    private RetroMap<K, V> dataMap;
    private HashMap<Integer, RetroMap<K, V>> snapshots;
    private HashMap<Long, HashMap<K, LogEntry<K, V>>> bidirectionalDataMapDiffs;

    public DataMapLog(long maxLengthMillis, String name) {
        this(maxLengthMillis, name, 100);
    }

    public DataMapLog(long maxLengthMillis, String name, long logCheckpointIntervalMs) {
        super(maxLengthMillis, name, logCheckpointIntervalMs);
        dataMap = new RetroMap<K, V>(100);
        bidirectionalDataMapDiffs = new HashMap<Long, HashMap<K, LogEntry<K, V>>>(10);
        snapshots = new HashMap<Integer, RetroMap<K, V>>(10);
    }

    @Override
    public int append(LogEntry<K, V> entry) throws RetroscopeException {
        lock();
        dataMap.put(entry.getKey(), entry.getToV());
        int append = super.append(entry);
        unlock();
        return append;
    }

    public int append(K key, DataEntry<V> newV) throws RetroscopeException {
        DataEntry<V> oldV = getItem(key);
        LogEntry<K, V> le = new LogEntry<K, V>(key, oldV, newV);
        return append(le); //locking is here
    }

    @Override
    protected void checkpoint(LogEntry<K, V> entry) {
        if (logCheckpointIntervalMs > 0) {
            long t = entry.getTime().getWallTime();
            long tmod = t / logCheckpointIntervalMs;
            //System.out.println("checkpoint: " + t + " -> " + tmod);
            if (timeToCheckpointId.get(tmod) == null) {
                int knownId = addKnownEntries(entry);
                timeToCheckpointId.put(tmod, knownId);
                //we also want to compute datamap diff at this point
                if (entry.getPrev() != null) {

                    computeDatamapDiff(tmod, entry);
                }
            }
        }
    }


    /**
     * This function is invoked when the tmod changes as time progresses
     * we compute a new bidirectional diff for every new tmod.
     * the diff is from element right before Tnow (the time of tmod change)
     * and the first element of previos checkpoint
     *
     * @param tmod  new checkpoint id
     * @param entry LogEntry the first element of new checkpoint interval
     */
    private void computeDatamapDiff(long tmod, LogEntry<K, V> entry) {
        long lastTmod = entry.getPrev().getTime().getWallTime() / logCheckpointIntervalMs;
        LogEntry<K, V> lastCheckpoint = getKnownEntry(timeToCheckpointId.get(lastTmod));
        bidirectionalDataMapDiffs.put(tmod, computeBidirectionalDiffBackwards(entry, lastCheckpoint));
    }


    /**
     * computeBidirectionalDiffBackwards computes the bidirectional difference map
     * from newer checkpoint to older one.
     * <p>
     * this method is protected for unit testing
     *
     * @param startingPoint
     * @param endingPoint
     * @return
     */

    protected HashMap<K, LogEntry<K, V>> computeBidirectionalDiffBackwards(
            LogEntry<K, V> startingPoint,
            LogEntry<K, V> endingPoint
    ) {
        LogEntry<K, V> currentLogItem = startingPoint;
        boolean notEnd = true;
        HashMap<K, LogEntry<K, V>> diffMap = new HashMap<K, LogEntry<K, V>>(getLength());

        //we stop traversing when current log is the endingPoint item
        //the must be the same items, not just have the same time. same reference!
        //therefore both must be in the linked list, and we must be traversing in
        //the right direction
        while (endingPoint != currentLogItem.getNext() && notEnd) {
            if (diffMap.get(currentLogItem.getKey()) == null) {
                //we clone LogEntry to avoid side-effects and make sure we keep log intact
                diffMap.put(currentLogItem.getKey(), currentLogItem.clone());
            } else {
                //this operates on the checkpoint copy
                diffMap.get(currentLogItem.getKey()).setFromV(currentLogItem.getFromV());
            }
            if (!currentLogItem.isHead()) {
                currentLogItem = currentLogItem.getPrev();
            } else {
                notEnd = false;
            }
        }
        return diffMap;
    }

    protected RetroMap<K, V> computeDiffBackwards(Timestamp timeInThePast, LogEntry<K, V> startingPoint) throws LogOutTimeBoundsException {
        RetroMap<K, V> diffMap = null;
        LogEntry<K, V> Cn = null;
        LogEntry<K, V> CEnd = null;
        if (logCheckpointIntervalMs > 0) {
            Cn = getCheckpointLogEntryByTime(startingPoint.getTime());
            CEnd = getCheckpointLogEntryByTime(timeInThePast);
        }
        // Cn and CEnd point to different objects
        if (Cn != CEnd) {
            //we need to compute the following:
            //------X<----C1<---------------C2<---------------C...<---------------Cn<-----S
            //where S is the starting point, X is the desired point and C are checkpoints
            //step 1: compute C<-----S
            Timestamp checkpointTime = Cn.getTime();
            diffMap = super.computeDiffBackwards(checkpointTime, startingPoint);
            //System.out.println("diffMap = " +diffMap);
            //step 2: compute C1<---------------C2<---------------C...<---------------Cn
            //first we get the the checkpoint we need to arrive to
            long tmodFinal = (timeInThePast.getWallTime() + logCheckpointIntervalMs);

            LogEntry<K, V> C1 = getCheckpointLogEntryByTime(tmodFinal);
            LogEntry<K, V> Cnm1 = getCheckpointLogEntryByTime(Cn.getPrev().getTime());
            while (Cn != C1) {
                //we want to reach C1
                HashMap<K, LogEntry<K, V>> CnDiff =
                        bidirectionalDataMapDiffs.get(Cn.getTime().getWallTime() / logCheckpointIntervalMs);
                diffMap.putAllLogEntriesBackwards(CnDiff);
                Cn = Cnm1;
                Cnm1 = getCheckpointLogEntryByTime(Cn.getPrev().getTime());
            }

            //step 3: compute X<----C1; X is timeInThePast
            RetroMap<K, V> diffMapC1 = super.computeDiffBackwards(timeInThePast, C1);
            //step 4: marge diffMap and DiffMap from step 3
            diffMap.putAll(diffMapC1);
            diffMap.setAssociatedLogEntry(diffMapC1.getAssociatedLogEntry());

        } else {
            //System.out.println("Old Method");
            diffMap = super.computeDiffBackwards(timeInThePast, startingPoint);
        }
        return diffMap;
    }

    protected RetroMap<K, V> computeDiffForwards(Timestamp timeInTheFuture, LogEntry<K, V> startingPoint) throws LogOutTimeBoundsException {
        RetroMap<K, V> diffMap = null;

        LogEntry<K, V> Cn = null;
        LogEntry<K, V> Ccheck = null;
        if (logCheckpointIntervalMs > 0) {
            Cn = getCheckpointLogEntryByTime(timeInTheFuture);
            Ccheck = getCheckpointLogEntryByTime(startingPoint.getTime().getWallTime());
            //------>Cn------->S--------->X-----
        }

        if (Cn != Ccheck) {
            LogEntry<K, V> currentLogItem = startingPoint;
            //we need to compute the following:
            //------S---->C1--------------->C2--------------->C...--------------->Cn----->X-----
            //where S is the starting point, X is the desired point and C are checkpoints
            //step 1: compute S---->C1
            LogEntry<K, V> C1 = getCheckpointLogEntryByTime(startingPoint.getTime().getWallTime() + logCheckpointIntervalMs);
            Timestamp checkpointTime = C1.getTime();
            try {
                diffMap = super.computeDiffForwards(startingPoint, C1);
                //System.out.println("diffMap = " + diffMap);
            } catch (LogOutTimeBoundsException lobe) {lobe.printStackTrace(); return null;}


            //step 2: compute C1--------------->C2--------------->C...--------------->Cn
            //first we get the the checkpoint we need to arrive to
            LogEntry<K, V> Cnext = getCheckpointLogEntryByTime(C1.getTime().getWallTime() + logCheckpointIntervalMs);
            while (Cnext != null && Cnext.getTime().compareTo(Cn.getTime()) <= 0) {
                //we want to reach Cn
                //System.out.println("----111---" + Cnext.getTime());
                HashMap<K, LogEntry<K, V>> CnDiff =
                        bidirectionalDataMapDiffs.get(Cnext.getTime().getWallTime() / logCheckpointIntervalMs);
                diffMap.putAllLogEntriesForward(CnDiff);
                Cnext = getCheckpointLogEntryByTime(Cnext.getTime().getWallTime() + logCheckpointIntervalMs);
            }

            //step 3: compute Cn----->X; X is timeInTheFuture
            RetroMap<K, V> diffMapCn = super.computeDiffForwards(timeInTheFuture, Cn);
            //step 4: marge diffMap and DiffMap from step 3
            diffMap.putAll(diffMapCn);
            diffMap.setAssociatedLogEntry(diffMapCn.getAssociatedLogEntry());
        } else {
            diffMap = super.computeDiffForwards(timeInTheFuture, startingPoint);
        }

        return diffMap;
    }


    public LogEntry<K, V> getCheckpointLogEntryByTime(Timestamp timestamp) {
        long tmod = timestamp.getWallTime() / logCheckpointIntervalMs;
        Integer checkpointID = timeToCheckpointId.get(tmod);
        LogEntry<K, V> checkPointItem = knownCheckpointLogEntries.get(checkpointID);
        return checkPointItem;
    }

    public LogEntry<K, V> getCheckpointLogEntryByTime(long timestamp) {
        return getCheckpointLogEntryByTime(new Timestamp(timestamp, (short) 0));
    }


    public DataEntry<V> getItem(K key) {
        lock();
        DataEntry<V> data = this.dataMap.get(key);
        unlock();
        return data;
    }

    public RetroMap<K, V> getAllData() {
        lock();
        RetroMap<K, V> datamap = this.dataMap;
        unlock();
        return datamap;
    }

    public RetroMap<K, V> getAllData(Timestamp dataTime) throws LogOutTimeBoundsException {
        RetroMap<K, V> diff;
        try {
            lock();
            diff = this.computeDiff(dataTime);
            unlock();
        } catch (LogOutTimeBoundsException lotbe) {
            unlock();
            throw lotbe;
        }
        RetroMap<K, V> clone = new RetroMap<K, V>(dataMap);
        clone.putAll(diff);
        clone.setAssociatedLogEntry(diff.getAssociatedLogEntry());
        return clone;
    }

    public DataEntry<V> getItem(K key, Timestamp dataTime) throws LogOutTimeBoundsException {
        RetroMap<K, V> snap = getAllData(dataTime); //locking is here
        return snap.get(key);
    }

    public DataEntry<V>[] getItems(K[] keys, Timestamp dataTime) throws LogOutTimeBoundsException {
        RetroMap<K, V> snap = getAllData(dataTime); //locking is here
        DataEntry[] vals = new DataEntry[keys.length];
        for (int i = 0; i < keys.length; i++) {
            vals[i] = snap.get(keys[i]);
        }
        return vals;
    }

    public DataEntry<V>[] getItems(K[] keys) {
        DataEntry[] vals = new DataEntry[keys.length];
        lock();
        for (int i = 0; i < keys.length; i++) {
            vals[i] = this.dataMap.get(keys[i]);
        }
        unlock();
        return vals;
    }

    public RetroMap<K, V> getItemsMap(K[] keys) {
        RetroMap<K, V> vals = new RetroMap<K, V>(keys.length);
        lock();
        for (int i = 0; i < keys.length; i++) {
            vals.put(keys[i], this.dataMap.get(keys[i]));
        }
        unlock();
        return vals;
    }

    public RetroMap<K, V> getItemsMap(K[] keys, Timestamp dataTime) throws LogOutTimeBoundsException {
        RetroMap<K, V> snap = getAllData(dataTime); //locking is here
        RetroMap<K, V> vals = new RetroMap<K, V>(keys.length);
        lock();
        for (int i = 0; i < keys.length; i++) {
            vals.put(keys[i], snap.get(keys[i]));
        }
        unlock();
        return vals;
    }

    /**
     * creates a snapshot and keeps it in memory
     *
     * @param snapshotTime
     * @return snapshot id
     */

    public int makeSnapshot(Timestamp snapshotTime) throws LogOutTimeBoundsException {
        RetroMap<K, V> snap = getAllData(snapshotTime); // locking is here
        LogEntry<K, V> knownEntry = snap.getAssociatedLogEntry();
        int entryId = this.addKnownEntries(knownEntry);
        this.snapshots.put(entryId, snap);

        return entryId;
    }

    public void rollSnapshot(int snapshotID, Timestamp newTime) throws RetroscopeException, LogOutTimeBoundsException {
        //do we need to lock here? nothing should change to log when rolling past snapshots and past log entries
        RetroMap<K, V> snap = getSnapshot(snapshotID);
        if (snap == null) {
            throw new RetroscopeException("snapshot does not exist");
        }
        RetroMap<K, V> diff = computeDiff(newTime, this.getKnownEntry(snapshotID));
        snap.putAll(diff); //we have modified the snapshot and overwritten it.
        //need to update the known logEntry for this snapshot
        snap.setAssociatedLogEntry(diff.getAssociatedLogEntry());
        this.knownCheckpointLogEntries.put(snapshotID, snap.getAssociatedLogEntry());
    }

    public RetroMap<K, V> getSnapshot(int snapshotID) {
        return snapshots.get(snapshotID);
    }


    /* private helper methods */



}
