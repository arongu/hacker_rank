package aron.hacker_rank.queue_impl;

import java.util.Stack;

public class QueueWith2Stacks<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> out = new Stack<>();

    private void moveInputToOutput() {
        while ( ! in.isEmpty() ) {
            out.push(in.pop());
        }
    }

    public void enqueue(final T value) { // add item
        // if there are elements in the output stack move them back into the input stack to keep the proper ordering
        while ( ! out.isEmpty() ) {
            in.push(out.pop());
        }

        // push the last element in the queue on the top of the input stack
        in.push(value);
    }

    public T peek() { // get the oldest item, or the item that put first in
        // if the output stack is empty move the elements from input stack -> output stack
        if ( out.isEmpty() ) {
            moveInputToOutput();
        }

        return out.peek();
    }

    public T dequeue() { // get the oldest item, or the item that put first in
        if ( out.isEmpty() ) {
            moveInputToOutput();
        }

        return out.pop();
    }

    public int size() {
        return in.size() + out.size();
    }
}
