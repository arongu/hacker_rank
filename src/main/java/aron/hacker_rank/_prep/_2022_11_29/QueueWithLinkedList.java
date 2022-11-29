package aron.hacker_rank._prep._2022_11_29;

import java.util.ArrayList;

public class QueueWithLinkedList<T> {
    private static class Node<T> {
        final T data;
        Node<T> nextNode;

        Node(final T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;

    public void enqueue(final T element) {
        if ( tail == null ) {
            tail = new Node<>(element);
            head = tail;

        } else {
            tail.nextNode = new Node<>(element);
            tail = tail.nextNode;
        }
    }

    public T peek() {
        return head != null ? head.data : null;
    }

    public T dequeue() {
        if ( head == null ) {
            tail = null;
            return null;

        } else {
            final T data = head.data;
            head = head.nextNode;
            return data;
        }
    }

    int size() {
        int size = 0;
        for ( Node<T> ptr = head; ptr != null; ptr = ptr.nextNode)
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
