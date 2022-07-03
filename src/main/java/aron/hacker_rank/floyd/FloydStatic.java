package aron.hacker_rank.floyd;

import java.util.Random;

public final class FloydStatic {
    public static <T> Node<T> advanceOne (final Node<T> node) {
        return node != null ? node.getNextNode() : null;
    }

    public static <T> Node<T> advanceTwo (final Node<T> node) {
        return advanceOne(advanceOne(node));
    }

    public static Node<Integer> createNodeListWithIntegers(final int size) {
        Node<Integer> head = null, ptr;

        if ( size > 0 ) {
            head = new Node<Integer>(null, 0);
            ptr = head;

            for ( int i = 1; i < size; i++ ) {
                ptr.setNextNode(new Node<>(null, i));
                ptr = ptr.getNextNode();
            }
        }

        return head;
    }

    public static <T> int getSize(final Node<T> head) {
        int size = 0;
        if ( head != null && ! hasLoop(head) ) {
            for ( Node<T> ptr = head; ptr != null; ptr = ptr.getNextNode() ) {
                size++;
            }
        }

        return size;
    }

    public static <T> Node<T> getTail(final Node<T> head) {
        if ( head != null && ! hasLoop(head) ) {
            Node<T> tail = head;

            while ( tail.getNextNode() != null ) {
                tail = tail.getNextNode();
            }

            return tail;
        }

        return null;
    }

    public static <T> Node<T> addLoop(final Node<T> head) {
        if ( !hasLoop(head) ) {
            int size    = getSize(head);
            int loopPos = new Random().nextInt(size);

            Node<T> loopEntry = head;
            Node<T> tail = getTail(head);

            for ( int i = 0; i < loopPos; i++ ) {
                loopEntry = head.getNextNode();
            }

            tail.setNextNode(loopEntry);
            System.out.println("loopEntry will be at pos " + loopPos);
            return loopEntry;
        }

        return null;
    }

    public static <T> boolean hasLoop(final Node<T> head) {
        if ( head == null ) return false;

        Node<T> slow = advanceOne(head);
        Node<T> fast = advanceTwo(head); // advanceOne(Slow) - would work here, but only here

        while ( slow != null && fast != null ) {
            if ( fast == slow ) {
                return true;
            }

            slow = advanceOne(slow);
            fast = advanceTwo(fast);
        }

        return false;
    }
}
