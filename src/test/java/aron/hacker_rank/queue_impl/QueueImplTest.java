package aron.hacker_rank.queue_impl;

import aron.hacker_rank.balanced_parentheses.BalancedParenthesesLoops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueImplTest {
    @Test
    public void call() {
        final QueueWithPointers<Integer> x = new QueueWithPointers<>();
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);

        System.out.println(x.peek());
        System.out.println();

        x.show();
        System.out.println();

        System.out.println(x.dequeue());
        x.show();
        System.out.println();

        x.dequeue();
        x.show();
        System.out.println();

        x.dequeue();
        x.show();
        System.out.println();

        x.dequeue();
        x.show();
        System.out.println();
    }
}
