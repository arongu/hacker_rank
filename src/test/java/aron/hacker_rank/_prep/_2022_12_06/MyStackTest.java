package aron.hacker_rank._prep._2022_12_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    @Test
    public void tests(){
        final MyStack<Integer> myStack = new MyStack<>();
        assertTrue(myStack.isEmpty());
        assertEquals(0, myStack.size());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.size());

        assertEquals(3, myStack.peek());
        assertEquals(3, myStack.size());
        assertEquals(3, myStack.pop());
        assertEquals(2, myStack.size());
        assertFalse(myStack.isEmpty());

        assertEquals(2, myStack.peek());
        assertEquals(2, myStack.size());
        assertEquals(2, myStack.pop());
        assertEquals(1, myStack.size());
        assertFalse(myStack.isEmpty());

        assertEquals(1, myStack.peek());
        assertEquals(1, myStack.size());
        assertEquals(1, myStack.pop());
        assertEquals(0, myStack.size());
        assertTrue(myStack.isEmpty());
    }
}
