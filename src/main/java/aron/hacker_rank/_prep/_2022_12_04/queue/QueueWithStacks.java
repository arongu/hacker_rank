package aron.hacker_rank._prep._2022_12_04.queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks<T> implements Queue<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> out = new Stack<>();

    private void shift() {
        if ( out.isEmpty() ) {
            while ( !in.isEmpty() ) {
                out.push(in.pop());
            }
        }
    }

    @Override
    public void enqueue(final T element) {
        in.push(element);
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        shift();
        try {
            return out.pop();

        } catch (final EmptyStackException ignored) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T peek() throws NoSuchElementException {
        shift();
        try {
            return out.peek();

        } catch (final EmptyStackException ignored) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean contains(final T element) {
        return in.contains(element) || out.contains(element);
    }

    @Override
    public int size() {
        return in.size() + out.size();
    }
}
