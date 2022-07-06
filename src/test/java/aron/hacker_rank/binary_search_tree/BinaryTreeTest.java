package aron.hacker_rank.binary_search_tree;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    @Test
    public void comprehensiveTest () {
        final BinaryTree binaryTree = new BinaryTree();

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
        final BinaryTree tree = new BinaryTree();
        final Random random        = new Random();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 20; i++ ) {
            int n = random.nextInt(10000);
            tree.add(n);
            stack.push(n);
        }

        while ( !stack.isEmpty() ) {
            assertTrue(tree.contains(stack.pop()));
        }
    }
}
