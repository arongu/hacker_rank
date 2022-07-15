package aron.hacker_rank.binary_search_tree.exercises._2022_07_15;

public class BinaryTreeRecursive {
    private static class BinaryNode {
        private BinaryNode left, right;
        private int n;

        public BinaryNode(final int n) {
            this.n = n;
        }
    }

    private BinaryNode root;

    private void add(final BinaryNode node, final int n) {
        if ( n < node.n ) {
            if ( node.left == null ) {
                node.left = new BinaryNode(n);
            } else {
                add(node.left, n);
            }
        }

        if ( n > node.n ) {
            if ( node.right == null ) {
                node.right = new BinaryNode(n);
            } else {
                add(node.right, n);
            }
        }
    }

    public void add (final int n ) {
        if ( root == null ) {
            root = new BinaryNode(n);
        }

        add(root, n);
    }

    private boolean contains(final BinaryNode node, int n) {
        if ( node == null ) return false;

        if ( n < node.n ) {
            return contains(node.left, n);
        }

        if ( n > node.n ) {
            return contains(node.right,n);
        }

        return true;
    }

    public boolean contains(final int n) {
        return contains(root, n);
    }


    private void printInOrder(final BinaryNode node) {
        if ( node == null ) return;

        if (node.left != null) {
            printInOrder(node.left);
        }

        System.out.println(node.n);

        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    public void printInOrder(){
        printInOrder(root);
    }
}
