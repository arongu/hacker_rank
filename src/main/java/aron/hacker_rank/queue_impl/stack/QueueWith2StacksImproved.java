package aron.hacker_rank.queue_impl.stack;

import java.util.Stack;

public class QueueWith2StacksImproved<T> {
    private final Stack<T> inputStack  = new Stack<>();
    private final Stack<T> outputStack = new Stack<>();

    private void shiftStack() {
        if ( outputStack.isEmpty() ) {
            while ( ! inputStack.isEmpty() ) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    // enqueue
    public void enqueue(final T value) {
        inputStack.push(value);
    }

    // dequeue
    public T dequeue() {
        shiftStack();
        return outputStack.pop();
    }

    // peek
    public T peek() {
        shiftStack();
        return outputStack.peek();
    }

    // size
    public int size() {
        return inputStack.size() + outputStack.size();
    }
}
