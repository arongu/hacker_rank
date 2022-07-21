package aron.hacker_rank.binary_search_tree.exercises._2022_07_21;

public class BinaryTree {

    private static class Node {
        private final int n;
        private Node left, right;

        public Node(final int n) {
            this.n = n;
        }
    }

    private Node root;

    public void add(final int n) {
        if ( root == null ) {
            root = new Node(n);
            return;
        }

        for ( Node node = root; true; ) {
            if ( n < node.n ) {
                if ( node.left == null ) {
                    node.left = new Node(n);
                    return;

                } else {
                    node = node.left;
                }

            } else if ( n > node.n ) {
                if ( node.right == null ) {
                    node.right = new Node(n);
                    return;
                }

                node = node.right;

            } else {
                return;
            }
        }
    }

    public boolean contains(final int n) {
        for ( Node node = root; node != null; ) {
            if ( n < node.n ) {
                if ( node.left != null ) {
                    node = node.left;

                } else {
                    return false;
                }

            } else if ( n > node.n ) {
                if ( node.right != null ) {
                    node = node.right;

                } else {
                    return false;
                }

            } else {
                return true;
            }
        }

        return false;
    }

    private void printInOrder(final Node node) {
        if ( node.left != null ) {
            printInOrder(node.left);
        }

        System.out.println(node.n);

        if ( node.right != null ) {
            printInOrder(node.right);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }
}
