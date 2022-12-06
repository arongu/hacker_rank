package aron.hacker_rank._prep._2022_12_06.bst;

public class BinarySearchTreeRecursiveImpl<T extends Comparable<T>> implements BinarySearchTree<T> {
    private final T value;
    private BinarySearchTreeRecursiveImpl<T> left, right;

    public BinarySearchTreeRecursiveImpl(final T value) {
        this.value = value;
    }

    @Override
    public void add(final T element) {
        int n = element.compareTo(value);
        if ( n == 0 ) {
            return;
        } else if ( n < 0 ) {
            if ( left == null ) left = new BinarySearchTreeRecursiveImpl<>(element);
            else left.add(element);

        } else {
            if ( right == null ) right = new BinarySearchTreeRecursiveImpl<>(element);
            else right.add(element);
        }
    }

    @Override
    public boolean contains(final T element) {
        int n = element.compareTo(value);
        if ( n == 0 ) return true;
        else if ( n < 0 ) {
            if ( left != null ) return left.contains(element);

        } else {
            if ( right != null ) return right.contains(element);
        }

        return false;
    }

    @Override
    public void printInOrder() {
        if ( left != null ) left.printInOrder();
        System.out.println(value);
        if ( right != null ) right.printInOrder();
    }
}
