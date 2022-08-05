package aron.hacker_rank._prep._2022_08_05;

public class BinaryTreeRecursive {
    private BinaryTreeRecursive left, right;
    private final int number;

    public BinaryTreeRecursive(final int number) {
        this.number = number;
    }

    public boolean contains(final int n) {
        if ( n == number ) {
            return true;

        } else if ( n < number ) {
            if ( left == null ) return false;
            return left.contains(n);

        } else {
            if ( right == null ) return false;
            return right.contains(n);
        }
    }

    public void add(final int n) {
        if ( n < number ) {
            if ( left == null ) {
                left = new BinaryTreeRecursive(n);
            } else {
                left.add(n);
            }

        } else if ( n > number ) {
            if ( right == null ) {
                right = new BinaryTreeRecursive(n);
            } else {
                right.add(n);
            }
        }
    }
}
