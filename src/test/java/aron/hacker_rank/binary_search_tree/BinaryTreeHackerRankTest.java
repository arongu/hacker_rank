package aron.hacker_rank.binary_search_tree;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeHackerRankTest {
    @Test
    public void comprehensiveTest () {
        final BinaryTreeHackerRank binaryTree = new BinaryTreeHackerRank();

        assertFalse(binaryTree.contains(100));
        System.out.println();

        binaryTree.insert(100);
        System.out.println();

        binaryTree.insert(80);
        System.out.println();

        binaryTree.insert(92);
        System.out.println();

        binaryTree.insert(92);
        System.out.println();

        binaryTree.insert(90);
        System.out.println();

        binaryTree.insert(105);
        System.out.println();

        binaryTree.insert(101);
        System.out.println();

        binaryTree.insert(99);
        System.out.println();

        assertTrue(binaryTree.contains(90));
    }

    @Test
    public void randomInsertTest() {
        final BinaryTreeHackerRank tree = new BinaryTreeHackerRank();
        final Random random             = new Random();
        final Stack<Integer> stack      = new Stack<>();

        for (int i = 0; i < 20; i++ ) {
            int n = random.nextInt(10000);
            tree.insert(n);
            stack.push(n);
        }

        while ( !stack.isEmpty() ) {
            assertTrue(tree.contains(stack.pop()));
        }

        tree.printInOrder();
    }
}
