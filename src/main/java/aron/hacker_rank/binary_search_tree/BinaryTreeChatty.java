package aron.hacker_rank.binary_search_tree;

public class BinaryTreeChatty {
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

    private Node findLeaf(final Node rootNode, final int number) {
        Node leaf = null;

        if ( rootNode != null ) {
            for ( Node it = rootNode; it != null; ) {
                if ( number < it.value ) {
                    System.out.println("<-- " + it.value);
                    leaf = it;
                    it = it.leftNode;

                } else if ( number > it.value ) {
                    System.out.println("--> " + it.value);
                    leaf = it;
                    it = it.rightNode;

                } else {
                    System.out.println("contains " + it.value);
                    return it;
                }
            }
        }

        return leaf;
    }


    public void add(int number) {
        System.out.println("adding " + number);
        if ( rootNode == null ) {
            rootNode = new Node(number);
            System.out.println("root " + rootNode.value);

        } else {
            Node node = findLeaf(rootNode, number);
            if ( number < node.value ) {
                node.leftNode = new Node(number);
                System.out.println("++ <-- " + number);

            } else if ( number > node.value ) {
                node.rightNode = new Node(number);
                System.out.println("++ --> " + number);
            }
        }
    }

    public boolean contains(int number) {
        final Node node = findLeaf(rootNode, number);
        return node != null && node.value == number;
    }
}
