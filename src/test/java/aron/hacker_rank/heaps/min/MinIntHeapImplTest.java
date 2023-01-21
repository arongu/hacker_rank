package aron.hacker_rank.heaps.min;
/*
    Test Gale's solution
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinIntHeapImplTest {
    @Test
    void test() {
        final MinIntHeap minIntHeap = new MinIntHeapImpl();

        minIntHeap.add(10);
        minIntHeap.add(2);
        minIntHeap.add(5);

        assertEquals(3, minIntHeap.size());
        assertEquals(2, minIntHeap.peek());
        assertEquals(2, minIntHeap.poll());
        assertEquals(5, minIntHeap.poll());
        assertEquals(10, minIntHeap.poll());
        assertEquals(0, minIntHeap.size());
    }
}
