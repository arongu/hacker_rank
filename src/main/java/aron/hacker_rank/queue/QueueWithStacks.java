package aron.hacker_rank.queue;

import java.util.Stack;

public class QueueWithStacks<T> {
    private final Stack<T> input  = new Stack<>();
    private final Stack<T> output = new Stack<>();

    private void fillUpOutputStack() {
        if ( output.isEmpty() ) {
            while ( ! input.isEmpty() ) {
                output.push(input.pop());
            }
        }
    }

    // enqueue
    public void enqueue(final T value) {
        input.push(value);
    }

    // dequeue
    public T dequeue() {
        fillUpOutputStack();
        return output.isEmpty() ? null : output.pop();
    }

    // peek
    public T peek() {
        fillUpOutputStack();
        return output.isEmpty() ? null : output.peek();
    }

    // size
    public int size() {
        return input.size() + output.size();
    }
}
