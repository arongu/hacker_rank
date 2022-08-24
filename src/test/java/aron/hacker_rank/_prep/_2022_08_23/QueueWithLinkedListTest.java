package aron.hacker_rank._prep._2022_08_23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueWithLinkedListTest {

    @Test
    public void size_shouldReturnTheSizeOfTheEnqueuedElements() {
        final QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
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
        final QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
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
        final QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
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
