package aron.hacker_rank._prep._2023_08_21.stack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackImplTest {
    @Test
    public void tests()
    throws NoSuchElementException {
        final Stack <Integer> stack = new StackImpl <>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());

        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());

        assertEquals(1, stack.peek());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
}
