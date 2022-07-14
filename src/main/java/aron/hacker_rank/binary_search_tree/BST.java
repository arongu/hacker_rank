package aron.hacker_rank.binary_search_tree;

public class BST {
    public static class Node {
        public int number;
        public Node left, right;

        public Node(final int number) {
            this.number = number;
        }
    }

    public static boolean checkBST(final Node node, int min, int max) {
        // if it is null true is returned
        // which means if the starting node is null
        // you will get back a true
        // it also means the leaf nodes will get a pass, they will not be tested
        // because they will get a true
        if ( node == null ) {
            return true;
        }

        System.out.printf(String.format("number %d, min %d, max %d\n", node.number, min, max));

        // which means that this if statement's job is to fail the recursion
        // while it traverses through the nodes
        if ( node.number < min || node.number > max ) {
            return false;
        }

        // keep going
        return checkBST(node.left, min, node.number - 1) && checkBST(node.right, node.number + 1, max);
    }

    //return checkBST(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
