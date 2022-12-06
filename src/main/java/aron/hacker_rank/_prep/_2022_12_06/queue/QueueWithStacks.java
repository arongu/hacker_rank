package aron.hacker_rank._prep._2022_12_06.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks<T> implements Queue<T> {
    private final Stack<T> in  = new Stack<>();
    private final Stack<T> out = new Stack<>();

    private void shift() {
        if ( out.isEmpty() ) {
            while ( !in.isEmpty() ) {
                out.push(in.pop());
            }
        }
    }

    @Override
    public int size() {
        return in.size() + out.size();
    }

    @Override
    public boolean contains(final T value) {
        return in.contains(value) || out.contains(value);
    }

    @Override
    public void enqueue(final T value) {
        in.push(value);
    }

    @Override
    public T peek() throws NoSuchElementException {
        shift();
        if ( out.isEmpty() ) throw new NoSuchElementException();
        else return out.peek();
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        shift();
        if ( out.isEmpty() ) throw new NoSuchElementException();
        else return out.pop();
    }
}
