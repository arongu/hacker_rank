package aron.hacker_rank.balanced_parenthesas_excercise;

import java.util.Stack;

public class Balanced7 {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean doTheyMatch(final char left, final char right) {
        if ( left == right) return false;

        if ( left == '(' && right == ')') return true;
        if ( left == ')' && right == '(') return true;

        if ( left == '[' && right == ']') return true;
        if ( left == ']' && right == '[') return true;

        if ( left == '{' && right == '}') return true;
        if ( left == '}' && right == '{') return true;

        return false;
    }

    public static boolean isBalanced(final String string){
        final char[] arr = string.toCharArray();
        final Stack<Character> openings = new Stack<>();

        for ( char c : arr) {
            if ( isOpening(c) ) {
                openings.push(c);
            } else if ( isClosing(c)) {
                if (openings.isEmpty()) return false;
                if (!doTheyMatch(openings.pop(), c)) return false;
            }
        }

        return openings.isEmpty();
    }
}
