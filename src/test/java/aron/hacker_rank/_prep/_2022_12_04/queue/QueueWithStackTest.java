package aron.hacker_rank._prep._2022_12_04.queue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWithStackTest {
    @Test
    public void test() {
        final Queue<String> queue = new QueueWithStacks<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");

        // basics
        assertTrue(queue.contains("four"));
        assertFalse(queue.contains("xxx"));
        assertEquals(4, queue.size());

        // peek
        assertEquals("one", queue.peek());
        assertEquals(4, queue.size());
        assertTrue(queue.contains("one"));

        // dequeue
        assertEquals("one", queue.dequeue());
        assertEquals(3, queue.size());
        assertFalse(queue.contains("one"));

        assertEquals("two", queue.dequeue());
        assertEquals(2, queue.size());
        assertFalse(queue.contains("two"));

        assertEquals("three", queue.dequeue());
        assertEquals(1, queue.size());
        assertFalse(queue.contains("three"));

        assertEquals("four", queue.dequeue());
        assertEquals(0, queue.size());
        assertFalse(queue.contains("four"));

        // throw
        assertThrows(NoSuchElementException.class, queue::peek);
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }
}
