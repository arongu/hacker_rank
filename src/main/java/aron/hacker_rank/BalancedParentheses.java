package aron.hacker_rank;

import java.util.Stack;

public class BalancedParentheses {
    public static final char[][] terms = {{ '(', ')' }, { '[', ']' }, { '{', '}'}};

    public static boolean isOpenTerm(char openTerm) {
        for (char[] arr : terms) {
            if ( openTerm == arr[0]){
                return true;
            }
        }

        return false;
    }

    public static boolean areTheyMatch(char openedTerm, char closedTerm) {
        for (char[] arr : terms) {
            if ( openedTerm == arr[0]){
                return closedTerm == arr[1];
            }
        }

        return false;
    }

    public boolean isBalanced(final String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if ( isOpenTerm(c)) {
                stack.push(c);
            } else {
                if ( stack.isEmpty() || ! areTheyMatch(stack.pop(), c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
