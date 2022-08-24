package aron.hacker_rank._prep._2022_08_23;

public class BinarySearchTree {
    private final int n;
    private BinarySearchTree left, right;

    public BinarySearchTree(final int n) {
        this.n = n;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public int getN() {
        return n;
    }

    private BinarySearchTree getNodeIfExistsOtherwiseItsParent(final int n) {
        BinarySearchTree curr = this;

        while (true) {
            if ( curr.n == n )
                return curr;

            if ( n < curr.n ) {
                if ( curr.left == null )
                    return curr;

                else {
                    curr = curr.left;
                    continue;
                }
            }

            if ( curr.right == null ) {
                return curr;

            } else {
                curr = curr.right;
            }
        }
    }

    public boolean contains(final int n) {
        return getNodeIfExistsOtherwiseItsParent(n).n == n;
    }

    public void add(final int n) {
        final BinarySearchTree tree = getNodeIfExistsOtherwiseItsParent(n);
        if ( tree.n == n ) {
            System.out.println("already have it " + n);
            return;
        }

        if ( n < tree.n ) {
            tree.left = new BinarySearchTree(n);
            System.out.println(n + " added to the left of " + tree.n );
        }
        else {
            tree.right = new BinarySearchTree(n);
            System.out.println(n + " added to the right of " + tree.n );
        }
    }

    public void printInOrder() {
        if ( left != null ) left.printInOrder();
        System.out.println(n);
        if ( right != null ) right.printInOrder();
    }
}
