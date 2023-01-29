package aron.hacker_rank._prep._2023_01_28;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> next, prev;

        public Node(final T value) {
            this.value = value;
        }
    }

    private Node<T> pointer;
    int size = 0;

    public T peek() throws EmptyStackException {
        if ( size == 0 ) throw new EmptyStackException();
        else return pointer.value;
    }

    public T pop() throws EmptyStackException {
        if ( size == 0 ) throw new EmptyStackException();

        final T value = pointer.value;
        pointer = pointer.prev;
        if ( pointer != null ) pointer.next = null;
        size--;
        return value;
    }

    public void push(final T element) {
        if ( pointer == null ) pointer = new Node<>(element);
        else {
            pointer.next = new Node<>(element);
            pointer.next.prev = pointer;
            pointer = pointer.next;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }
}
