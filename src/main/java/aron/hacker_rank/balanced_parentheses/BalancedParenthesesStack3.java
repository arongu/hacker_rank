package aron.hacker_rank.balanced_parentheses;

import java.util.Stack;

public class BalancedParenthesesStack3 {
    private static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c =='{';
    }

    private static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c =='}';
    }

    private static boolean doOpeningMatchesToClosing(final char opening, final char closing) {
        if ( opening == closing ) return false;
        if ( opening == '(' && closing == ')') return true;
        if ( opening == '[' && closing == ']') return true;
        return opening == '{' && closing == '}';
    }

    public static boolean isBalanced(final String string) {
        final Stack<Character> openings = new Stack<>();
        final char[] arr = string.toCharArray();

        for ( char c : arr) {
            if ( isOpening(c) ) {
                openings.push(c);
            } else if ( isClosing(c) ) {
                if ( openings.isEmpty() || !doOpeningMatchesToClosing(openings.pop(), c)) return false;
            }
        }

        return openings.isEmpty();
    }
}
