package aron.hacker_rank._prep._2022_11_29.btree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BTreeTest {
    @Test
    public void test() {
        final BTree bTree = new BTree();
        assertFalse(bTree.contains(10));
        bTree.add(100);
        bTree.add(51);
        bTree.add(150);
        bTree.add(150);
        bTree.add(150);
        bTree.printInOrder();
        assertTrue(bTree.contains(100));
        assertTrue(bTree.contains(150));
        assertTrue(bTree.contains(51));
        assertTrue(BTree.validate(bTree));
    }

    @Test
    public void testValidator() {
        BNode root = new BNode(100);
        root.left = new BNode(50);
        root.right = new BNode(49);

        assertFalse(BTree.validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        root.right = new BNode(150);
        assertTrue(BTree.validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
