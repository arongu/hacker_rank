package aron.hacker_rank.binary_search_tree.exercises._2022_07_21;

public class TreeValidator {

    public static class Node {
        public int n;
        public Node left, right;

        public Node(final int n) {
            this.n = n;
        }
    }

    public static boolean isValid(final Node node, final int min, final int max) {
        if ( node == null ) return true;

        if ( node.n < min || node.n > max ) {
            return false;
        }

        return isValid(node.left, min, node.n - 1 ) && isValid(node.right, node.n + 1 , max);
    }
}
