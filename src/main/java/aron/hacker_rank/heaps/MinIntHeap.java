package aron.hacker_rank.heaps;

/*
    parent = (index - 2) / 2
    left   = index * 2 + 1 --
    right  = index * 2 + 2
*/

import java.util.Arrays;

public class MinIntHeap {
    private static int getLeftChildIndex (final int parentIndex) { return parentIndex * 2 + 1; }
    private static int getRightChildIndex(final int parentIndex) { return parentIndex * 2 + 2; }
    private static int getParentIndex    (final int childIndex)  { return (childIndex - 1) / 2; }

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    // check
    private boolean hasLeftChild (final int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(final int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent    (final int index) { return getParentIndex(index) < size; }
    // get
    private int getLeftChild (final int index) { return items[getLeftChildIndex(index)]; }
    private int getRightChild(final int index) { return items[getRightChildIndex(index)]; }
    private int getParent    (final int index) { return items[getParentIndex(index)]; }
    // swap
    private void swap(final int indexOne, final int indexTwo) {
        final int tmp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = tmp;
    }
    // increase - similar to ArrayList
    private void ensureExtraCapacity() {
        if ( size == capacity ) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() throws IllegalStateException {
        if ( size == 0 ) throw new IllegalStateException();
        return items[0];
    }

    public int pull() throws IllegalStateException {
        if ( size == 0 ) throw new IllegalStateException();
        final int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(final int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if ( hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }
}
