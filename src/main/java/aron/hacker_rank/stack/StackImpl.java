package aron.hacker_rank.stack;

public class StackImpl<E> {

    private static class Node<E> {
        private Node<E> next, previous;
        private final E element;

        private Node(final E element) {
            this.element = element;
        }
    }

    private Node<E> head = null;
    private int size = 0;

    public void push(final E element) {
        if ( head == null ) {
            head = new Node<>(element);

        } else {
            head.next = new Node<>(element);
            head.next.previous = head;
            head = head.next;
        }

        size++;
    }

    public E pop() {
        if ( head == null ) return null;

        final E element = head.element;
        Node<E> previous = head.previous;
        if ( previous != null ) {
            previous.next = null;
        }

        head = previous;
        size--;
        return element;
    }

    public E peek() {
        return head != null ? head.element : null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
