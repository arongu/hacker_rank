package aron.hacker_rank._prep._2022_08_05;

public class Floyd {
    public static class Node {
        int number;
        Node next;

        public Node(final int number) {
            this.number = number;
        }
    }

    public static void linkHeadToTail(final Node root) {
        if ( root == null ) return;

        Node tail;
        for ( tail = root; tail.next != null; tail = tail.next );

        tail.next = root;
    }

    private static Node advanceOne(final Node node){
        if ( node == null ) return null;

        return node.next;
    }

    private static Node advanceTwo(final Node node) {
        return advanceOne(advanceOne(node));
    }

    public static boolean hasLoop(final Node root) {
        if ( root == null ) return false;

        Node slow = advanceOne(root), fast = advanceOne(slow);

        while ( slow != null || fast != null ) {
            if ( slow == fast ) return  true;
            slow = advanceOne(slow);
            fast = advanceTwo(fast);
        }

        return false;
    }
}
