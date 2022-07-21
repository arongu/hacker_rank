package aron.hacker_rank.binary_search_tree.exercises._2022_07_21;

public class BinaryTreeCompact {

    private static class Node {
        private final int n;
        private Node left, right;

        public Node(int n) {
            this.n = n;
        }
    }

    private Node root;

    public Node getNodeOrNearest(final int n) {
        Node node;
        for ( node = root; node != null; ) {
            if ( n < node.n ) {
                if ( node.left == null ) return node;
                node = node.left;

            } else if ( n > node.n ){
                if ( node.right == null ) return node;
                node = node.right;

            } else {
               break;
            }
        }

        return node;
    }

    public boolean contains(final int n) {
        if ( root == null ) return false;

        return getNodeOrNearest(n).n == n;
    }

    public void add(final int n) {
        if ( root == null ) {
            root = new Node(n);
            return;
        }

        Node node = getNodeOrNearest(n);
        if ( n < node.n ) {
            node.left = new Node(n);
        } else if ( n > node.n ) {
            node.right = new Node(n);
        }
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
