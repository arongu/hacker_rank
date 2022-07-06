package aron.hacker_rank.floyd.exercises;

import aron.hacker_rank.floyd.Node;

public class FloydExercise2<T> {
    private static <T> Node<T> moveOne(final Node<T> node) {
        return node != null ? node.getNextNode() : null;
    }

    private static <T> Node<T> moveTwo(final Node<T> node) {
        return moveOne(moveOne(node));
    }

    public static <T> boolean hasLoop(final Node<T> head) {
        if ( head == null ) return false;

        Node<T> slow = moveOne(head);
        Node<T> fast = moveTwo(head);

        while (slow != null && fast != null ) {
            if ( slow == fast ) return true;
            slow = moveOne(slow);
            fast = moveTwo(fast);
        }

        return false;
    }
}
