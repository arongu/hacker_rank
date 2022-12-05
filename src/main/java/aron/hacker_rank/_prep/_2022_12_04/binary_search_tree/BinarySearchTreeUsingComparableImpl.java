package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

public class BinarySearchTreeUsingComparableImpl<T extends Comparable<T>> extends BinarySearchTreeUsingComparable<T> {
    private static class Node<T> {
        private final T value;
        private Node<T> left, right;

        private Node(final T value) {
            this.value = value;
        }

        private void printInOrder() {
            if ( left != null ) left.printInOrder();
            System.out.println(value);
            if ( right != null ) right.printInOrder();
        }
    }

    private Node<T> root;

    private Node<T> getNodeOrItsParent(final T element) {
        Node<T> lastNonNull = root;

        for ( Node<T> it = root; it != null; ) {
            int n = element.compareTo(it.value);
            lastNonNull = it;

            if ( n == 0 ) {
                break;

            } else if ( n < 0 ) {
                it = it.left;

            } else {
                it = it.right;
            }
        }

        return lastNonNull;
    }

    @Override
    public void add(final T element) {
        if ( root == null ) {
            root = new Node<>(element);

        } else {
            final Node<T> node = getNodeOrItsParent(element);
            final int n = element.compareTo(node.value);

            if ( n == 0 ) {
                return;

            } else if (n < 0 ) {
                node.left = new Node<>(element);

            } else {
                node.right = new Node<>(element);
            }
        }
    }

    @Override
    public boolean contains(final T element) {
        return false;
    }

    @Override
    public void printInOrder() {
        if ( root != null ) root.printInOrder();
    }
}
