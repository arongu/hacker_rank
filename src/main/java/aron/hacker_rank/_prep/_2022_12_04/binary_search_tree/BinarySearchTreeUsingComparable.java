package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

public abstract class BinarySearchTreeUsingComparable<T extends Comparable<T>> {
    abstract public void add(final T element);
    abstract public boolean contains(final T element);
    abstract public void printInOrder();
}
