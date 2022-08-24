package aron.hacker_rank._prep._2022_08_23;

public class BinarySearchTreeNull {
    private static class Node {
        private Node left, right;
        private final int n;

        public Node(final int n) {
            this.n = n;
        }

        private void printInOrder() {
            if ( left != null ) left.printInOrder();
            System.out.println(n);
            if ( right != null ) right.printInOrder();
        }
    }

    private Node root;

    public boolean contains(final int n) {
        final Node node = getNodeOrItsParent(n);
        return node != null && node.n == n;
    }

    private Node getNodeOrItsParent(final int n) {
        if ( root == null ) return null;

        Node node = root;
        while ( true ) {
            if ( node.n == n ) return node;

            if ( n < node.n ) {
                if (node.left == null) return node;
                else node = node.left;
                continue;
            }

            if ( node.right == null ) return node;
            else node = node.right;
        }
    }

    public void add(final int n) {
        Node node = getNodeOrItsParent(n);

        if ( node == null ) {
            root = new Node(n);
            return;
        }

        if ( node.n == n ) return;
        if ( n < node.n ) node.left = new Node(n);
        else node.right = new Node(n);
    }

    public void printInOrder() {
        if ( root != null ) root.printInOrder();
    }
}
