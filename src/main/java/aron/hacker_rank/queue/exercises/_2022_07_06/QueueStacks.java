package aron.hacker_rank.queue.exercises._2022_07_06;

import java.util.Stack;

public class QueueStacks<T> {
    private final Stack<T> inputStack  = new Stack<>();
    private final Stack<T> outputStack = new Stack<>();

    // shift
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
        return outputStack.isEmpty() ? null : outputStack.pop();
    }

    // peek
    public T peek() {
        shiftStack();
        return outputStack.isEmpty() ? null : outputStack.peek();
    }

    // size
    public int size() {
        return inputStack.size() + outputStack.size();
    }
}
