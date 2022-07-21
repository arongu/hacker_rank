package aron.hacker_rank.queue.exercises._2022_07_21;

import java.util.Stack;

public class QueueWithStacks<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> ou = new Stack<>();

    private void shift() {
        if ( ou.isEmpty() ) {
            while ( !in.isEmpty() ) {
                ou.push(in.pop());
            }
        }
    }

    public void enqueue(final T v) {
        in.push(v);
    }

    public T dequeue() {
        shift();
        return ou.pop();
    }

    public T peek() {
        shift();
        return ou.peek();
    }

    public int size() {
        return in.size() + ou.size();
    }
}
