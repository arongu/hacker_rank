package aron.hacker_rank._prep._2022_08_23;

import java.util.Stack;

public class ParenthesesStack {
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
        return  ( opening == '{' && closing == '}' );
    }

    public static boolean isBalanced(final String string) {
        if ( string == null || string.isEmpty() ) return true;

        final Stack<Character> opening = new Stack<>();

        for ( char c : string.toCharArray() ) {
            if ( isOpening(c) ) {
                opening.push(c);

            } else if ( isClosing(c) ) {
                if ( opening.isEmpty() || !doTheyMatch(opening.pop(), c) ) {
                    return false;
                }
            }
        }

        return opening.isEmpty();
    }
}
