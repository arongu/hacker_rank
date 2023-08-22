package aron.hacker_rank._prep._2023_08_21.stack;

import java.util.EmptyStackException;
import java.util.Objects;

public class StackImpl<T> implements Stack <T> {
    private static class Node<T> {
        private Node <T> next, prev;
        private final T value;

        private Node( final Node <T> prev, final T value ) {
            this.prev = prev;
            this.value = value;
        }

        private Node<T> addNext( final T value ) {
            next = new Node <>(this, value);
            return next;
        }
    }

    private Node<T> head;
    private int     size = 0;

    @Override
    public void push( final T element ) {
        if ( head == null ) {
            head = new Node <>(null, element);

        } else {
            head = head.addNext(element);
        }

        size++;
    }

    @Override
    public T peek()
    throws EmptyStackException {
        if ( head == null ) throw new EmptyStackException();

        return head.value;
    }

    @Override
    public T pop()
    throws EmptyStackException {
        if ( head == null ) throw new EmptyStackException();

        final T value = head.value;

        if ( head.prev == null ) head = null;
        else {
            final Node<T> newHead;
            newHead = head.prev; // moving pointer to previous node
            newHead.next = null;    // set previous node's next to null, so it will not point to the 'deleted' node

            head.prev = null; // deleted node no longer point to prev node
            head.next = null; // or forward

            head = newHead; // set the previous node to be the current HEAD
        }

        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains( T element ) {
        for ( Node<T> ptr = head; ptr != null; ) {
            if ( Objects.equals(element, ptr.value) ) return true;
            else {
                ptr = ptr.next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
