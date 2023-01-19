package aron.hacker_rank.heaps.exercises._2023_01_17;

import java.util.ArrayList;

public class MinIntHeapImpl2 implements MinIntHeap {
    // indices
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index -1) / 2; }

    // -- instance --
    // private members
    private final ArrayList<Integer> items = new ArrayList<>();

    // check
    private boolean isInBound(final int index) { return index < items.size(); }
    private boolean hasParent(final int index) { return index > 0 && isInBound(index); }

    // heapify
    private void swap(final int indexA, final int indexB) {
        if ( isInBound(indexA) && isInBound(indexB) ) {
            final int save = items.get(indexA);
            items.set(indexA, items.get(indexB));
            items.set(indexB, save);
        }
    }

    private void heapifyUp() {
        if ( items.size() > 1) {
            int index = items.size() - 1;

            while ( hasParent(index) ) {
                int parentIndex = getParentIndex(index);
                if ( items.get(parentIndex) > items.get(index) ) swap(index, parentIndex);
                else break;
            }
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {
            int index = 0;

            while ( isInBound(index) ) {
                int indexOfSmallestChild = getLeftChildIndex(index); // make the 'smallest' child the left as a starting point
                int rightChildIndex      = getRightChildIndex(index);
                // check if there is a right child and if there is, pick it as the smallest if it is smaller
                if ( isInBound(rightChildIndex) && items.get(rightChildIndex) < items.get(indexOfSmallestChild) ) {
                    indexOfSmallestChild = rightChildIndex;
                }

                // compare
                if ( items.get(indexOfSmallestChild) < items.get(index) ) {
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

        final int tailIndex = items.size() - 1;
        final int head = items.get(0);

        if ( tailIndex == 0 ) items.clear(); // only one element in the array
        else {
            items.set(0, items.get(tailIndex)); // moving the last element to the first index
            items.remove(tailIndex); // get rid of the duplicate
            heapifyDown(); // 'push' down the
        }

        return head; // return head
    }

    @Override
    public int size() {
        return items.size();
    }
}
