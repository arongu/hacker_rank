package aron.hacker_rank._prep._2022_12_06.bst;

public interface BinarySearchTree<T extends Comparable<T>> {
    void add(final T element);
    boolean contains(final T element);
    void printInOrder();
}
