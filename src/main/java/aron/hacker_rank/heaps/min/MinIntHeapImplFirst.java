package aron.hacker_rank.heaps.min;

/*
    First implementation

      2
    8  7
   12  16

Mappings:
    0, 1, 2, 3,   4
    2, 8, 7, 12, 16

    leftChild  = (index * 2) + 1
    rightChild = (index * 2) + 2
    parent     = (index - 1) / 2

    0) left -> 1, right -> 2, parent -> x
    1) left -> 3, right -> 4, parent -> 0
    2) left -> 5, right -> 6, parent -> 0
*/


import java.util.ArrayList;

public class MinIntHeapImplFirst implements MinIntHeap {
    // index
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    private final ArrayList<Integer> items = new ArrayList<>();

    // checks
    private boolean hasLeftChild (final int index) { return getLeftChildIndex(index) < items.size(); }
    private boolean hasRightChild(final int index) { return getRightChildIndex(index) < items.size(); }
    private boolean hasParent    (final int index) { return getParentIndex(index) < items.size(); }

    // get element
    private int getLeftChild (final int index) { return items.get(getLeftChildIndex(index)); }
    private int getRightChild(final int index) { return items.get(getRightChildIndex(index)); }
    private int getParent    (final int index) { return items.get(getParentIndex(index)); }

    // swap
    private void swap(final int indexA, final int indexB) {
        final int tmp = items.get(indexA);
        items.set(indexA, items.get(indexB));
        items.set(indexB, tmp);
    }

    // heapify
    private void heapifyUp() {
        int index = items.size() - 1;
        while (hasParent(index) && getParent(index) > items.get(index)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if ( hasRightChild(index) && getRightChild(index) < getLeftChild(index) ) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if ( items.get(index) < items.get(smallerChildIndex) ) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index  = smallerChildIndex;
        }
    }

    @Override
    public int peek() throws IllegalStateException {
        if ( items.size() == 0 ) throw new IllegalStateException();

        return items.get(0);
    }

    @Override
    public int poll() throws IllegalStateException {
        if ( items.size() == 0 ) throw new IllegalStateException();

        final int head = items.get(0);
        final int tailIndex = items.size() - 1;

        if ( items.size() == 1 ) {
            items.clear();

        } else {
            items.set(0, items.get(tailIndex));
            items.remove(tailIndex);
            heapifyDown();
        }

        return head;
    }

    @Override
    public void add(final int item) {
        items.add(item);
        heapifyUp();
    }

    @Override
    public int size() {
        return items.size();
    }
}
