package aron.hacker_rank.heaps.exercises._2023_01_17;
/*
    leftChild  = index * 2 + 1
    rightChild = index * 2 + 2
    parentIndex = (index - 1) / 2;
 */

import java.util.ArrayList;

public class MinIntHeapImpl implements MinIntHeap {
    // indices
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    // data
    private final ArrayList<Integer> items = new ArrayList<>();

    // boolean checks
    private boolean hasLeftChild  ( final int index ) { return getLeftChildIndex(index) < items.size(); }
    private boolean hasRightChild ( final int index ) { return getRightChildIndex(index) < items.size(); }
    private boolean hasParent     ( final int index ) { return index > 0 && getParentIndex(index) < items.size(); }

    // heapify
    private void swap (final int indexA, final int indexB) {
        final int save = items.get(indexA);
        items.set(indexA, items.get(indexB));
        items.set(indexB, save);
    }

    private void heapifyUp() {
        if ( items.size() > 1 ) {
            int index = items.size() - 1; // set starting point to the last index

            while ( hasParent(index) ) {
                int parentIndex = getParentIndex(index);
                if ( items.get(parentIndex) > items.get(index) ) swap(parentIndex, index);

                index = parentIndex;
            }
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {
            int index = 0;

            while ( hasLeftChild(index) ) {
                int childIndex = getLeftChildIndex(index);
                if ( hasRightChild(index) ) {
                    int rightChildIndex = getRightChildIndex(index);
                    if ( items.get(rightChildIndex) < items.get(childIndex) ) {
                        childIndex = rightChildIndex;
                    }
                }

                if ( items.get(index) > items.get(childIndex) ) {
                    swap(index, childIndex);
                } else {
                    break;
                }

                index = childIndex;
            }
        }
    }

    @Override
    public void add(final int n) {
        items.add(n);
        heapifyUp();
    }

    @Override
    public int peek() throws IllegalStateException {
        if ( items.isEmpty() ) throw new IllegalStateException();

        return items.get(0);
    }

    @Override
    public int poll() {
        if ( items.isEmpty() ) throw new IllegalStateException();

        final int head = items.get(0);
        if ( items.size() == 1 ) {
            items.clear();
        }  else {
            int tailIndex = items.size() - 1;
            items.set(0, items.get(tailIndex));
            items.remove(tailIndex);
            heapifyDown();
        }

        return head;
    }

    @Override
    public int size() {
        return items.size();
    }
}
