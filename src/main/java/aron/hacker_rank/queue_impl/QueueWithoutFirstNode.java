package aron.hacker_rank.queue_impl;

import java.util.ArrayList;
import java.util.List;

public class QueueWithoutFirstNode<T> {
    private static class Node<T>{
        private T value;
        private Node<T> nextNode;

        public Node(final Node<T> nextNode, final T value){
            this.nextNode = nextNode;
            this.value = value;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;

    public void enqueue(final T value){
        if ( tail == null ) {
            tail = new Node<>(null, value);
            head = tail;
        } else {
            tail.nextNode = new Node<>(null, value);
            tail = tail.nextNode;
        }
    }

    public T dequeue(){
        if ( head == null ){
            return null;
        } else {
            final T value = head.value; // get value
            final Node<T> nextToHead = head.nextNode; // the next element will be the head

            head.nextNode = null; // detach head from the nood tree
            head = nextToHead;    // make the next element the new head

            return value;
        }
    }

    public T peek(){
        return head.value;
    }

    public int size() {
        int size = 0;
        for (Node<T> ptr = head; ptr != null; ptr = ptr.nextNode) {
            size++;
        }

        return size;
    }

    public List<T> toArrayList(){
        final List<T> list = new ArrayList<>();

        for (Node<T> ptr = head; ptr != null; ptr = ptr.nextNode) {
            list.add(ptr.value);
        }

        return list;
    }
}
