package aron.hacker_rank._prep._2022_12_04.queue;

import java.util.NoSuchElementException;

public interface Queue<T> {
    void enqueue(final T element);
    T dequeue() throws NoSuchElementException;
    T peek() throws NoSuchElementException;
    boolean contains(final T element);
    int size();
}
