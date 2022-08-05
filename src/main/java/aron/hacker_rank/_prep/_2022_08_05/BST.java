package aron.hacker_rank._prep._2022_08_05;

import aron.hacker_rank.binary_search_tree.BST.Node;

public class BST {
    public static boolean checkBST(final Node node, int min, int max) {
        if ( node == null ) return true;
        if ( node.number < min || node.number > max ) return false;

        return checkBST(node.left, min, node.number - 1) && checkBST(node.right, node.number + 1, max);
    }
}
