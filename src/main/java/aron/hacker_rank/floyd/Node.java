package aron.hacker_rank.floyd;

public class Node<T> {
    private Node<T> nextNode;
    private T value;

    public Node(Node<T> nextNode, T value) {
        this.nextNode = nextNode;
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public T getValue() {
        return value;
    }

    public void setNextNode(final Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void setValue(final T value) {
        this.value = value;
    }
}
