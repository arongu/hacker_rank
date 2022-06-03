package aron.hacker_rank.gyak;

import java.util.Stack;

public class BalancedGyak4 {
    public static boolean isOpening(final char c){
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isClosing(final char c){
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean doTheyMatch(final char left, final char right){
        if ( left == right) return false;

        if ( left == '(' && right == ')' ) return true;
        if ( left == ')' && right == '(' ) return true;

        if ( left == '[' && right == ']' ) return true;
        if ( left == ']' && right == '[' ) return true;

        if ( left == '{' && right == '}' ) return true;
        if ( left == '}' && right == '{' ) return true;

        return false;
    }

    public static boolean isBalanced(final String string){
        final char[] arr = string.toCharArray();
        final Stack<Character> stack = new Stack<>();

        for(char c : arr) {
            if (isOpening(c)){
                stack.push(c);
            } else if (isClosing(c)){
                if (stack.isEmpty()) return false;
                if (! doTheyMatch(stack.pop(), c)) return false;
            }
        }

        return stack.isEmpty();
    }
}
