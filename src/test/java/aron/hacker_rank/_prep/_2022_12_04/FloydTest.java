package aron.hacker_rank._prep._2022_12_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydTest {
    @Test
    void noLoop() {
        final Floyd<Integer> root = new Floyd<>(0);
        Floyd<Integer> ptr = root;

        for ( int i = 1; i < 10; i++ ) {
            Floyd<Integer> tmp = new Floyd<>(i);
            ptr.setNextNode(tmp);
            ptr = tmp;
        }

        assertFalse(Floyd.hasLoop(root));
        ptr.setNextNode(root);
        assertTrue(Floyd.hasLoop(root));
    }
}
