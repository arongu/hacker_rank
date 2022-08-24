package aron.hacker_rank._prep._2022_08_23;

public class Floyd<E> {
    public static class Node<E> {
        private Node<E> nextNode;
        private final E value;

        public Node(final E value) {
            this.value = value;
        }
    }

    public Node<Integer> noLoop() {
        Node<Integer> root = new Node<>(0), node = root;

        for ( int i = 1; i < 10; i++ ) {
            node.nextNode = new Node<>(i);
            node = node.nextNode;
        }

        return root;
    }

    public Node<Integer> loop() {
        Node<Integer> root = new Node<>(0), node = root;

        for ( int i = 1; i < 10; i++ ) {
            node.nextNode = new Node<>(i);
            node = node.nextNode;
        }

        node.nextNode = root;
        return root;
    }

    public Node<E> moveOne(final Node<E> node) {
        return node != null ? node.nextNode : null;
    }

    public Node<E> moveTwo(final Node<E> node) {
        return moveOne(moveOne(node));
    }

    public boolean hasLoop(final Node<E> rootNode) {
        Node<E> slow = moveOne(rootNode);
        Node<E> fast = moveOne(slow);

        while ( slow != null && fast != null ) {
            if ( slow == fast ) return true;
            slow = moveOne(slow);
            fast = moveTwo(fast);
        }

        return false;
    }
}
