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

        binaryTree.insert(100);
        binaryTree.insert(80);
        binaryTree.insert(92);
        binaryTree.insert(92);
        binaryTree.insert(90);
        binaryTree.insert(105);
        binaryTree.insert(101);
        binaryTree.insert(99);

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
        assertTrue(tree.checkBST());
    }
}
