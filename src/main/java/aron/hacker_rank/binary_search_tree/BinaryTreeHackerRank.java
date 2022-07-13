package aron.hacker_rank.binary_search_tree;

public class BinaryTreeHackerRank {

    public static class BinaryNode {
        private BinaryNode left = null, right = null;
        private final int number;

        public BinaryNode(final int number) {
            this.number = number;
        }

        public BinaryNode getLeft() {
            return left;
        }

        public BinaryNode getRight() {
            return right;
        }

        public int getNumber() {
            return number;
        }
    }

    private BinaryNode rootNode;

    private void insert(final BinaryNode node, final int number) {
        if ( rootNode == null ) {
            rootNode = new BinaryNode(number);
            return;
        }

        if ( number < node.number ) {
            if ( node.left == null ) {
                node.left = new BinaryNode(number);

            } else {
                insert(node.left, number);
            }

        } else if ( number > node.number ) {
            if ( node.right == null ) {
                node.right = new BinaryNode(number);

            } else {
                insert(node.right, number);
            }
        }
    }

    private boolean contains(final BinaryNode node, final int number ) {
        if ( node == null ) return false;

        if ( node.number < number ) {
            contains(node.left, number);

        } else if ( node.number > number ) {
            contains(node.right, number);
        }

        return true;
    }

    private void printInOrder(final BinaryNode node) {
        if ( node.left != null ) {
            printInOrder(node.left);
        }

        System.out.println(node.number);

        if ( node.right != null ) {
            printInOrder(node.right);
        }
    }

    // public methods (overloading and scope)
    public boolean contains(final int number) {
        return contains(rootNode, number);
    }

    public void insert(final int number) {
        insert(rootNode, number);
    }

    // check BST
    private boolean checkBST(final BinaryNode node, int min, int max) {
        // if it is null true is returned
        // which means if the starting node is null
        // you will get back a true
        // it also means the leaf nodes will get a pass, they will not be tested
        // because they will get a true
        if ( node == null ) {
            return true;
        }

        // which means that this if statement's job is to fail the recursion
        // while it traverses through the nodes
        if ( node.number < min || node.number > max ) {
            return false;
        }

        // keep going
        return checkBST(node.left, min, node.number - 1) && checkBST(node.right, node.number + 1, max);
    }

    public boolean checkBST() {
        return checkBST(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // print
    public void printInOrder() {
        printInOrder(rootNode);
    }
}
