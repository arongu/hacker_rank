package aron.hacker_rank.balanced_parentheses;

import java.util.Stack;

public class BalancedParenthesesStack1 {
    public static final char[] openings = { '(', '{', '[' };
    public static final char[] closings = { ')', '}', ']' };

    public static boolean isOpening(final char character) {
        for ( char op : openings) {
            if ( character == op) return true;
        }

        return false;
    }

    public static boolean isClosing(final char character) {
        for ( char clo : closings) {
            if ( character == clo) return true;
        }

        return false;
    }

    public static boolean doTheyMatch(char opening, char closing) {
        for ( int i = 0; i < openings.length; i++) {
            if (opening == openings[i]) {
                return closing == closings[i];
            }
        }

        return false;
    }

    public static boolean isBalanced(final String expression) {
        final Stack<Character> stack = new Stack<>();
        for ( char c : expression.toCharArray()) {
            if ( isOpening(c)) {
                stack.push(c);
                System.out.println(stack);
            }
            else if ( isClosing(c)) {
                if ( stack.isEmpty() ) return false; // if there were no previously stored openings -> it is already malformed e.g.: ]
                if ( !doTheyMatch(stack.pop(), c)) return false; // get the immediate opening and check if it matches to the closing if not -> malformed
                System.out.println(stack);
                // note: ([{((((([{} ... no matter how many openings you have, at some point you have to close it regardless how deep is the nest,
                // the first 'closing' must match with the last opening character
            }
        }

        return stack.isEmpty();
    }
}
