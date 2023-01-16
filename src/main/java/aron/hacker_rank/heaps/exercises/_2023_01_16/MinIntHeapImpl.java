package aron.hacker_rank.heaps.exercises._2023_01_16;

import aron.hacker_rank.heaps.MintIntHeap;

import java.util.ArrayList;
/*
                    2(0) -> 0
        4(1) -> 0                7(2) -> 0
11(3) -> 1  16(4) -> 1    29(5) -> 2    36(6) -> 2

    0  1  2   3   4   5    6
    2, 4, 7, 11, 16, 29,  36

    leftChild  = index * 2 + 1;
    rightChild = index * 2 + 2;
    parent     = (index - 1) / 2;

*/

public class MinIntHeapImpl implements MintIntHeap {
    // calc index
    private static int getLeftChildIndex (final int index) { return index * 2 + 1; }
    private static int getRightChildIndex(final int index) { return index * 2 + 2; }
    private static int getParentIndex    (final int index) { return (index - 1) / 2; }

    // checks
    private boolean hasLeftChild (final int index) { return getLeftChildIndex(index)  < items.size(); }
    private boolean hasRightChild(final int index) { return getRightChildIndex(index) < items.size(); }
    private boolean hasParent    (final int index) { return getParentIndex(index)     < items.size(); }

    // get
    private int getLeftChild (final int index) { return items.get(getLeftChildIndex(index)); }
    private int getRightChild(final int index) { return items.get(getRightChildIndex(index)); }
    private int getParent    (final int index) { return items.get(getParentIndex(index)); }

    private final ArrayList<Integer> items = new ArrayList<>();

    private void swap(final int indexA, final int indexB) {
        final int save = items.get(indexA);
        items.set(indexA, items.get(indexB));
        items.set(indexB, save);
    }

    private void heapifyUp() {
        int index = items.size() - 1;
        while (hasParent(index) && getParent(index) > items.get(index)) {
            int parentIndex = getParentIndex(index);

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        if ( items.size() > 1 ) {

            int index = 0;
            while ( hasLeftChild(index) ) {
                int childIndex  = getLeftChildIndex(index);

                if ( hasRightChild(index) ) {
                    int rightChildIndex = getRightChildIndex(index);
                    // if the right child is smaller than the left, pick the right one
                    if ( items.get(rightChildIndex) < items.get(childIndex) ) childIndex = rightChildIndex;
                }

                if ( items.get(childIndex) < items.get(index) ) {
                    swap(index, childIndex);
                } else {
                    break;
                }

                index = childIndex;
            }
        }
    }

    @Override
    public void add(final int item) {
        items.add(item);
        heapifyUp();
    }

    @Override
    public int peek() throws IllegalStateException {
        if ( items.isEmpty() )
            throw new IllegalStateException();

        return items.get(0);
    }

    @Override
    public int poll() {
        if ( items.isEmpty() )
            throw new IllegalStateException();

        final int head = items.get(0);
        if ( items.size() == 1 ) {
            items.clear();

        } else {
            final int tailIndex = items.size() - 1;
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
