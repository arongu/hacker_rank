package aron.hacker_rank.binary_search_tree.exercises;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTree1Test {
    @Test
    public void comprehensiveTest () {
        final BinaryTree1 binaryTree = new BinaryTree1();
        assertFalse(binaryTree.contains(100));
        binaryTree.add(100);
        binaryTree.add(80);
        binaryTree.add(92);
        binaryTree.add(92);
        binaryTree.add(90);
        binaryTree.add(105);
        binaryTree.add(101);
        binaryTree.add(99);
        assertTrue(binaryTree.contains(90));
    }

    @Test
    public void randomAddTest() {
        final BinaryTree1 tree     = new BinaryTree1();
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
