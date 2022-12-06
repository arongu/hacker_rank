package aron.hacker_rank._prep._2022_12_06.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeRecursiveImplTest {
    @Test
    public void test() {
        final BinarySearchTree<Integer> tree = new BinarySearchTreeRecursiveImpl<>(10);
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

    @Test
    public void test2() {
        final BinarySearchTree<String> tree = new BinarySearchTreeRecursiveImpl<>("alpha");
        tree.add("alma");
        tree.add("korte");
        tree.add("almas");
        tree.add("cekla");
        tree.add("zamat");
        tree.printInOrder();
        assertTrue(tree.contains("alma"));
        assertFalse(tree.contains("marha"));
    }
}
