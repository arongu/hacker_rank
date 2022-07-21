package aron.hacker_rank.queue.exercises._2022_06_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueStacksTest {
    @Test
    public void size_shouldReturnTheSizeOfTheEnqueuedElements() {
        final QueueStacks<Integer> queue = new QueueStacks<>();
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
        final QueueStacks<Integer> queue = new QueueStacks<>();
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
}
