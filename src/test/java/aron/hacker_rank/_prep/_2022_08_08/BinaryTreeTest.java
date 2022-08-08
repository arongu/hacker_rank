package aron.hacker_rank._prep._2022_08_08;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    public void comprehensiveTest () {
        final BinaryTree binaryTree = new BinaryTree(0);

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
        final BinaryTree tree      = new BinaryTree(0);
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

        tree.printInOrder();
    }

    @Test
    public void check() {
        final BinaryTree tree      = new BinaryTree(0);
        final Random random        = new Random();

        for (int i = 0; i < 20; i++ ) {
            int n = random.nextInt(10000);
            tree.add(n);
        }

        assertTrue(CheckTree.checkTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
