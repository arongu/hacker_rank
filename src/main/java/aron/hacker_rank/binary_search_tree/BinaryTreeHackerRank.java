package aron.hacker_rank.binary_search_tree;

public class BinaryTreeHackerRank {

    private static class BinaryNode {
        private BinaryNode left = null, right = null;
        private final int number;

        public BinaryNode(final int number) {
            this.number = number;
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


    // method overloading and scope (public)
    public boolean contains(final int number) {
        return contains(rootNode, number);
    }

    public void insert(final int number) {
        insert(rootNode, number);
    }

    public void printInOrder() {
        printInOrder(rootNode);
    }
}
