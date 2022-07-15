package aron.hacker_rank.balanced_parentheses.exercises._2022_06_30;

import java.util.Stack;

public class ParenthesesStack {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean areTheyAMatch(final char left, final char right) {
        if ( left == right ) return false;
        if ( left == '(' && right == ')' ) return true;
        if ( left == ')' && right == '(' ) return true;
        if ( left == '[' && right == ']' ) return true;
        if ( left == ']' && right == '[' ) return true;
        if ( left == '{' && right == '}' ) return true;
        return left == '}' && right == '{';
    }

    public static boolean isBalanced(final String string) {
        final char[] arr = string.toCharArray();
        final Stack<Character> openings = new Stack<>();

        for ( char c : arr ) {
            if ( isOpening(c) ) {
                openings.push(c);

            } else if ( isClosing(c) ) {
                if ( openings.isEmpty() || !areTheyAMatch(openings.pop(), c) ) return false;
            }
        }

        return openings.isEmpty();
    }
}
