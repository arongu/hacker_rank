package aron.hacker_rank._prep._2022_11_29;

import java.util.Stack;

public class ParenthesesStack {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean areTheyMatch(final char opening, final char closing) {
        return ( opening == '(' && closing == ')' ) ||
               ( opening == '[' && closing == ']' ) ||
               ( opening == '{' && closing == '}' );
    }

    public static boolean isBalanced(final String string) {
        if ( string == null ) return true;

        final Stack<Character> openings = new Stack<>();
        for ( char c : string.toCharArray() ) {
            if ( isOpening(c) ) {
                openings.push(c);

            } else if ( isClosing(c) ) {
                if ( openings.isEmpty() || !areTheyMatch(openings.pop(), c) ) return false;
            }
        }

        return openings.isEmpty();
    }
}
