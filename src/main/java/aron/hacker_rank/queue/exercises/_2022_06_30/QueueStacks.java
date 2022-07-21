package aron.hacker_rank.queue.exercises._2022_06_30;

import java.util.Stack;

public class QueueStacks<T> {
    private final Stack<T> input  = new Stack<>();
    private final Stack<T> output = new Stack<>();

    private void shiftInputStack() {
        if ( output.isEmpty() ) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public void enqueue(final T value) {
        input.push(value);
    }

    public T dequeue() {
        shiftInputStack();
        return output.isEmpty() ? null : output.pop();
    }

    public T peek() {
        shiftInputStack();
        return output.isEmpty() ? null : output.peek();
    }

    public int size() {
        return input.size() + output.size();
    }
}
