package aron.hacker_rank.binary_search_tree.exercises._2022_07_21;

public class BinaryTreeRecursive {
    private static class Node {
        private final int n;
        private Node left, right;

        public Node(final int n) {
            this.n = n;
        }
    }

    private Node root;

    public void add(final Node node, final int n) {
        if ( node == null ) return;

        if ( n < node.n ) {
            if ( node.left == null ) node.left = new Node(n);
            else add(node.left, n);

        } else if ( n > node.n ) {
            if ( node.right == null ) node.right = new Node(n);
            else add(node.right, n);
        }
    }

    public void add(final int n) {
        if ( root == null ) root = new Node(n);
        else add(root, n);
    }

    private boolean contains(final Node node, int n) {
        if      ( node == null ) return false;
        if      ( n < node.n )   return contains(node.left, n);
        else if ( n > node.n )   return contains(node.right, n);
        else return true;
    }

    public boolean contains(final int n) {
        return contains(root, n);
    }

    private void printInOrder(final Node node) {
        if ( node == null ) return;

        printInOrder(node.left);
        System.out.println(node.n);
        printInOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }
}
