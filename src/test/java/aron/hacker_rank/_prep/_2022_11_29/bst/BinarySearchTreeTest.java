package aron.hacker_rank._prep._2022_11_29.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    @Test
    public void test() {
        final BST tree = new BinarySearchTree();
        assertFalse(tree.contains(10));
        tree.add(100);
        tree.add(51);
        tree.add(150);
        tree.add(150);
        tree.add(150);
        tree.printInOrder();
        assertTrue(tree.contains(100));
        assertTrue(tree.contains(150));
        assertTrue(tree.contains(51));
        assertTrue(BinarySearchTree.validate((BinarySearchTree) tree));
    }

    @Test
    public void testValidator() {
        BSTNode root = new BSTNode(100);
        root.left = new BSTNode(50);
        root.right = new BSTNode(49);

        assertFalse(BinarySearchTree.validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        root.right = new BSTNode(150);
        assertTrue(BinarySearchTree.validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
