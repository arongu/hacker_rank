package aron.hacker_rank.queue.execises._2022_07_06;

import java.util.ArrayList;

public class QueueList<T> {

    private static class Node<T> {
        private Node<T> nextNode;
        private final T value;

        public Node(T value) {
            this.value = value;
        }
    }


    private Node<T> head, tail;

    public void enqueue(final T value) {
        if ( tail == null ) {
            tail = new Node<>(value);
            head = tail;

        } else {
            tail.nextNode = new Node<>(value);
            tail = tail.nextNode;
        }
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    public T dequeue() {
        if ( head != null ) {
            final T value = head.value;
            head = head.nextNode;
            return value;

        } else {
            tail = null;
            return null;
        }
    }

    public int size() {
        int size = 0;
        for ( Node<T> node = head; node != null; node = node.nextNode ) {
            size ++;
        }

        return size;
    }

    public ArrayList<T> toArrayList() {
        final ArrayList<T>arrayList = new ArrayList<T>();

        for ( Node<T> node = head; node != null; node = node.nextNode ) {
            arrayList.add(node.value);
        }

        return arrayList;
    }
}
