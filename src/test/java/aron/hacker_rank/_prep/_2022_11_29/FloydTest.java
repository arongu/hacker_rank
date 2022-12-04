package aron.hacker_rank._prep._2022_11_29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydTest {
    @Test
    public void noLoop() {
        Floyd.Node root = new Floyd.Node(0);
        Floyd.Node node = root;

        for ( int i = 1; i < 10; i++ ) {
            node.nextNode = new Floyd.Node(i);
            node = node.nextNode;
        }

        assertFalse(Floyd.hasLoop(root));
    }

    @Test
    public void hasLoop() {
        Floyd.Node root = new Floyd.Node(0);
        Floyd.Node node = root;

        for ( int i = 1; i < 10; i++ ) {
            node.nextNode = new Floyd.Node(i);
            node = node.nextNode;
            if ( i == 9 ) node.nextNode = root;
        }

        assertTrue(Floyd.hasLoop(node));
    }

    @Test
    public void hasLoop2() {
        Floyd.Node root = new Floyd.Node(0);
        root.nextNode = root;

        assertTrue(Floyd.hasLoop(root));
    }

}
