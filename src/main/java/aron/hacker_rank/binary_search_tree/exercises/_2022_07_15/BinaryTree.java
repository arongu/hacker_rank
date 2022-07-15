package aron.hacker_rank.binary_search_tree.exercises._2022_07_15;

public class BinaryTree {
    private static class BinaryNode {
        private BinaryNode left, right;
        private final int n;

        public BinaryNode(final int n) {
            this.n = n;
        }
    }

    private BinaryNode root;

    private BinaryNode findNearest(final BinaryNode rootNode, final int n) {
        BinaryNode node = null;

        for ( BinaryNode iterator = rootNode; iterator != null; ) {
            node = iterator;
            if ( n < iterator.n )      iterator = iterator.left;
            else if ( n > iterator.n ) iterator = iterator.right;
            else break;
        }

        return node;
    }

    private void printInOrder(final BinaryNode node) {
        if ( node == null ) return;

        if ( node.left != null ) {
            printInOrder(node.left);
        }

        System.out.println(node.n);

        if ( node.right != null ) {
            printInOrder(node.right);
        }
    }

    public void add(final int n) {
        if ( root == null ) root = new BinaryNode(n);

        final BinaryNode node = findNearest(root, n);
        if ( n < node.n )      node.left = new BinaryNode(n);
        else if ( n > node.n ) node.right = new BinaryNode(n);
        else System.out.println("Already contains it: " + node.n);
    }

    public boolean contains(final int n) {
        final BinaryNode node = findNearest(root, n);
        if ( node == null ) return false;
        return node.n == n;
    }

    public void printInOrder() {
        printInOrder(root);
    }
}
