package retroscope.rql;

import retroscope.RetroscopeException;
import retroscope.util.ByteArray;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.*;
import java.util.*;

/**
 * Created by Aleksey on 12/27/2016.
 * This represents the value part of the key value pair for Retroscope
 * operating under Retroscope Query Language (RQL). This gets compiled into a
 * DataEntry<ByteArray> objects for regular inclusion into the Retroscope logs.
 * value is a composite field that can consist of multiple named sub-fields of
 * different type: int64, double, string. Currently, String is limited to
 * 255 bytes. Name is string and cannot exceed 63 bytes (63 ASCII characters)
 */

public class RQLItem implements Serializable {

    private HashMap<String, RQLItemValue> vals = new HashMap<String, RQLItemValue>(15, 0.7f);

    public RQLItem() {

    }

    /*public RQLItem(ByteArray rawBytes) {
        this(rawBytes.get());
    }*/

    /*public RQLItem(byte[] bytes) {
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        while (buf.hasRemaining()) {
            try {
                addField(new RQLItemValue(buf));
            } catch (RQLItemException re) {
                System.err.println(re.getMessage());
            }
        }
    }*/

    /*public ByteArray toByteArray() {
        //make sure we have a large enough buffer
        ByteBuffer buf = ByteBuffer.allocate(vals.size() * RQLItemValue.MAX_SIZE);
        Iterator<Map.Entry<String, RQLItemValue>> it = vals.entrySet().iterator();
        while (it.hasNext()) { //iterating through the symbols in the symbol table
            Map.Entry<String, RQLItemValue> pair = it.next();
            pair.getValue().toByteBuffer(buf);
        }
        byte[] bytes = new byte[(buf.limit() - buf.remaining())];
        buf.rewind();
        buf.get(bytes, 0, bytes.length);
        return new ByteArray(bytes);
    }*/


    public RQLItemValue getField(String name){
        return vals.get(name);
    }


    public RQLItem addField(RQLItemValue val) {
        vals.put(val.getName(), val);
        return this;
    }

    public RQLItem addField(String val) {
        vals.put("", new RQLItemValue("", val));
        return this;
    }

    public RQLItem addField(String name, String val) {
        vals.put(name, new RQLItemValue(name, val));
        return this;
    }

    public RQLItem addField(double val) {
        vals.put("", new RQLItemValue("", val));
        return this;
    }

    public RQLItem addField(String name, double val) {
        vals.put(name, new RQLItemValue(name, val));
        return this;
    }

    public RQLItem addField(int val) {
        vals.put("", new RQLItemValue("", val));
        return this;
    }

    public RQLItem addField(String name, int val) {
        vals.put(name, new RQLItemValue(name, val));
        return this;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        Iterator<Map.Entry<String, RQLItemValue>> it = vals.entrySet().iterator();
        while (it.hasNext()) { //iterating through the symbols in the symbol table
            Map.Entry<String, RQLItemValue> pair = it.next();
            out.write(pair.getValue().toBytes());
        }
    }

    private void readObject(ObjectInputStream in) throws IOException {
        vals = new HashMap<String, RQLItemValue>(15, 0.7f);
        while (in.available() > 0) {
            byte[] bytes = new byte[in.available()];
            int read = in.read(bytes);
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            while (buf.hasRemaining()) {
                try {
                    RQLItemValue rv = new RQLItemValue(buf);
                    addField(rv);
                } catch (RQLItemException re) {
                    System.err.println(re.getMessage());
                }
            }
        }
    }

    public List<RQLItemValue> getItemsList() {
        return new ArrayList<RQLItemValue>(vals.values());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RQLItem: ");
        sb.append(System.getProperty("line.separator"));
        for (RQLItemValue v : vals.values()) {
            sb.append(v.getName());
            sb.append(" = ");
            if (v.getType() == Types.INT) {
                sb.append(" i: ");
                sb.append(v.getIntVal());
            }
            if (v.getType() == Types.DOUBLE) {
                sb.append(" d: ");
                sb.append(v.getDoubleVal());
            }
            if (v.getType() == Types.STRING) {
                sb.append(" s: ");
                sb.append(v.getStringVal());
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

}