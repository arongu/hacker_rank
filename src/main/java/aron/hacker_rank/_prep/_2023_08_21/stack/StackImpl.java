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

    private Node<T> current;
    private int size = 0;

    @Override
    public void push( final T element ) {
        if ( current == null ) {
            current = new Node <>(null, element);

        } else {
            current = current.addNext(element);
        }

        size++;
    }

    @Override
    public T peek()
    throws EmptyStackException {
        if ( current == null ) throw new EmptyStackException();

        return current.value;
    }

    @Override
    public T pop()
    throws EmptyStackException {
        if ( current == null ) throw new EmptyStackException();

        final T value = current.value;

        if ( current.prev == null ) current = null;
        else {
            final Node<T> newCurrent = current.prev;
            current.prev = null;
            current.next = null;

            current = newCurrent;
        }

        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return current == null;
    }

    @Override
    public boolean contains( T element ) {
        for ( Node<T> ptr = current; ptr != null; ) {
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
