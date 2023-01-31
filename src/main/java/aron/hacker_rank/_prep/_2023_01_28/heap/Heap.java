package aron.hacker_rank._prep._2023_01_28.heap;

import java.util.NoSuchElementException;

public interface Heap<T extends Comparable<T>> {
    void add(T element);
    T peek(T element) throws NoSuchElementException;
    T poll(T element) throws NoSuchElementException;
    int size();

}
