package aron.hacker_rank.binary_search_tree;

public class BinaryTreeThirdImpl {
    private static class Node {
        private Node leftNode, rightNode;
        private int value;

        public Node() {
            this.leftNode  = null;
            this.rightNode = null;
        }

        public Node(final int value) {
            this.value     = value;
            this.leftNode  = null;
            this.rightNode = null;
        }
    }

    private Node rootNode = null;

    // when a node has no child nodes it is called a leaf node
    private Node findOrGiveBackParentNode(final Node rootNode, final int number) {
        Node parentNode = null;

        for ( Node node = rootNode; node != null; ) {
            if ( number < node.value ) {
                parentNode = node;
                node       = node.leftNode;

            } else if ( number > node.value ) {
                parentNode = node;
                node       = node.rightNode;

            } else { // value == number
                return node;
            }
        }

        return parentNode; // must return parent, because a leaf node has nothing on its left or right edge -> null
                           // once the iterator (node) reaches the edege it becomes null, can only work with its parent
    }

    public void add(int number) {
        if ( rootNode == null ) {
            rootNode = new Node(number);
            return;
        }

        final Node leafNode = findOrGiveBackParentNode(rootNode, number);
        if ( leafNode != null ) {
            if ( number > leafNode.value ) {
                leafNode.rightNode = new Node(number);

            } else if ( number < leafNode.value) {
                leafNode.leftNode = new Node(number);
            }
            // value == number do nothing - explicit empty else could go here
        }
    }

    public boolean contains(int number) {
        final Node node = findOrGiveBackParentNode(rootNode, number);
        return node != null && node.value == number;
    }
}
