package aron.hacker_rank.binary_search_tree;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HackerRankNodeTest {
    @Test
    public void comprehensiveTest () {
        final HackerRankNode tree = new HackerRankNode(0);

        assertFalse(tree.contains(100));
        tree.insert(100);
        tree.insert(80);
        tree.insert(92);
        tree.insert(92);
        tree.insert(90);
        tree.insert(105);
        tree.insert(101);
        tree.insert(99);
        assertTrue(tree.contains(90));
        assertTrue(tree.contains(0));
    }

    @Test
    public void randomInsertTest() {
        final Random random        = new Random();
        final HackerRankNode tree  = new HackerRankNode(random.nextInt(10000));
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 19; i++ ) {
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
