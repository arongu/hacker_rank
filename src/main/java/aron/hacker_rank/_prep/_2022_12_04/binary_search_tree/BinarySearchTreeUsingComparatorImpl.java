package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import java.util.Comparator;

public class BinarySearchTreeUsingComparatorImpl<T> extends BinarySearchTreeUsingComparator<T> {
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

    BinarySearchTreeUsingComparatorImpl(final Comparator<T> comparator) {
        super(comparator);
    }

    private Node<T> getNodeOrItsParent(final T element) {
        Node<T> saved = root;

        for ( Node<T> walker = root; walker != null; ) {
            if ( comparator.compare(element, walker.value) < 0 ) {
                walker = walker.left;

            } else if ( comparator.compare(element, walker.value) > 0 ) {
                walker = walker.right;

            } else {
                break;
            }

            if ( walker != null ) saved = walker;
        }

        return saved;
    }

    @Override
    public void add(final T element) {
        if ( root == null ) {
            root = new Node<>(element);

        } else {
            final Node<T> node = getNodeOrItsParent(element);
            if ( comparator.compare(element, node.value) == 0 ) {

            } else if ( comparator.compare(element, node.value) < 0 ) {
                node.left = new Node<>(element);

            } else if ( comparator.compare(element, node.value) > 0 ) {
                node.right = new Node<>(element);
            }
        }
    }

    @Override
    public boolean contains(final T element) {
        final Node<T> node = getNodeOrItsParent(element);
        return node != null && comparator.compare(element, node.value) == 0;
    }

    @Override
    public void printInOrder() {
        root.printInOrder();
    }
}
