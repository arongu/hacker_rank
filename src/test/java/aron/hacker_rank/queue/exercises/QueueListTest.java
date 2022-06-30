package aron.hacker_rank.queue.exercises;

import aron.hacker_rank.queue.execises.QueueList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueListTest {
    @Test
    public void size_shouldReturnTheSizeOfTheEnqueuedElements() {
        final QueueList<Integer> queue = new QueueList<>();
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
        final QueueList<Integer> queue = new QueueList<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);

        assertEquals(3, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(2, queue.peek());
        assertEquals(2, queue.dequeue());
        assertEquals(2, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(3, queue.peek());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(4, queue.peek());
        assertEquals(4, queue.dequeue());
        assertEquals(0, queue.size());
        System.out.println(queue.toArrayList());
    }

    @Test
    public void loopy() {
        final QueueList<Integer> queue = new QueueList<>();
        for ( int i = 0; i < 10; i++ ) {
            queue.enqueue(i);
        }

        System.out.println(queue.toArrayList());

        while (queue.size() != 0) {
            queue.dequeue();
            System.out.println(queue.toArrayList());
        }
    }
}
