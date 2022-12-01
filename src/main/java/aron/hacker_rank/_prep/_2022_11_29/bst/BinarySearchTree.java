package aron.hacker_rank._prep._2022_11_29.bst;

public class BinarySearchTree implements BST {
    public static boolean validate(final BSTNode node, int min, int max) {
        if ( node == null ) return true;
        else if ( node.value < min || node.value > max ) return false;
        return validate(node.left, min, node.value - 1) && validate(node.right, node.value + 1, max);
    }

    public static boolean validate(final BinarySearchTree binarySearchTree) {
        return validate(binarySearchTree.rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BSTNode rootNode;

    private BSTNode getNodeOrItsClosest(final int value) {
        BSTNode walker = rootNode, node = rootNode;

        while ( walker != null ) {
            node = walker;
            if (value < walker.value) {
                walker = walker.left;

            } else if (value > walker.value) {
                walker = walker.right;

            } else {
                break;
            }
        }

        return node;
    }

    public void add(final int value) {
        if ( rootNode == null ) {
            rootNode = new BSTNode(value);

        } else {
            final BSTNode node = getNodeOrItsClosest(value);
            if ( value < node.value ) node.left = new BSTNode(value);
            else if ( value > node.value ) node.right = new BSTNode(value);
        }
    }

    public boolean contains(final int value) {
        return rootNode != null && getNodeOrItsClosest(value).value == value;
    }

    // printInOrder
    private void printInOrder(final BSTNode node){
        if ( node == null ) return;

        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(rootNode);
    }
}
