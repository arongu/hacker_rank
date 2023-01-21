package aron.hacker_rank.heaps;

public interface IntHeap {
    void add(int n);
    int peek() throws IllegalStateException;
    int poll() throws IllegalStateException;
    int size();
}
