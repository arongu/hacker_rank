package aron.hacker_rank.binary_search_tree;

import aron.hacker_rank.floyd.Node;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeImplTest {
    @Test
    public void comprehensiveTest () {
        final BinaryTreeFirstImpl binaryTree = new BinaryTreeFirstImpl();

        assertFalse(binaryTree.contains(100));
        System.out.println();

        binaryTree.add(100);
        System.out.println();

        binaryTree.add(80);
        System.out.println();

        binaryTree.add(92);
        System.out.println();

        binaryTree.add(92);
        System.out.println();

        binaryTree.add(90);
        System.out.println();

        binaryTree.add(105);
        System.out.println();

        binaryTree.add(101);
        System.out.println();

        binaryTree.add(99);
        System.out.println();

        assertTrue(binaryTree.contains(90));
    }

    @Test
    public void randomAddTest() {
        final BinaryTreeFirstImpl tree = new BinaryTreeFirstImpl();
        final Random random = new Random();

        for (int i = 0; i < 100; i++ ) {
            tree.add(random.nextInt(10000));
        }
    }
}
