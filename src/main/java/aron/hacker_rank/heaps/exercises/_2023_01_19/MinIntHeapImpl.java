package aron.hacker_rank.heaps.exercises._2023_01_19;

import java.util.ArrayList;

public class MinIntHeapImpl implements MinIntHeap {
    // indices
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1 ) / 2; }

    // instance properties
    private final ArrayList<Integer> items = new ArrayList<>();

    // checks
    private boolean isInBound(final int index) { return index < items.size(); }
    private boolean hasParent(final int index) { return index > 0 && index < items.size(); }

    // heapify
    private void swap(final int indexA, final int indexB) {
        if ( isInBound(indexA) && isInBound(indexB) ) {
            final int saved = items.get(indexA);
            items.set(indexA, items.get(indexB));
            items.set(indexB, saved);
        }
    }

    private void heapifyUp() {
        if ( items.size() > 1 ) {
            int index = items.size() - 1;

            while ( hasParent(index) ) {
                int parentIndex = getParentIndex(index);
                if ( items.get(parentIndex) > items.get(index) ) {
                    swap(index, parentIndex);
                    index = parentIndex;
                }
            }
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {
            int index = 0;
            int childIndex = getLeftChildIndex(index);

            while ( isInBound(index) ) {
                int rightChildIndex = getRightChildIndex(index);
                if ( isInBound(rightChildIndex) && items.get(childIndex) > items.get(rightChildIndex) ) {
                    childIndex = rightChildIndex;
                }

                if ( items.get(index) > items.get(childIndex) ) {
                    swap(index, childIndex);
                    index = childIndex;
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
