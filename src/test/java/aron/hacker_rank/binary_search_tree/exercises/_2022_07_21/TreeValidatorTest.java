package aron.hacker_rank.binary_search_tree.exercises._2022_07_21;

import org.junit.jupiter.api.Test;

import static aron.hacker_rank.binary_search_tree.exercises._2022_07_21.TreeValidator.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeValidatorTest {
    /*
        50
       /
      30
        \
        60
    */


    @Test
    public void test_a() {
        Node root = new Node(50);
        root.left = new Node(30);

        assertTrue(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        root.left.right = new Node(60);
        assertFalse(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
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
    public void test_b() {
        Node root            = new Node(50);
        root.left            = new Node(30);
        root.left.right      = new Node(42);
        root.left.right.left = new Node(36);
        root.left.left       = new Node(20);
        root.right           = new Node(70);
        root.right.left      = new Node(52);

        assertTrue(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
