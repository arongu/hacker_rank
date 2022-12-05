package aron.hacker_rank._prep._2022_12_04.binary_search_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    private static final BinarySearchTree<String> treeString;
    private static final BinarySearchTree<Integer> treeInteger;

    static {
        treeString = new BinarySearchTree<>(new ComparatorString());
        treeInteger= new BinarySearchTree<>(new ComparatorInteger());
    }

    @Test
    public void stringTreeTest() {
        treeString.add("alma");
        treeString.add("Alma");
        treeString.add("barack");
        treeString.add("Barack");
        treeString.printInOrder();
        assertTrue(treeString.contains("Barack"));
        assertFalse(treeString.contains("none"));
    }

    @Test
    public void integerTreeTest() {
        treeInteger.add(0);
        treeInteger.add(5);
        treeInteger.add(10);
        treeInteger.add(1);
        treeInteger.add(22);
        treeInteger.printInOrder();
        assertTrue(treeInteger.contains(0));
        assertFalse(treeInteger.contains(-1));
    }
}
