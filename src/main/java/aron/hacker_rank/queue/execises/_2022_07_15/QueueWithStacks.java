package aron.hacker_rank.queue.execises._2022_07_15;

import java.util.Stack;

public class QueueWithStacks<Integer> {
    private final Stack<java.lang.Integer> in = new Stack<java.lang.Integer>();
    private final Stack<java.lang.Integer> ou = new Stack<>();

    private void shift() {
        if ( ou.isEmpty() && !in.isEmpty()) {
            while ( ! in.isEmpty() ) {
                ou.push(in.pop());
            }
        }
    }

    public void enqueue(final int n) {
        in.push(n);
    }

    public int dequeue() {
        shift();
        return ou.pop();
    }

    public int peek() {
        shift();
        return ou.peek();
    }

    public int size() {
        return in.size() + ou.size();
    }
}
