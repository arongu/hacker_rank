package aron.hacker_rank._prep._2023_01_28.heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapImpl<T extends Comparable<T>> implements Heap<T> {
    // indices
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    // instance
    private final boolean maxHeap;
    private final ArrayList<T> items;

    private boolean isInbound(final int index) {
        return index < items.size();
    }

    // heapify
    private void heapifyDown() {

    }

    private void heapifyUp() {

    }

    public HeapImpl(final boolean maxHeap) {
        this.maxHeap = maxHeap;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(final T element) {
        items.add(element);
        heapifyUp();
    }

    @Override
    public T peek(final T element) throws NoSuchElementException {
        if (items.isEmpty() ) throw new NoSuchElementException();
        else return items.get(0);
    }

    @Override
    public T poll(final T element) throws NoSuchElementException {
        if (items.isEmpty() ) throw new NoSuchElementException();
        else {
            final T value = items.get(0);
            heapifyUp();
            return value;
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
