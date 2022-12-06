package aron.hacker_rank._prep._2022_12_06;

import java.util.Stack;

public class Parentheses {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean doTheyMatch(final char opening, final char closing) {
        return opening == '(' && closing == ')' ||
               opening == '[' && closing == ']' ||
               opening == '{' && closing == '}';
    }

    public static boolean isBalanced(final String string) {
        final Stack<Character> openings = new Stack<>();

        for ( char c : string.toCharArray() ) {
            if ( isOpening(c) ) {
                openings.push(c);

            } else if ( isClosing(c) ) {
                if (openings.isEmpty() || !doTheyMatch(openings.pop(), c)) return false;
            }
        }

        return openings.isEmpty();
    }
}
