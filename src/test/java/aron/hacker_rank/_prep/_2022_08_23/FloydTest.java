package aron.hacker_rank._prep._2022_08_23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydTest {
    @Test
    public void test() {
        Floyd<Integer> floyd = new Floyd<>();
        Floyd.Node<Integer> noLoop  = floyd.noLoop();
        Floyd.Node<Integer> hasLoop = floyd.loop();

        assertFalse(floyd.hasLoop(noLoop));
        assertTrue(floyd.hasLoop(hasLoop));
    }
}
