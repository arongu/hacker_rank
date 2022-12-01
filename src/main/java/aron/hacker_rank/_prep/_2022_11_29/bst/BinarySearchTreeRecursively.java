package aron.hacker_rank._prep._2022_11_29.bst;

public class BinarySearchTreeRecursively implements BST {
    private BinarySearchTreeRecursively left, right;
    private final int value;

    public BinarySearchTreeRecursively(final int value) {
        this.value = value;
    }

    public boolean contains(final int value) {
        if ( this.value == value ) return true;

        if ( value < this.value && left != null ) {
            return left.contains(value);
        }

        if ( value > this.value && right != null ) {
            return right.contains(value);
        }

        return false;
    }

    public void add(final int value) {
        if ( value < this.value ) {
            if ( left == null ) {
                left = new BinarySearchTreeRecursively(value);
            } else {
                left.add(value);
            }

        } else if (value > this.value) {
            if ( right == null ) {
                right = new BinarySearchTreeRecursively(value);
            } else {
                right.add(value);
            }
        }
    }

    public void printInOrder() {
        if ( left != null ) left.printInOrder();
        System.out.println(this.value);
        if ( right != null ) right.printInOrder();
    }
}
