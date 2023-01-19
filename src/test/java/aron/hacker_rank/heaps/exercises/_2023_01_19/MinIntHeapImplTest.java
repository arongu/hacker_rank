package aron.hacker_rank.heaps.exercises._2023_01_19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinIntHeapImplTest {
    @Test
    void test() {
        final MinIntHeap minIntHeap = new MinIntHeapImpl();

        minIntHeap.add(10);
        assertEquals(10, minIntHeap.peek());
        assertEquals(1, minIntHeap.size());

        minIntHeap.add(5);
        assertEquals(5, minIntHeap.peek());
        assertEquals(2, minIntHeap.size());

        minIntHeap.add(2);
        assertEquals(2, minIntHeap.peek());
        assertEquals(3, minIntHeap.size());


        assertEquals(2, minIntHeap.peek());
        assertEquals(3, minIntHeap.size());
        assertEquals(2, minIntHeap.poll());
        assertEquals(2, minIntHeap.size());

        assertEquals(5, minIntHeap.peek());
        assertEquals(2, minIntHeap.size());
        assertEquals(5, minIntHeap.poll());
        assertEquals(1, minIntHeap.size());

        assertEquals(10, minIntHeap.peek());
        assertEquals(1, minIntHeap.size());
        assertEquals(10, minIntHeap.poll());
        assertEquals(0, minIntHeap.size());
    }
}
