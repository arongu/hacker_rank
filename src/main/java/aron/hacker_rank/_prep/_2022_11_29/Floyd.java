package aron.hacker_rank._prep._2022_11_29;

public class Floyd {
    public static class Node {
        Node nextNode;
        int value;

        public Node(final int value) {
            this.value = value;
        }
    }

    private static Node moveOne(final Floyd.Node node) {
        return node == null ? null : node.nextNode;
    }

    private static Node moveTwo(final Floyd.Node node) {
        return moveOne(moveOne(node));
    }

    public static boolean hasLoop(final Floyd.Node root){
        Floyd.Node slow = moveOne(root);
        Floyd.Node fast = moveTwo(root);

        int i = 1;
        while ( slow != null || fast != null ) {
            System.out.println(i);
            if ( slow == fast ) return true;
            slow = moveOne(slow);
            fast = moveTwo(fast);
            i++;
        }

        return false;
    }
}
