package aron.hacker_rank.queue_impl.list;

import aron.hacker_rank.queue_impl.list.QueueWithSinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueWithSinglyLinkedListTest {
    @Test
    public void size_shouldReturnTheSizeOfTheEnqueuedElements() {
        final QueueWithSinglyLinkedList<Integer> queue = new QueueWithSinglyLinkedList<>();
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
        final QueueWithSinglyLinkedList<Integer> queue = new QueueWithSinglyLinkedList<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(1, queue.peek());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(2, queue.peek());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.size());
        System.out.println(queue.toArrayList());

        assertEquals(3, queue.peek());
        assertEquals(3, queue.dequeue());
        assertEquals(0, queue.size());
        System.out.println(queue.toArrayList());
    }

    @Test
    public void loopy() {
        final QueueWithSinglyLinkedList<Integer> queue = new QueueWithSinglyLinkedList<>();
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
