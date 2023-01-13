package aron.hacker_rank.heaps;
/*
    Test Gale's solution
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinIntHeapImplFirstTest {
    @Test
    void test() {
        final MintIntHeap mintIntHeap = new MinIntHeapImplFirst();

        mintIntHeap.add(10);
        mintIntHeap.add(2);
        mintIntHeap.add(5);

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
