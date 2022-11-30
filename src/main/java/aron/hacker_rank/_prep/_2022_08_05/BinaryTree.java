package aron.hacker_rank._prep._2022_08_05;

public class BinaryTree {
    private static class Node {
        private final int n;
        private Node left, right;

        public Node(final int n) {
            this.n = n;
        }
    }

    private Node root;

    private Node getNodeOrParent(final int n) {
        Node currentNode = root, lastGoodNode = root;

        while ( currentNode != null ) {
            lastGoodNode = currentNode;

            if ( n < currentNode.n) {
                currentNode = currentNode.left;

            } else if ( n > currentNode.n ) {
                currentNode = currentNode.right;

            } else {
                break;
            }
        }

        return lastGoodNode;
    }

    public boolean contains(final int n) {
        final Node node = getNodeOrParent(n);

        if ( node == null ) return false;
        return node.n == n;
    }

    public void add (final int n) {
        if ( root == null ) {
            root = new Node(n);

        } else {
            final Node node = getNodeOrParent(n);
            if ( node.n == n ) return;

            if ( n < node.n ) {
                node.left = new Node(n);
            } else {
                node.right = new Node(n);
            }
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
