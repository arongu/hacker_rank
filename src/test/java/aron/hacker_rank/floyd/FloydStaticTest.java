package aron.hacker_rank.floyd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloydStaticTest {
    @Test
    void testLoop(){
        final Node<Integer> head = FloydStatic.createNodeListWithIntegers(50);
        final Node<Integer> tail = FloydStatic.getTail(head);

        // check for loop, size should be 50
        assertEquals(50, FloydStatic.getSize(head));

        // before loop
        // tail value should be 49
        assertEquals(49, tail.getValue());
        assertFalse(FloydStatic.hasLoop(head));

        final Node<Integer> loopEntry = FloydStatic.addLoop(head);
        assertTrue(FloydStatic.hasLoop(head));
        assertEquals(loopEntry.getValue(), tail.getNextNode().getValue());
    }
}
