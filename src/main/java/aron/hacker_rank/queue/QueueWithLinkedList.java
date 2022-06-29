package aron.hacker_rank.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueWithLinkedList<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> nextNode;

        public Node(final Node<T> nextNode, final T value) {
            this.nextNode = nextNode;
            this.value = value;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;

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
        if ( head == null ) {
            tail = null;
            return null;

        } else {
            final T value = head.value;    // get value, before deleting the old head
            head = head.nextNode;          // the next element will be the new head

            return value;  // return the value
        }
    }

    public T peek() {
        return head.value;
    }

    public int size() {
        int size = 0;
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            size++;
        }

        return size;
    }

    public List<T> toArrayList(){
        final List<T> list = new ArrayList<>();

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            list.add(ptr.value);
        }

        return list;
    }
}
