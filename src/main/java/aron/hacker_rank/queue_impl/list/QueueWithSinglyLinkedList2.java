package aron.hacker_rank.queue_impl.list;

import java.util.ArrayList;

public class QueueWithSinglyLinkedList2<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> nextNode;

        public Node(final Node<T> nextNode, final T value) {
            this.nextNode = nextNode;
            this.value = value;
        }
    }

    private Node<T> head, tail;

    public void enqueue(final T value) {
        if ( tail == null ) {
            tail = new Node<>(null, value);
            head = tail;
        } else {
            tail.nextNode = new Node<>(null, value);
            tail = tail.nextNode;
        }
    }

    public T dequeue() {
        if ( head != null ) {
            final T value = head.value;
            final Node<T> nextNode = head.nextNode;

            head.nextNode = null;
            head = nextNode;
            return value;
        }

        return null;
    }

    public T peek() {
        if ( head != null) {
            return head.value;
        }

        return null;
    }

    public int size() {
        int size = 0;
        if ( head != null ) {
            for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
                size++;
            }
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
