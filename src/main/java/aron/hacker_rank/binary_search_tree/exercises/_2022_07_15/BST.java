package aron.hacker_rank.binary_search_tree.exercises._2022_07_15;

public class BST {
    public static class BSTNode {
        public BSTNode left, right;
        int n;

        public BSTNode(final int n) {
            this.n = n;
        }
    }

    public static boolean checkBST(final BSTNode node, final int min, final int max) {
        if ( node == null ) return true;

        if ( node.n < min || node.n > max ) return false;

        return checkBST(node.left, min, node.n - 1) && checkBST(node.right, node.n + 1, max);
    }

    public static boolean checkBST(final BSTNode node) {
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
