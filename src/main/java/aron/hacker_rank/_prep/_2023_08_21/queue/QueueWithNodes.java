package aron.hacker_rank._prep._2023_08_21.queue;

import java.util.NoSuchElementException;

public class QueueWithNodes<T> implements Queue<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> nextNode;

        public Node( final T value, final Node <T> nextNode ) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains( final T value ) {
        for ( Node<T> current = head; current != null; ) {
            if ( value.equals(current.value) ) {
                return true;
            } else {
                current = current.nextNode;
            }
        }

        return false;
    }

    @Override
    public void enqueue( final T value ) {
        if ( tail == null ) {
            head = new Node<>(value, null);
            tail = head;
        } else {
            tail.nextNode = new Node <>(value, null);
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

        T value = head.value;
        head = head.nextNode;
        size--;

        return value;
    }
}
