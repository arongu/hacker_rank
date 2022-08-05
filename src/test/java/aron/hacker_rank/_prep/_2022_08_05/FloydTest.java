package aron.hacker_rank._prep._2022_08_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static aron.hacker_rank._prep._2022_08_05.Floyd.Node;

public class FloydTest {
    static private final Node noLoop, loop;

    static {
        Node it;
        noLoop = new Node(0);
        it = noLoop;
        for ( int i = 1; i < 49; i++ ) {
            it.next = new Node(i);
            it = it.next;
        }


        loop = new Node(0);
        it = loop;
        for ( int i = 1; i < 49; i++ ) {
            it.next = new Node(i);
            it = it.next;
        }

        Floyd.linkHeadToTail(loop);
    }

    @Test
    public void test(){
        assertFalse(Floyd.hasLoop(noLoop));
        assertTrue(Floyd.hasLoop(loop));
        assertFalse(Floyd.hasLoop(null));
    }
}
