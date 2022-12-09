package aron.hacker_rank._prep._2022_12_06;

public class MyStack<T> {
    private static class Node<T> {
        private Node<T> prev, next;
        private final T value;

        private Node(final T value) {
            this.value = value;
        }

        private Node(final T value, final Node<T> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    private Node<T> stackPointer;
    private int size = 0;

    public T peek() {
        return stackPointer != null ? stackPointer.value : null;
    }

    public T pop() {
        if ( stackPointer == null ) return null;

        final T value = stackPointer.value;
        stackPointer = stackPointer.prev;

        if ( stackPointer != null ) stackPointer.next = null;
        size--;
        return value;
    }

    public void push(final T element) {
       if ( stackPointer == null ) {
           stackPointer = new Node<>(element, null);
           size++;

       } else {
           stackPointer.next = new Node<>(element, stackPointer);
           stackPointer = stackPointer.next;
           size++;
       }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return stackPointer == null;
    }
}
