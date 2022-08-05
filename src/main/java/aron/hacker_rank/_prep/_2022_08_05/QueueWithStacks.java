package aron.hacker_rank._prep._2022_08_05;

import java.util.Stack;

public class QueueWithStacks<T> {
    private final Stack<T> input  = new Stack<>();
    private final Stack<T> output = new Stack<>();

    private void shiftStacks() {
        if ( output.isEmpty() ) {
            while ( ! input.isEmpty() )
                output.push(input.pop());
        }
    }

    public void enqueue(final T t) {
        input.push(t);
    }

    public T peek() {
        shiftStacks();
        return output.isEmpty() ? null : output.peek();
    }

    public T dequeue() {
        shiftStacks();
        return output.isEmpty() ? null : output.pop();
    }

    public int size() {
        return input.size() + output.size();
    }
}
