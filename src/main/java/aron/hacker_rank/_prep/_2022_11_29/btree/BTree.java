package aron.hacker_rank._prep._2022_11_29.btree;

public class BTree {
    public static boolean validate(final BNode node, int min, int max) {
        if ( node == null ) return true;
        else if ( node.value < min || node.value > max ) return false;
        return validate(node.left, min, node.value - 1) && validate(node.right, node.value + 1, max);
    }

    public static boolean validate(final BTree bTree) {
        return validate(bTree.rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BNode rootNode;

    private BNode getNodeOrItsClosest(final int value) {
        BNode walker = rootNode, node = rootNode;

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
            rootNode = new BNode(value);

        } else {
            final BNode node = getNodeOrItsClosest(value);
            if ( value < node.value ) node.left = new BNode(value);
            else if ( value > node.value ) node.right = new BNode(value);
        }
    }

    public boolean contains(final int value) {
        return rootNode != null && getNodeOrItsClosest(value).value == value;
    }

    // printInOrder
    private void printInOrder(final BNode node){
        if ( node == null ) return;

        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(rootNode);
    }
}
