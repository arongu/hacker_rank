package aron.hacker_rank.heaps;

import java.util.ArrayList;

public class IntHeapImpl implements IntHeap {
    // indices
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    // instance
    private final ArrayList<Integer> items = new ArrayList<>();
    private final boolean maxHeap;

    // heapify
    private boolean isInBound(final int index) { return index < items.size(); }
    private boolean hasParent(final int index) { return index > 0 && index < items.size(); }

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

            while ( isInBound(index) ) {
                int parentIndex = getParentIndex(index);
                if ( isInBound(parentIndex) ) {
                    if ( maxHeap ) {
                        if (items.get(index) > items.get(parentIndex)) swap(index, parentIndex);
                        else break;

                    } else {
                        if ( items.get(index) < items.get(parentIndex)) swap(index, parentIndex);
                        else break;
                    }
                }

                index = parentIndex;
            }
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {
            int index = 0;

            while ( isInBound(index) ) {
                int childIndex = getLeftChildIndex(index); // calculate the child index, start with left

                if ( isInBound(childIndex) ) {  // check if it is valid
                    int rightChildIndex = getRightChildIndex(index); // calculate right child index

                    if ( isInBound(rightChildIndex) ) { // check if it is valid
                        // if it is a max heap pick the bigger one from the 2 children
                        if ( maxHeap && (items.get(childIndex) < items.get(rightChildIndex)) ) {
                            childIndex = rightChildIndex;

                        // if it is a min heap and the current pick is greater than the right, pick the other one
                        } else if (items.get(childIndex) > items.get(rightChildIndex)) {
                             childIndex = rightChildIndex;
                        }
                    }

                    // if it is a max heap and the child is greater than the parent switch it (PARENT/ROOT is greater)
                    if ( maxHeap ) {
                        if ( items.get(childIndex) > items.get(index) ) swap(index, childIndex);
                        else break;

                    // if it is a min heap and the child is smaller than the parent switch it (PARENT/ROOT is smaller)
                    } else {
                        if ( items.get(childIndex) < items.get(index) ) swap(index, childIndex);
                        else break;
                    }

                    index = childIndex;

                } else break;
            }
        }
    }

    // ctor
    public IntHeapImpl(final boolean maxHeap) {
        this.maxHeap = maxHeap;
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
        int tailIndex = items.size() - 1;

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
