package aron.hacker_rank.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackImplTest {

    @Test
    public void test() {
        final String[] words = new String[]{ "alma", "korte", "repa", "majas", "kifli", "roka" };
        Stack<String> stack = new Stack<>();
        StackImpl<String> myStack = new StackImpl<>();

        assertTrue(myStack.isEmpty());

        for ( String s : words ) {
            stack.push(s);
            myStack.push(s);
        }

        assertEquals(stack.peek(), myStack.peek());
        assertEquals(stack.pop(),  myStack.pop());
        assertEquals(stack.size(), myStack.size());

        while ( !stack.isEmpty() ) {
            assertEquals(stack.pop(), myStack.pop());
            assertEquals(stack.size(), myStack.size());
            assertEquals(stack.isEmpty(), myStack.isEmpty());
        }

        assertTrue(myStack.isEmpty());
    }
}
