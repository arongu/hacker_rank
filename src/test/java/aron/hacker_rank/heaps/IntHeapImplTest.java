package aron.hacker_rank.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntHeapImplTest {
    @Test
    void testMinMode() {
        final IntHeap intHeap = new IntHeapImpl(false);

        intHeap.add(10);
        assertEquals(10, intHeap.peek());
        assertEquals(1, intHeap.size());

        intHeap.add(5);
        assertEquals(5, intHeap.peek());
        assertEquals(2, intHeap.size());

        intHeap.add(2);
        assertEquals(2, intHeap.peek());
        assertEquals(3, intHeap.size());


        assertEquals(2, intHeap.peek());
        assertEquals(3, intHeap.size());
        assertEquals(2, intHeap.poll());
        assertEquals(2, intHeap.size());

        assertEquals(5, intHeap.peek());
        assertEquals(2, intHeap.size());
        assertEquals(5, intHeap.poll());
        assertEquals(1, intHeap.size());

        assertEquals(10, intHeap.peek());
        assertEquals(1, intHeap.size());
        assertEquals(10, intHeap.poll());
        assertEquals(0, intHeap.size());
    }

    @Test
    void testMaxMode() {
        final IntHeap maxHeap = new IntHeapImpl(true);

        maxHeap.add(10);
        assertEquals(10, maxHeap.peek());
        assertEquals(1, maxHeap.size());

        maxHeap.add(15);
        assertEquals(15, maxHeap.peek());
        assertEquals(2, maxHeap.size());

        maxHeap.add(20);
        assertEquals(20, maxHeap.peek());
        assertEquals(3, maxHeap.size());


        assertEquals(20, maxHeap.peek());
        assertEquals(3, maxHeap.size());
        assertEquals(20, maxHeap.poll());
        assertEquals(2, maxHeap.size());

        assertEquals(15, maxHeap.peek());
        assertEquals(2, maxHeap.size());
        assertEquals(15, maxHeap.poll());
        assertEquals(1, maxHeap.size());

        assertEquals(10, maxHeap.peek());
        assertEquals(1, maxHeap.size());
        assertEquals(10, maxHeap.poll());
        assertEquals(0, maxHeap.size());
    }
}
