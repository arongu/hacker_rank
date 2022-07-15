package aron.hacker_rank.binary_search_tree.exercises._2022_07_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static aron.hacker_rank.binary_search_tree.exercises._2022_07_15.BST.*;

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
        BSTNode root = new BSTNode(50);
        root.left    = new BSTNode(30);

        assertTrue(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        root.left.right = new BSTNode(60);
        assertFalse(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /*
            50
          /    \
        30     70
       /  \   /
      20  42 52
         /
        36
     */

    @Test
    public void test_b(){
        BSTNode root         = new BSTNode(50);
        root.left            = new BSTNode(30);
        root.left.right      = new BSTNode(42);
        root.left.right.left = new BSTNode(36);
        root.left.left       = new BSTNode(20);
        root.right           = new BSTNode(70);
        root.right.left      = new BSTNode(52);

        assertTrue(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
