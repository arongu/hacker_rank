package aron.hacker_rank.queue.execises._2022_07_15;

import java.util.ArrayList;

public class QueueWithLinkedList {
    // node
    private static class Node {
        private Node nextNode;
        private final int n;

        public Node(final int n) {
            this.n = n;
        }

        public int getN() {
            return n;
        }
    }

    // exception
    private static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
            super();
        }
    }

    private Node head, tail;

    public void enqueue(final int n) {
        if ( head == null ) {
            head = new Node(n);
            tail = head;

        } else {
            tail.nextNode = new Node(n);
            tail = tail.nextNode;
        }
    }

    public int peek() throws EmptyQueueException {
        if ( head == null ) throw new EmptyQueueException();

        return head.n;
    }

    public int dequeue() {
        if ( head == null ) throw new EmptyQueueException();

        final int n = head.n;

        if ( head.nextNode == null ) {
            head = null;
            tail = null;

        } else {
            head = head.nextNode;
        }

        return n;
    }

    public int size() {
        int size = 0;
        for (Node node = head; node != null; node = node.nextNode ) {
            size++;
        }

        return size;
    }

    public ArrayList<Integer> toArrayList() {
        final ArrayList<Integer> arrayList = new ArrayList<>();

        for (Node node = head; node != null; node = node.nextNode ) {
            arrayList.add(node.n);
        }

        return arrayList;
    }
}
