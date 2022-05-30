package aron.hacker_rank;

import java.util.Stack;

public class BalancedParentheses2 {
    public static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean doTheyMatch(final char opening, final char closing) {
        if ( opening == '(' && closing == ')') return true;
        if ( opening == '[' && closing == ']') return true;
        if ( opening == '{' && closing == '}') return true;

        return false;
    }

    public static boolean isBalanced(final String string) {
        final Stack<Character> stack = new Stack<>();
        for ( final char c : string.toCharArray()) {
            if ( isOpening(c)) {
                stack.push(c);
                System.out.println(stack);
            } else if (isClosing(c)) {
                if (stack.isEmpty()) return false;
                if ( ! doTheyMatch(stack.pop(), c)) return false;
                System.out.println(stack);
            }
        }

        return stack.isEmpty();
    }
}
