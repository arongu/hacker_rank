package aron.hacker_rank.binary_search_tree;

public class HackerRankNode {
    private HackerRankNode left = null, right = null;
    private final int value;

    public HackerRankNode(final int value) {
        this.value = value;
    }

    // value will never be null, because of the constructor definition..
    // another trick of Gale, that is why you have a root node implicitly
    public void insert(final int number) {
        if ( number < this.value ) {
            if ( this.left == null ) {
                this.left = new HackerRankNode(number);

            } else {
                this.left.insert(number);
            }

        } else if ( number > this.value ) {
            if ( this.right == null ) {
                this.right = new HackerRankNode(number);

            } else {
                this.right.insert(number);
            }
        }
    }

    public boolean contains(final int number) {
        if ( number < this.value ) {
            if ( this.left != null ) return this.left.contains(number);
            return false;

        } else if ( number > this.value ) {
            if ( this.right != null ) return this.right.contains(number);
            return false;
        }

        return true;
    }

    public void printInOrder() {
        if ( this.left != null ) {
            this.left.printInOrder();
        }

        System.out.println(this.value);

        if ( this.right != null ) {
            this.right.printInOrder();
        }
    }
}
