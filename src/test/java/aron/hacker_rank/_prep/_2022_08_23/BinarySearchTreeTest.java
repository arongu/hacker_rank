package aron.hacker_rank._prep._2022_08_23;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    @Test
    public void comprehensiveTest () {
        final BinarySearchTree tree = new BinarySearchTree(0);

        assertFalse(tree.contains(100));
        tree.add(100);
        tree.add(80);
        tree.add(92);
        tree.add(92);
        tree.add(90);
        tree.add(105);
        tree.add(101);
        tree.add(99);
        assertTrue(tree.contains(90));
    }

    @Test
    public void randomAddTest() {
        final BinarySearchTree tree = new BinarySearchTree(0);
        final Random random         = new Random();
        final Stack<Integer> stack  = new Stack<>();

        for ( int i = 0; i < 20; i++ ) {
            int n = random.nextInt(10000);
            tree.add(n);
            stack.push(n);
        }

        while ( !stack.isEmpty() ) {
            assertTrue(tree.contains(stack.pop()));
        }

        tree.printInOrder();
        assertTrue(BinarySearchTreeValidator.test(tree));
    }
}
