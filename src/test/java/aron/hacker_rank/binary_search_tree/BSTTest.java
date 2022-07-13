package aron.hacker_rank.binary_search_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BSTTest {
    /*
          50
         /
        30
          \
          60

     */


    @Test
    public void test_a(){
        BST.Node root = new BST.Node(50);
        root.left     = new BST.Node(30);

        assertTrue(BST.checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        root.left.right = new BST.Node(60);
        assertTrue(BST.checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

        /*
           50
         /    \
        30    70
       /  \   /
      20  42  52
         /
        36
     */

    @Test
    public void test_b(){
        BST.Node root   = new BST.Node(50);
        root.left       = new BST.Node(30);
        root.left.right = new BST.Node(42);
        root.left.right.left = new BST.Node(36);
        root.left.left  = new BST.Node(20);
        root.right      = new BST.Node(70);
        root.right.left = new BST.Node(52);

        assertTrue(BST.checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
