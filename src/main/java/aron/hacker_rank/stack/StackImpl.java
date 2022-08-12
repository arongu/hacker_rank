package aron.hacker_rank.stack;

public class StackImpl<E> {

    private static class Node<E> {
        private Node<E> next = null, previous = null;
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

        final E popped   = head.element;
        Node<E> new_head = head.previous;
        if ( new_head != null ) {
            new_head.next = null;
        }

        head = new_head;
        size--;
        return popped;
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
