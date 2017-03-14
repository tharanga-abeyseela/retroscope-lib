package retroscope.rql.syntaxtree.link;

import retroscope.rql.syntaxtree.IdentifierList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aleksey on 1/22/2017.
 *
 */
public class Link {

    private int[] placeholders;
    private boolean forAllLink;

    private LinkLock linkedNode;

    public Link(IdentifierList placeholders, boolean forAllLink) {
        this.placeholders = new int[placeholders.getIdentifiers().length];
        for (int i = 0; i < placeholders.getIdentifiers().length; i++) {
            this.placeholders[i] = Integer.parseInt(placeholders.getIdentifiers()[i].replace("$", ""));
        }
        this.forAllLink = forAllLink;
        linkedNode = new LinkLock();
    }

    public int[] getPlaceholders() {
        return placeholders;
    }

    public boolean isForAllLink() {
        return forAllLink;
    }

    public LinkLock getLinkedNode() {
        return linkedNode;
    }

    public void resetLink() {
        linkedNode.setLockedNode(-1);
    }

    public void lockLink(int nodeId) {
        linkedNode.setLockedNode(nodeId);
    }

    public boolean isInLink(int nodeId) {
        for (int i = 0; i < placeholders.length; i++) {
            if (placeholders[i] == nodeId) {
                return true;
            }
        }
        return false;
    }
}
