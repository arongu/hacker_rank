package aron.hacker_rank._prep._2022_08_23;

import java.util.Stack;

public class QueueWithStacks<E> {
    private final Stack<E> in;
    private final Stack<E> out;

    private void shift() {
        if ( out.isEmpty() ) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public QueueWithStacks() {
        in  = new Stack<>();
        out = new Stack<>();
    }

    public int size() {
        return in.size() + out.size();
    }

    // add @end
    public void enqueue(final E e) {
        in.push(e);
    }

    // peek
    public E peek() {
        shift();
        return out.peek();
    }

    // add @head
    public E dequeue() {
        shift();
        return out.pop();
    }
}
