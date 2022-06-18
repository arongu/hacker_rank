package aron.hacker_rank.queue_impl;

import java.util.ArrayList;
import java.util.List;

public class QueueWithPointers<T> {
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

    public QueueWithPointers(){
        head = new QueueWithPointers.Node<>(null, null, null); // create a singular chain
        tail = head; // this chain can have two nodes, make this node both head and tail, root node if you will
    }

    public void enqueue(final T value){ // add item
        // because there is always a node, the root node -- when there is only 1 node, both
        // head and tail points to the same node
        // if tail.value is null it means there is no value added yet
        if ( tail.value == null ) {
            tail.value = value;
        } else {
            // if the tail has a value, a new node will be appended and become the new tail
            final Node<T> node = new Node<>(tail, null, value); // create new node, pointing it to the previous tail
            tail.next = node; // tail's next will point to the new node
            tail      = node; // the added node will become the new tail
        }
    }

    public T peek() { // get the oldest item, or the item that put first in
        return head.value; // head is always the old, all the elements will appended next to it
    }

    public T dequeue() { // get the oldest item, and remove it
        final T value = head.value; // store value
        if ( head == tail ) {       // if head and tail matches there is only 1 element in the queue or none
            head.value = null;      // "delete" value by making it null
        } else {
            head = head.next;
            head.previous = null;
        }

        return value;
    }

    public int size(){
        int size = 0;
        for ( Node<T> node = head; node != null; node = node.next ) {
            size++;
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

    public void show(){
        Node<T> node = head;

        while (node != null) {
            if ( node.value != null) {
                System.out.println(node.value);
            }
            node = node.next;
        }
    }
}
