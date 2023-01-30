package aron.hacker_rank._prep._2022_12_06.bst;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left, right;

        private Node(final T value) {
            this.value = value;
        }

        private void add(final T value) {
            Node<T> it = this;
            while ( true ) {
                int n = value.compareTo(it.value);
                if ( n == 0 ) {
                    break;

                } else if ( n < 0 ) {
                    if ( it.left == null ) { it.left = new Node<>(value); break; }
                    else it = it.left;

                } else {
                    if ( it.right == null ) { it.right = new Node<>(value); break; }
                    else it = it.right;
                }
            }
        }

        private boolean contains(final T value) {
            for ( Node<T> it = this; it != null; ) {
                int n = value.compareTo(it.value);

                if ( n == 0 ) {
                    return true;

                } else if ( n < 0 ) {
                    it = it.left;

                } else {
                    it = it.right;
                }
            }

            return false;
        }

        private void printInOrder() {
            if ( left != null ) left.printInOrder();
            System.out.println(value);
            if ( right != null ) right.printInOrder();
        }
    }

    private Node<T> root = null;

    @Override
    public void add(final T element) {
        if ( root == null ) {
            root = new Node<>(element);

        } else {
            root.add(element);
        }
    }

    @Override
    public boolean contains(final T element) {
        return root != null && root.contains(element);
    }

    @Override
    public void printInOrder() {
        if ( root != null ) root.printInOrder();
    }
}
