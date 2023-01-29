package aron.hacker_rank._prep._2023_01_28.queue;

import java.util.NoSuchElementException;

/*
 in front when dequeue
 end when enqueue
 */

public class QueueWithNodes<T> implements Queue<T> {
    private static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        public Node(final T value) {
            this.value = value;
        }
    }

    // queue
    private Node<T> head, tail;
    private int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(final T value) {
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            if ( ptr.value != null && ptr.value.equals(value) ) return true;
        }

        return false;
    }

    @Override
    public void enqueue(final T value) {
        if ( tail == null ) {
            tail = new Node<>(value);
            head = tail;

        } else {
            tail.nextNode = new Node<>(value);
            tail = tail.nextNode;
        }

        size++;
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

        final T value = head.value; // save value
        final Node<T> newHead = head.nextNode; // save next node to be the new head node
        head.nextNode = null; // remove the nextNode value of the current node for GC
        head = newHead; // set the newHead to be the head
        size--;
        return value;
    }
}
