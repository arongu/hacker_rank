package aron.hacker_rank._prep._2022_12_06.queue;

import java.util.NoSuchElementException;

public class QueueWithNodes<T> implements Queue<T> {
    // static
    private static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        private Node(final T value) {
            this.value = value;
        }
    }

    private Node<T> head, tail;

    @Override
    public int size() {
        int size = 0;
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            size++;
        }

        return size;
    }

    @Override
    public boolean contains(final T value) {
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            if ( value.equals(ptr.value) ) return true;
        }

        return false;
    }

    @Override
    public void enqueue(final T value) {
        if ( tail == null ) {
            tail = new Node<>(value);
            head = tail;

        } else {
            tail = tail.nextNode = new Node<>(value);
        }
    }

    @Override
    public T peek() throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        else return head.value;
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
}
