package aron.hacker_rank.queue_impl.list;

import java.util.ArrayList;
import java.util.List;

public class QueueWithoutFirstNode<T> {
    private static class Node<T> {
        private T value;
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
            return null;
        } else {
            final T dequeueValue   = head.value;    // get value, before deleting the old head
            final Node<T> nextNode = head.nextNode; // the next element will be the new head

            head.nextNode = null; // detach head from the node tree, thus deleting it - gc will take care of it
            head = nextNode;      // make the next element the new head

            return dequeueValue;  // return the value 
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
