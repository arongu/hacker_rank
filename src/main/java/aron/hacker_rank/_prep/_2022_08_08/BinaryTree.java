package aron.hacker_rank._prep._2022_08_08;

public class BinaryTree {
    // private
    private BinaryTree left, right;
    private int n;

    public BinaryTree(final int n) {
        this.n = n;
    }

    public void add(final int n) {
        if ( n < this.n ) {
            if ( left == null ) {
                left = new BinaryTree(n);
            } else {
                left.add(n);
            }

        } else if ( n > this.n ) {
            if ( right == null ) {
                right = new BinaryTree(n);
            } else {
                right.add(n);;
            }
        }
    }

    public boolean contains(final int n) {
        if ( n < this.n ) {
            return left != null && left.contains(n);
        } else if ( n > this.n ) {
            return right != null && right.contains(n);
        } else {
            return true;
        }
    }

    public void printInOrder() {
        if ( left != null ) left.printInOrder();
        System.out.println(n);
        if ( right != null ) right.printInOrder();
    }
}
