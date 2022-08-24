package aron.hacker_rank._prep._2022_08_23;

public class BinarySearchTreeRecursive {
    private BinarySearchTreeRecursive left, right;
    private final int n;

    public BinarySearchTreeRecursive(final int n) {
        this.n = n;
    }

    public boolean contains(final int n) {
        if ( this.n == n ) return true;

        if ( n < this.n && left != null )
            return left.contains(n);

        if ( n > this.n && right != null)
            return right.contains(n);

        return false;
    }

    public void add(final int n) {
        if ( n < this.n ) {
            if ( left == null ) {
                left = new BinarySearchTreeRecursive(n);
            } else {
                left.add(n);
            }

        } else if ( n > this.n ) {
            if ( right == null ) {
                right = new BinarySearchTreeRecursive(n);
            } else {
                right.add(n);
            }
        }
    }

    public void printInOrder() {
        if ( left != null ) left.printInOrder();
        System.out.println(n);
        if ( right != null ) right.printInOrder();
    }
}
