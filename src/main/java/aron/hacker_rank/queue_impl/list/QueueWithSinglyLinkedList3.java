package aron.hacker_rank.queue_impl.list;

import java.util.ArrayList;

public class QueueWithSinglyLinkedList3<T> {
    private static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        public Node(final T value, final Node<T> nextNode) {
            this.value    = value;
            this.nextNode = nextNode;
        }
    }


    private Node<T> head, tail;

    // enqueue (append to tail)
    public void enqueue(final T value) {
        if ( tail == null ) {
            tail = new Node<>(value, null);
            head = tail;

        } else {
            tail.nextNode = new Node<T>(value, null);
            tail = tail.nextNode;
        }
    }

    // peek (get element from head)
    public T peek() {
        return head != null ? head.value : null;
    }

    // dequeue (get element from head and remove it)
    public T dequeue() {
        if ( head == null ) {
            return null;

        } else {
            final T valueToBeDequeued = head.value;
            final Node<T> nextToHead  = head.nextNode;

            head.nextNode = null;
            head = nextToHead;

            return valueToBeDequeued;
        }
    }

    // size
    public int size() {
        int size = 0;

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            size++;
        }

        return size;
    }

    // toArrayList
    public ArrayList<T> toArrayList() {
        final ArrayList<T> arrayList = new ArrayList<>();

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            arrayList.add(ptr.value);
        }

        return arrayList;
    }
}
