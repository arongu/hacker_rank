package aron.hacker_rank._prep._2022_08_23;

public class BinarySearchTreeValidator {
    private static boolean isValid(final BinarySearchTree tree, int min, int max ) {
        if ( tree == null ) return true;
        if ( tree.getN() > max || tree.getN() < min ) return false;

        return isValid(tree.getLeft(), min, tree.getN() - 1) && isValid(tree.getRight(), tree.getN() + 1, max);
    }

    public static boolean test (final BinarySearchTree binarySearchTree) {
        return isValid(binarySearchTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
