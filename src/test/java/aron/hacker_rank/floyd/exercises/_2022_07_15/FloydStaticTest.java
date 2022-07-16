package aron.hacker_rank.floyd.exercises._2022_07_15;

import org.junit.jupiter.api.Test;

import static aron.hacker_rank.floyd.exercises._2022_07_15.FloydStatic.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydStaticTest {
    private static final Node noloop = getNodes();
    private static final Node looped = getNodes();

    static {
        connectTailToRoot(looped);
    }

    @Test
    void test() {
        assertFalse(hasLoop(noloop));
        print(noloop);
        assertTrue(hasLoop(looped));
    }
}

