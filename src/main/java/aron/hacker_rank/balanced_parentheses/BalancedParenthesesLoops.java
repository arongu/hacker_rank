package aron.hacker_rank.balanced_parentheses;

public class BalancedParenthesesLoops {
    public static boolean isOpening(final char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isClosing(final char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean doTheyMatch (final char left, final char right) {
        if (left == right) return false;
        if (left == '(' && right == ')') return true;
        if (left == ')' && right == '(') return true;

        if (left == '{' && right == '}') return true;
        if (left == '}' && right == '{') return true;

        if (left == '[' && right == ']') return true;
        if (left == ']' && right == '[') return true;

        return false;
    }

    public static int[] countOpeningsAndClosings (final char[] arr) {
        int[] counting = { 0, 0 };
        if (arr == null) return counting;

        for (char c : arr) {
            if (isOpening(c)) counting[0]++;
            if (isClosing(c)) counting[1]++;
        }

        return counting;
    }

    public static int findNextClosing(final int from, final char[] arr) {
        if (arr == null || from < 0) return -1;

        for (int i = from; i < arr.length; i++) {
            if (isClosing(arr[i])) return i;
        }

        return -1;
    }

    public static int findPreviousOpening(final int from, final char[] arr) {
        if (arr == null || from < 0) return -1;

        for (int i = from; i > 0; i--) {
            if (isOpening(arr[i])) return i;
        }

        return -1;
    }

    public static int findFurthestOpening(final char[] arr) {
        int furthest = -1;
        if (arr == null) return furthest;

        for (int i = 0; i < arr.length; i++) {
            if (isOpening(arr[i])) furthest = i;
        }

        return furthest;
    }

    public static boolean isBalanced(final String string) {
        final char[] arr = string.toCharArray();
        int[] counts = countOpeningsAndClosings(arr);
        int pos_opening = findFurthestOpening(arr);
        int pos_closing = findNextClosing(pos_opening + 1, arr);

        System.out.println(string);
        System.out.println("openings/closings: " + counts[0] + " " + counts[1]);
        System.out.println("pos_opening: " + pos_opening + " pos_closing: " + pos_closing);

        while (pos_opening != -1 && pos_closing != -1) {
            System.out.println("pos_opening: " + pos_opening + " pos_closing: " + pos_closing + " -- " + arr[pos_opening] + " " + arr[pos_closing]);

            if (doTheyMatch(arr[pos_opening], arr[pos_closing])){
                counts[0]--; counts[1]--;
            } else {
                return false;
            }

            pos_closing = findNextClosing(pos_closing + 1, arr);
            pos_opening = findPreviousOpening( pos_opening - 1, arr);
        }

        return counts[0] == 0 && counts[1] == 0;
    }
}
