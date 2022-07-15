package aron.hacker_rank.floyd.exercises._2022_07_03;

import aron.hacker_rank.floyd.Node;
import org.junit.jupiter.api.Assertions;
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

        Assertions.assertFalse(FloydExercise1.hasLoop(head));
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
