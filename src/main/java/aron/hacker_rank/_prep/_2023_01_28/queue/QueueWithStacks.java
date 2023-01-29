package aron.hacker_rank._prep._2023_01_28.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks<T> implements Queue<T> {
    private final Stack<T> input  = new Stack<>();
    private final Stack<T> output = new Stack<>();

    private void shift() {
        if ( output.isEmpty() ) {
            while ( ! input.isEmpty() ) {
                output.push(input.pop());
            }
        }
    }

    @Override
    public int size() {
        return input.size() + output.size();
    }

    @Override
    public boolean contains(final T value) {
        return input.contains(value) || output.contains(value);
    }

    @Override
    public void enqueue(final T value) {
        input.push(value);
    }

    @Override
    public T peek() throws NoSuchElementException {
        shift();
        if ( output.isEmpty() ) throw new NoSuchElementException();
        else return output.peek();
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        shift();
        if ( output.isEmpty() ) throw new NoSuchElementException();
        else return output.pop();
    }
}
