package aron.hacker_rank.balanced_parentheses.exercises._2022_07_15;

import java.util.Stack;

public class ParenthesesStack {
    public static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean doTheyMatch(final char opening, final char closing) {
        if ( opening == closing ) return false;
        if ( opening == '(' && closing == ')' ) return true;
        if ( opening == '[' && closing == ']' ) return true;
        return  opening == '{' && closing == '}';
    }

    public static boolean isBalanced(final String string) {
        if ( string == null ) return false;

        final char[] arr = string.toCharArray();
        final Stack<Character> openings = new Stack<>();

        for ( char c : arr ) {
            if ( isOpening(c) ) {
                openings.push(c);

            } else if ( isClosing(c) ) {
                if ( openings.isEmpty() || !doTheyMatch(openings.pop(), c) ) return false;
            }
        }

        return openings.isEmpty();
    }
}
