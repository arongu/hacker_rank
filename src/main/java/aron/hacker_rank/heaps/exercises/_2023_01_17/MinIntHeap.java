package aron.hacker_rank.heaps.exercises._2023_01_17;

public interface MinIntHeap {
    void add(int n);
    int peek() throws IllegalStateException;
    int poll() throws IllegalStateException;
    int size();
}
