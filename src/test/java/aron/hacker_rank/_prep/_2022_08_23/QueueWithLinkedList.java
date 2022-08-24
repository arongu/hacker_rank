package aron.hacker_rank._prep._2022_08_23;

import java.util.ArrayList;

public class QueueWithLinkedList<E> {
    // inner class for nodes
    private static class Node<E> {
        private Node<E> nextNode;
        private final E value;

        public Node(final E value) {
            this.value = value;
        }
    }

    // private members
    Node<E> head, tail;

    public int size() {
        int size = 0;
        for ( Node<E> it = head; it != null; it = it.nextNode, size++ );

        return size;
    }

    public E peek() {
        return head != null ? head.value : null;
    }

    public E dequeue() {
        if ( head == null ) {
            tail = null;
            return null;
        }

        final E value = head.value;
        head = head.nextNode;
        return value;
    }

    public void enqueue(final E e) {
        if ( tail == null ) {
            tail = new Node<>(e);
            head = tail;

        } else {
            tail.nextNode = new Node<>(e);
            tail = tail.nextNode;
        }
    }

    public ArrayList<E> toArrayList() {
        final ArrayList<E> arrayList = new ArrayList<>();
        for ( Node<E> it = head; it != null; it = it.nextNode ) {
            arrayList.add(it.value);
        }

        return arrayList;
    }
}
