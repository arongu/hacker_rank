package aron.hacker_rank.heaps.exercises._2023_01_17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinIntHeapImplTest {
    @Test
    void test() {
        final MinIntHeap mintIntHeap = new MinIntHeapImpl();

        mintIntHeap.add(10);
        assertEquals(10, mintIntHeap.peek());
        mintIntHeap.add(5);
        assertEquals(5, mintIntHeap.peek());
        mintIntHeap.add(2);
        assertEquals(2, mintIntHeap.peek());

        assertEquals(3, mintIntHeap.size());
        assertEquals(2, mintIntHeap.peek());
        assertEquals(2, mintIntHeap.poll());
        assertEquals(2, mintIntHeap.size());

        assertEquals(5, mintIntHeap.peek());
        assertEquals(5, mintIntHeap.poll());
        assertEquals(1, mintIntHeap.size());

        assertEquals(10, mintIntHeap.peek());
        assertEquals(10, mintIntHeap.poll());
        assertEquals(0, mintIntHeap.size());
    }
}