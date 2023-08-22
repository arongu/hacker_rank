package aron.hacker_rank._prep._2023_08_21.queue;

import java.util.NoSuchElementException;
import java.util.Objects;

public class QueueWithNodes2<T> implements Queue<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> nextNode;

        public Node( final T value ) {
            this.value = value;
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains( final T value ) {
        for ( Node<T> ptr = head; ptr != null; ) {
            if ( Objects.equals(value, ptr.value) ) return true;
            ptr = ptr.nextNode;
        }

        return false;
    }

    @Override
    public void enqueue( final T value ) {
        if ( tail == null ) {
            tail = new Node<>(value);
            head = tail;

        } else {
            tail.nextNode = new Node <>(value);
            tail = tail.nextNode;
        }

        size++;
    }

    @Override
    public T peek()
    throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public T dequeue()
    throws NoSuchElementException {
        if ( head == null ) throw new NoSuchElementException();
        final T value = head.value;
        head = head.nextNode;
        size--;

        return value;
    }
}
