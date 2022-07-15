package aron.hacker_rank.binary_search_tree.exercises._2022_07_06;

public class BinaryTree {

    private static class Node {
        int value;
        Node left, right;

        public Node(final int value) {
            this.value = value;
        }
    }

    Node rootNode = null;

    private Node findNodeOrReturnParent(final Node rootNode, final int number) {
        Node node = null;

        for ( Node ptr = rootNode; ptr != null; ) {
            if ( number < ptr.value ) {
                node = ptr;
                ptr  = ptr.left;

            } else if ( number > ptr.value ) {
                node = ptr;
                ptr  = ptr.right;

            } else {
                return ptr;
            }
        }

        return node;
    }

    public void add(final int number) {
        if ( rootNode == null ) {
            rootNode = new Node(number);
            return;
        }

        final Node node = findNodeOrReturnParent(rootNode, number);
        if ( number < node.value ) {
            node.left = new Node(number);

        } else if ( number > node.value ) {
            node.right = new Node(number);
        }
    }

    public boolean contains(final int number) {
        final Node node = findNodeOrReturnParent(rootNode, number);
        return node != null && node.value == number;
    }
}
