package aron.hacker_rank.binary_search_tree;

public class BinaryTreeFirstImpl {
    private static class Node {
        private Node leftNode, rightNode;
        private int value;

        public Node() {
            this.leftNode  = null;
            this.rightNode = null;
        }

        public Node(final int value) {
            this.value     = value;
            this.leftNode  = null;
            this.rightNode = null;
        }
    }

    private Node rootNode = null;

    public void add(int number) {
        System.out.println("adding " + number);

        if ( rootNode == null ) {
            rootNode = new Node(number);
            System.out.println("root " + rootNode.value);
            return;
        }

        Node saved = null, moving = rootNode;
        boolean shouldBeInLeft = false;

        while ( moving != null ) {
            if ( number < moving.value ) {
                System.out.println("<-- " + moving.value);

                saved  = moving;
                moving = moving.leftNode;
                shouldBeInLeft = true;

            } else if ( number > moving.value ) {
                System.out.println("--> " + moving.value);

                saved  = moving;
                moving = moving.rightNode;
                shouldBeInLeft = false;

            } else {
                System.out.println("= " + moving.value);
                return;
            }
        }

        if ( shouldBeInLeft ) {
            saved.leftNode = new Node(number);
            System.out.println("<-- ++ " + number);

        } else {
            saved.rightNode = new Node(number);
            System.out.println("--> ++  " + number);
        }
    }

    public boolean contains(int number) {
        System.out.println("looking for " + number);
        for (Node it = rootNode; it != null; ) {
            if ( number < it.value ) {
                System.out.println("<-- " + it.value);
                it = it.leftNode;

            } else if ( number > it.value ) {
                System.out.println("--> " + it.value);
                it = it.rightNode;

            } else {
                System.out.println("contains " + it.value);
                return true;
            }
        }

        System.out.println("does not contain " + number);
        return false;
    }
}
