package aron.hacker_rank._prep._2022_12_04;

public class Floyd<T> {
    // static
    public static <T> Floyd<T> moveOne(final Floyd<T> node) {
        return node != null ? node.nextNode : null;
    }

    public static <T> Floyd<T> moveTwo(final Floyd<T> node) {
        return moveOne(moveOne(node));
    }

    public static <T> boolean hasLoop(Floyd<T> root) {
        if ( root == null ) return false;
        Floyd<T> slow = moveOne(root);
        Floyd<T> fast = moveTwo(root);

        while ( slow != null || fast != null ) {
            if ( slow == fast ) return true;
            slow = moveOne(slow);
            fast = moveTwo(fast);
        }

        return false;
    }

    // instance
    private final T value;
    private Floyd<T> nextNode;

    public Floyd(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Floyd<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Floyd<T> nextNode) {
        this.nextNode = nextNode;
    }
}
