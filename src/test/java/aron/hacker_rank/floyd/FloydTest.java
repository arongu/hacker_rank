package aron.hacker_rank.floyd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydTest {
    @Test
    public void noLoop() {
        final Floyd floyd = new Floyd();

        floyd.resetNoLoop( 100);
        assertFalse(floyd.hasCycle(floyd.getHead()));
    }

    @Test
    public void hasLoop() {
        final Floyd floyd = new Floyd();

        floyd.resetLoop(100);
        assertTrue(floyd.hasCycle(floyd.getHead()));
    }
}
