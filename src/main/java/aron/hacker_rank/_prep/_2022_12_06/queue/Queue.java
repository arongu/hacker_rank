package aron.hacker_rank._prep._2022_12_06.queue;

import java.util.NoSuchElementException;

public interface Queue<T> {
    int size();
    boolean contains(final T value);
    void enqueue(final T value);
    T peek() throws NoSuchElementException;
    T dequeue() throws NoSuchElementException;
}
