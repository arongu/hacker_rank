package aron.hacker_rank.heaps.min;

public interface MinIntHeap {
    void add(final int item);
    int peek(); // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    int poll(); // Retrieves and removes the head of this queue, or returns null if this queue is empty.
    int size();
}
