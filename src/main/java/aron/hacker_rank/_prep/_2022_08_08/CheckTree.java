package aron.hacker_rank._prep._2022_08_08;

public class CheckTree {
    public static boolean checkTree(final BinaryTree tree, final int min, final int max) {
        if ( tree == null ) return true;

        if ( tree.getN() < min || tree.getN() > max ) return false;
        return checkTree(tree.getLeft(), min, tree.getN() - 1) && checkTree(tree.getRight(), tree.getN() + 1, max);
    }
}
