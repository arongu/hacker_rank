package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import java.util.Comparator;

public abstract class BinarySearchTreeUsingComparator<T> {
    final Comparator<T> comparator;

    BinarySearchTreeUsingComparator(final Comparator<T> comparator) {
        this.comparator = comparator;
    }

    abstract public void add(final T element);
    abstract public boolean contains(final T element);
    abstract public void printInOrder();
}
