package aron.hacker_rank._prep._2022_11_29;

import java.util.Stack;

public class QueueWithStacks<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> ou = new Stack<>();

    private void shift() {
        if ( ou.isEmpty() && !in.isEmpty() ) {
            while ( !in.isEmpty() )
                ou.push(in.pop());
        }
    }

    public void enqueue(final T data) {
        in.push(data);
    }

    public T dequeue() {
        shift();
        return ou.isEmpty() ? null : ou.pop();
    }

    public T peek() {
        shift();
        return ou.isEmpty() ? null : ou.peek();
    }

    public int size() {
        return in.size() + ou.size();
    }
}
