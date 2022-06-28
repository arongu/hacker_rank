package aron.hacker_rank.queue_impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueWith2StacksTest {
    @Test
    public void size_shouldReturnTheSizeOfTheEnqueuedElements() {
        final QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.enqueue(3);
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
    }

    @Test
    public void comprehensiveTest() {
        final QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);

        assertEquals(3, queue.size());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals(3, queue.peek());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(4, queue.peek());
        assertEquals(4, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void loopy() {
        final QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();
        for ( int i = 0; i < 10; i++ ) {
            queue.enqueue(i);
        }

        while (queue.size() != 0) {
            int n = queue.dequeue();
            System.out.println(n);
        }
    }
}
