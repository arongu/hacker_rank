package aron.hacker_rank.queue_impl.list;

import java.util.ArrayList;
import java.util.List;

public class QueueWithSinglyLinkedList<T> {
    private static class Node<T> {
        private T value;
        private Node<T> nextNode;

        public Node(final Node<T> nextNode, final T value) {
            this.nextNode = nextNode;
            this.value = value;
        }
    }

    private Node<T> head, tail;

    public QueueWithSinglyLinkedList() {
        head = new Node<T>(null, null);
        tail = head;
    }

    public void enqueue(final T value){ // put the element at the end of the queue
        if ( tail.value == null ) {
            tail.value = value;
        } else {
            final Node<T> newTail = new Node<>(null, value);
            tail.nextNode = newTail;
            tail = newTail;
        }
    }

    public T dequeue() { // get the element from the front of the queue, and remove it (oldest)
        final T value = head.value;
        if ( head.nextNode == null ) {
            head.value = null;
        } else {
            final Node<T> newHead = head.nextNode;
            head.nextNode = null; // detach head from the chain, thus removing it
            head = newHead;
        }

        return value;
    }

    public T peek() {
        return head.value;
    }

    public int size() {
        int size = 0;

        for (Node<T> ptr = head; ptr != null; ptr = ptr.nextNode) {
            if ( ptr.value != null) {
                size++;
            }
        }

        return size;
    }

    public List<T> toArrayList(){
        final ArrayList<T> arrayList = new ArrayList<>();
        for (Node<T> ptr = head; ptr != null; ptr = ptr.nextNode) {
            arrayList.add(ptr.value);
        }

        return arrayList;
    }
}
