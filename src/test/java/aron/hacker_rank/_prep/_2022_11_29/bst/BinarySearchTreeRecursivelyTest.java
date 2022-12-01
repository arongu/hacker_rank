package aron.hacker_rank._prep._2022_11_29.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeRecursivelyTest {
    @Test
    public void test() {
        final BST tree = new BinarySearchTreeRecursively(10);
        tree.add(100);
        tree.add(51);
        tree.add(150);
        tree.add(150);
        tree.add(150);
        tree.printInOrder();
        assertTrue(tree.contains(100));
        assertTrue(tree.contains(150));
        assertTrue(tree.contains(51));
        assertFalse(tree.contains(0));
    }
}
