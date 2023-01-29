package aron.hacker_rank._prep._2023_01_28.queue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWithStacksTest {
    @Test
    public void test() {
        final Queue<String> queue = new QueueWithStacks<>();
        assertEquals(0, queue.size());

        // subtest
        queue.enqueue("apple");
        queue.enqueue("carrot");
        queue.enqueue("milk");
        assertEquals(3, queue.size());

        // contains
        assertTrue(queue.contains("milk"));

        // peek
        assertEquals("apple", queue.peek());
        assertEquals(3, queue.size());

        // dequeue
        assertEquals("apple", queue.dequeue());
        assertEquals("carrot", queue.dequeue());
        assertEquals("milk", queue.dequeue());
        assertEquals(0, queue.size());

        // exception
        assertThrows(NoSuchElementException.class, queue::dequeue);
        assertThrows(NoSuchElementException.class, queue::peek);
    }
}
