package aron.hacker_rank._prep._2022_08_05;

import java.util.ArrayList;

public class QueueWithLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(final T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;

    public void enqueue(final T t) {
        if ( tail == null ) {
            tail = new Node<>(t);
            head = tail;

        } else {
            tail.nextNode = new Node<>(t);
            tail = tail.nextNode;
        }
    }

    public T peek() {
        return head != null ? head.data : null;
    }

    public T dequeue() {
        if ( head != null ) {
            final T data = head.data;
            head = head.nextNode;
            return data;

        } else {
            tail = null;
            return null;
        }
    }

    public int size() {
        int size = 0;
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode )
            size++;

        return size;
    }

    public ArrayList<T> toArrayList() {
        final ArrayList<T> arrayList = new ArrayList<>();

        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode ) {
            arrayList.add(ptr.data);
        }

        return arrayList;
    }
}
