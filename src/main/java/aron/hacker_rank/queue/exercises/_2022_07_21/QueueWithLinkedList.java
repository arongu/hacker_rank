package aron.hacker_rank.queue.exercises._2022_07_21;

import java.util.ArrayList;

public class QueueWithLinkedList {

    private static class Node {
        private final int n;
        private Node nextNode;

        public Node(final int n) {
            this.n = n;
        }
    }

    public static class EmptyQueueException extends Exception {
        public EmptyQueueException() {
            super();
        }
    }

    private Node head, tail;

    public void enqueue(final int n) {
        if ( tail == null ) {
            tail = new Node(n);
            head = tail;

        } else {
            tail.nextNode = new Node(n);
            tail = tail.nextNode;
        }
    }

    public int dequeue() throws EmptyQueueException {
        if ( head == null ) {
            tail = null;
            throw new EmptyQueueException();
        }

        final int n = head.n;
        head        = head.nextNode;

        return n;
    }

    public int peek() throws EmptyQueueException {
        if ( head == null ) {
            throw new EmptyQueueException();
        }

        return head.n;
    }

    public int size() {
        int size = 0;
        for ( Node node = head; node != null; node = node.nextNode ) size++;

        return size;
    }

    public ArrayList<Integer> toArrayList() {
        final ArrayList<Integer> list = new ArrayList<>();

        for ( Node node = head; node != null; node = node.nextNode ) list.add(node.n);

        return list;
    }
}
