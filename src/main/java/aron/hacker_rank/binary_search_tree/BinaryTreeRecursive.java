package aron.hacker_rank.binary_search_tree;

public class BinaryTreeRecursive {

    private static class Node {
        private Node left, right;
        private final int value;

        public Node(final int value) {
            this.value = value;
        }
    }

    private Node rootNode;

    private boolean contains(final Node node, final int number) {
        if ( node == null ) return false;
        else if ( number < node.value ) return contains(node.left, number);
        else if ( number > node.value ) return contains(node.right, number);
        else return true;
    }

    private void add(final Node node, final int value) {
        if ( node == null ) return;

        if ( value < node.value ) {
            if ( node.left == null ) node.left = new Node(value);
            else add(node.left, value);
        }

        if ( value > node.value) {
            if ( node.right == null ) node.right = new Node(value);
            else add(node.right, value);
        }
    }

    public void add(final int number) {
        if ( rootNode == null ) {
            rootNode = new Node(number);

        } else {
            add(rootNode, number);
        }
    }

    public boolean contains(final int number) {
        return contains(rootNode, number);
    }
}
