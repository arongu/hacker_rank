package aron.hacker_rank.heaps;
/*
    Test Gale's solution
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinIntHeapImplFirstTest {
    @Test
    void test() {
        final MinIntHeap minIntHeap = new MinIntHeapImplFirst();

        minIntHeap.add(10);
        minIntHeap.add(2);
        minIntHeap.add(5);

        assertEquals(3, minIntHeap.size());

        assertEquals(2, minIntHeap.peek());
        assertEquals(2, minIntHeap.poll());
        assertEquals(2, minIntHeap.size());


        assertEquals(5, minIntHeap.peek());
        assertEquals(5, minIntHeap.poll());
        assertEquals(1, minIntHeap.size());

        assertEquals(10, minIntHeap.peek());
        assertEquals(10, minIntHeap.poll());
        assertEquals(0, minIntHeap.size());
    }
}
