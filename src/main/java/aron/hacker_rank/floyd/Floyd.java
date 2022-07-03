package aron.hacker_rank.floyd;

import java.util.Random;

public class Floyd {
    public static class Node {
        private Node nextNode;
    }

    private Node head;

    public Node getHead() {
        return head;
    }

    public Node advanceOne(final Node node) {
        if ( node != null && node.nextNode != null ) {
            return node.nextNode;
        }

        return null;
    }

    public Node advanceTwo(final Node node) {
        Node ptr = advanceOne(node);
        return advanceOne(ptr);
    }

    public void resetLoop(final int size) {
        int loopStartIndex  = new Random().nextInt(size);
        System.out.println("loopStartIndex = " + loopStartIndex);

        this.head   = new Node();
        Node ptr, loopEntry = null;
        ptr = head;

        for ( int i = 0; i < size; i++ ) {
            ptr.nextNode = new Node();

            if ( i == loopStartIndex ) {
                loopEntry = ptr;
            }

            ptr = ptr.nextNode;
        }

        ptr.nextNode = loopEntry;
    }

    public void resetNoLoop(int size) {
        this.head   = new Node();
        Node ptr = head;

        for ( int i = 0; i < size; i++ ) {
            ptr.nextNode = new Node();
            ptr = ptr.nextNode;
        }
    }

    public boolean hasCycle(final Node node) {
        if ( head == null ) return false;

        Node slow = advanceOne(node);
        Node fast = advanceTwo(node);
        while ( fast != null && slow != null ) {
            if ( fast == slow ) {
                return true;
            }

            fast = advanceTwo(fast);
            slow = advanceOne(slow);
        }

        return false;
    }
}
