package aron.hacker_rank._prep._2023_08_21.stack;

import java.util.EmptyStackException;

public interface Stack<T>{
    void push(final T element);
    T peek() throws EmptyStackException;
    T pop() throws EmptyStackException;
    boolean isEmpty();
    boolean contains(final T element);
    int size();
}
