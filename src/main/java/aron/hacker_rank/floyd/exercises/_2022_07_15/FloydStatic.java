package aron.hacker_rank.floyd.exercises._2022_07_15;

public class FloydStatic {
    // inner class for linked list
    public static class Node {
        public Node nextNode;
        int n;

        public Node(final int n) {
            this.n = n;
        }
    }

    public static Node advanceOne(final Node node) {
        return node != null ? node.nextNode : null;
    }

    public static Node advanceTwo(final Node node) {
        return advanceOne(advanceOne(node));
    }

    public static boolean askFloyd(final Node node) {
        if ( node == null ) return false;

        for ( Node tortoise = advanceOne(node), hare = advanceTwo(node); tortoise != null || hare != null; tortoise = advanceOne(tortoise), hare = advanceTwo(hare) ) {
            if ( tortoise == hare ) return true;
        }

        return false;
    }

    // utility functions
    public static Node getNodes() {
        final Node root = new Node(0);
        Node node = root;

        for ( int i = 1; i < 10; i++ ) {
            node.nextNode = new Node(i);
            node = node.nextNode;
        }

        return root;
    }

    public static void connectTailToRoot(final Node root) {
        Node tail = null;

        for ( Node it = root; it != null; it = it.nextNode ) {
            tail = it;
        }

        if ( tail != null ) tail.nextNode = root;
    }

    public static void print(final Node root) {
        for ( Node it = root; it != null; it = it.nextNode ) {
            System.out.println(it.n);
        }
    }
}
