package aron.hacker_rank.balanced_parentheses.exercises;

import java.util.Stack;

public class ParenthesesStack2 {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean doTheyMatch(final char opening, final char closing) {
        if ( opening == closing ) return false;
        if ( opening == '(' && closing == ')' ) return true;
        if ( opening == '[' && closing == ']' ) return true;
        return  opening == '{' && closing == '}';
    }

    public static boolean isBalanced(final String string) {
        if ( string == null ) return false;

        final char[] arr                = string.toCharArray();
        final Stack<Character> openings = new Stack<>();

        for ( char c : arr ) {
            if ( isOpening(c) ) {
                openings.push(c);

            } else if ( isClosing(c) ) {
                if ( openings.isEmpty() || !doTheyMatch(openings.pop(), c)) return false;
            }
        }

        return openings.isEmpty();
    }
}
