package aron.hacker_rank.heaps.exercises._2023_01_17;

import java.util.ArrayList;

public class MinIntHeapImpl3 implements MinIntHeap {
    // static methods
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    // instance vars/properties
    private final ArrayList<Integer> items = new ArrayList<>();
    private boolean isInBound(final int index) { return index < items.size(); }
    private boolean hasParent(final int index) { return index > 0 && index < items.size(); }

    // heapify
    private void swap(final int indexA, final int indexB) {
        if ( isInBound(indexA) && isInBound(indexB) ) {
            final int savedA = items.get(indexA);
            items.set(indexA, items.get(indexB));
            items.set(indexB, savedA);
        }
    }

    private void heapifyUp() {
        int index = items.size() - 1; // start at the last element

        if ( index > 0 ) {
            while ( hasParent(index) ) {
                int parentIndex = getParentIndex(index);
                if ( items.get(parentIndex) > items.get(index) ) {
                    swap(index,parentIndex);
                    index = parentIndex;
                }
            }
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {
            int index = 0;

            while ( isInBound(index) ) {
                int indexOfSmallestChild = getLeftChildIndex(index);
                int rightChildIndex      = getRightChildIndex(index);

                if ( isInBound(rightChildIndex) && items.get(indexOfSmallestChild) > items.get(rightChildIndex) ) {
                    indexOfSmallestChild = rightChildIndex;
                }

                if ( items.get(index) > items.get(indexOfSmallestChild) ) {
                    swap(index, indexOfSmallestChild);
                    index = indexOfSmallestChild;

                } else break;
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
    public int poll() throws IllegalStateException {
        if ( items.isEmpty() ) throw new IllegalStateException();

        final int head = items.get(0);
        final int tailIndex = items.size() - 1;

        if ( tailIndex == 0 ) items.clear();
        else {
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
