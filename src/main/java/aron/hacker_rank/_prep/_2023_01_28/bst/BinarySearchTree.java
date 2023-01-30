package aron.hacker_rank._prep._2023_01_28.bst;

public interface BinarySearchTree<T extends Comparable<T>> {
    void add(final T element);
    boolean contains(final T element);
    void printInOrder();
}
