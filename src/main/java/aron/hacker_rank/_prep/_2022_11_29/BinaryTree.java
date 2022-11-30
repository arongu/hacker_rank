package aron.hacker_rank._prep._2022_11_29;

public class BinaryTree {
    private static class Node {
        Node left, right;
        int value;

        private Node(final int value) {
            this.value = value;
        }
    }

    private static Node getNodeOrReturnItsClosest(final Node root, final int n) {
        if ( root == null ) return null;

        Node current = root, lastValidNode = current;
        while ( current != null ) {
            lastValidNode = current;

            if ( n < current.value ) {
                current = current.left;

            } else if ( n > current.value ) {
                current = current.right;

            } else {
                break;
            }
        }

        return lastValidNode;
    }

    private static boolean validate(final Node node, final int min, final int max) {
        if ( node == null ) return true;
        if ( node.value > max || node.value < min ) return false;

        return validate(node.left, min, node.value - 1 ) &&
                validate(node.right, node.value + 1, max);
    }

    private Node root;

    public void add(final int value) {
        if ( this.root == null ) {
            root = new Node(value);
        } else {
            Node node = getNodeOrReturnItsClosest(root, value);
            if ( node.value == value ) return;
            if ( value < node.value ) node.left = new Node(value);
            else node.right = new Node(value);
        }
    }

    public boolean contains(final int value) {
        final Node node = getNodeOrReturnItsClosest(root, value);
        return node != null && node.value == value;
    }

    private void printInOrder(final Node node) {
        if ( node == null ) return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public boolean isTreeValid() {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
