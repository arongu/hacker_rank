package aron.hacker_rank._prep._2023_01_28.bst;

public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    private static class Node<T extends Comparable<T>> {
        private final T value;
        private Node<T> left, right;

        private Node(final T value) {
            this.value = value;
        }

        private void add(final T value) {
            Node<T> ptr = this;

            while ( true ) {
                int n = ptr.value.compareTo(value);
                if ( n == 0 ) {
                    break;

                } else if ( n < 0 ) {
                    if ( ptr.left == null ) { ptr.left = new Node<>(value); break; }
                    else ptr = ptr.left;

                } else {
                    if ( ptr.right == null ) { ptr.right = new Node<>(value); break; }
                    else ptr = ptr.right;
                }
            }
        }

        private boolean contains(final T value) {
            Node<T> ptr = this;

            while ( ptr != null ) {
                int n = ptr.value.compareTo(value);

                if ( n == 0 ) return true;
                else if ( n < 0 ) { ptr = ptr.left; }
                else ptr = ptr.right;
            }

            return false;
        }

        private void printOnOrder() {
            if ( left != null ) left.printOnOrder();
            System.out.println(value);
            if ( right != null ) right.printOnOrder();
        }
    }

    private Node<T> root = null;

    @Override
    public void add(final T value) {
        if ( root == null ) root = new Node<>(value);
        else root.add(value);
    }

    @Override
    public boolean contains(final T element) {
        return root != null && root.contains(element);
    }

    @Override
    public void printInOrder() {
        if ( root != null ) root.printOnOrder();
    }
}
