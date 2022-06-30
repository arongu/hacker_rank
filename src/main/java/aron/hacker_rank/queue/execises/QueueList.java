package aron.hacker_rank.queue.execises;

import java.util.ArrayList;

public class QueueList<T> {
    private static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        public Node(final Node<T> nextNode, final T value) {
            this.nextNode = nextNode;
            this.value    = value;
        }
    }

    private Node<T> head, tail;

    public void enqueue(final T value) {
        final Node<T> node = new Node<>(null, value);

        if ( tail != null ) {
            tail.nextNode = node;
            tail = node;

        } else {
            tail = node;
            head = tail;
        }
    }

    public T dequeue() {
        final T value;

        if ( head == null ) {
            value = null;
            tail  = null;
        } else {
            value = head.value;
            head  = head.nextNode;
        }

        return value;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    public int size() {
        int size = 0;

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            size++;
        }

        return size;
    }

    public ArrayList<T> toArrayList() {
        final ArrayList<T> arrayList = new ArrayList<>();

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            arrayList.add(ptr.value);
        }

        return arrayList;
    }
}
