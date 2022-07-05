package aron.hacker_rank.floyd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydExercise1Test {
    @Test
    public void noLoop() {
        Node<Integer> head = null, ptr = null;

        for ( int i = 0; i < 10 ; i ++ ) {
            if ( head == null ) {
                head = new Node<>(null, i);
                ptr  = head;
            } else {
                ptr.setNextNode(new Node<>(null, i));
            }
        }

        assertFalse(FloydExercise1.hasLoop(head));
    }

    @Test
    public void loop() {
        Node<Integer> head = null, ptr = null, loopEntry = null;

        for ( int i = 0; i < 25 ; i ++ ) {
            if ( head == null ) {
                head = new Node<>(null, i);
                ptr  = head;
            } else {
                ptr.setNextNode(new Node<>(null, i));
                if ( i == 15 ) {
                    loopEntry = ptr;
                }
            }
        }

        assertFalse(FloydExercise1.hasLoop(head));
        ptr.setNextNode(loopEntry);
        assertTrue(FloydExercise1.hasLoop(head));
    }
}