package aron.hacker_rank.floyd.exercises._2022_07_21;

import java.util.Random;

public class FloydStatic {
    public static class Node {
        private final int n;
        private Node nextNode;

        public Node(final int n) {
            this.n = n;
        }
    }

    public static Node getNodes() {
        final Random random = new Random();
        Node it, root = new Node(random.nextInt(10000));

        it = root;
        for ( int i = 0; i < 19; i++ ) {
            it.nextNode = new Node(random.nextInt(10000));
            it = it.nextNode;
        }

        return root;
    }

    public static Node getTail(final Node root) {
        if ( root == null ) return null;

        for ( Node n = root;; ) {
            if ( n.nextNode != null )
                n = n.nextNode;
            else
                return n;
        }
    }

    public static void connectTailToRoot(final Node root) {
        if ( root == null ) return;

        if ( hasLoop(root) ) {
            System.out.println("Cannot connect - loop detected !");
            return;
        }

        Node tail = getTail(root);
        tail.nextNode = root;
    }

    public static Node moveOne(final Node node) {
        return node != null ? node.nextNode : null;
    }

    public static Node moveTwo(final Node node) {
        return moveOne(moveOne(node));
    }

    public static boolean hasLoop(final Node root) {
        Node slow = moveOne(root), fast = moveOne(slow);

        for ( ; slow != null && fast != null; slow = moveOne(slow), fast = moveTwo(fast) ) {
            if ( slow == fast ) return true;
        }

        return false;
    }

    public static void print(final Node root) {
        for ( Node it = root; it != null; it = it.nextNode ) {
            System.out.println(it.n);
        }
    }
}
