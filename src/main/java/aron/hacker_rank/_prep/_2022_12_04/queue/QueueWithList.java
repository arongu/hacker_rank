package aron.hacker_rank._prep._2022_12_04.queue;

import java.util.NoSuchElementException;

public class QueueWithList<T> implements Queue<T> {
    private static class Node<T> {
        T value;
        Node<T> nextNode;

        public Node(final T value) {
            this.value = value;
        }
    }

    private Node<T> head, tail;

    @Override
    public void enqueue(final T element) {
        if ( tail == null ) {
            tail = new Node<>(element);
            head = tail;

        } else {
            tail.nextNode = new Node<>(element);
            tail = tail.nextNode;
        }
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if ( head == null ) {
            tail = null;
            throw new NoSuchElementException();
        }

        final T value = head.value;
        head = head.nextNode;

        return value;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public boolean contains(final T element) {
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            if ( ptr.value.equals(element) ) return true;

        }

        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode )
            size++;

        return size;
    }
}
