package aron.hacker_rank.queue_impl;

import java.util.ArrayList;
import java.util.List;

public class QueueWithDoublyLinkedList<T> {
    private static class Node<T> {
        private Node<T> previous;
        private Node<T> next;
        private T value;

        public Node(){}
        public Node(final Node<T> previous, final Node<T> next, final T value){
            this.previous = previous;
            this.next     = next;
            this.value    = value;
        }
    }

    private Node<T> head, tail;

    public QueueWithDoublyLinkedList(){
        head = new QueueWithDoublyLinkedList.Node<>(null, null, null); // create a root node
        tail = head; // tail and head both points to the root node
    }

    public void enqueue(final T value){ // add item
        if ( tail.value == null ) { // if tail.value is null it means there is no value added yet
            tail.value = value;
        } else {
            // if the tail has a value, a new node will be appended and become the new tail
            final Node<T> node = new Node<>(tail, null, value); // create a node pointing to the previous tail
            tail.next = node; // tail's next pointer will point to the new tail
            tail      = node; // replace the old tail with the new one
        }
    }

    public T peek() { // get the oldest item, or the item that put first in
        return head.value;
    }

    public T dequeue() { // get the oldest item, and remove it
        final T value = head.value; // store value
        if ( head == tail ) {       // if head and tail matches there is only 1 the root node (root node never gets deleted)
            head.value = null;      // remove the value by making it null
        } else {
            head = head.next;
            head.previous = null;
        }

        return value;
    }

    public int size(){
        int size = 0;
        for ( Node<T> node = head; node != null; node = node.next ) {
            if ( node.value != null ) {
                size++;
            }
        }

        return size;
    }

    public List<T> toArrayList(){
        final ArrayList<T> arrayList = new ArrayList<>();

        Node<T> node = head;
        while ( node != null ) {
            arrayList.add(node.value);
            node = node.next;
        }

        return arrayList;
    }
}
