package aron.hacker_rank.trie;

public class TrieUpdated {
    private static class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(final char c) {
            this.c   = c;
            isWord   = false;
            children = new Node[26]; // 26 'sockets' to support english alphabet
                                     // a - a = 0
                                     // b - a = 1
                                     // c - a = 2
            // """hash""" value, a = 97
            // it serves as an index to get the element in the children
        }
    }

    private final Node root;
    private boolean debug = false;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public TrieUpdated() {
        root = new Node('/');
    }

    public void insert(final String word) {
        Node it = root;
        final String lowercase = word.toLowerCase();
        // debug
        if ( debug ) System.out.println(lowercase);

        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            int characterIndex = c - 'a';
            // debug
            if ( debug ) System.out.println("@ " + it.c);

            // 'look up' the character in the current node
            // if it does not have create a node with that character/letter
            if ( it.children[characterIndex] == null ) {
                it.children[characterIndex] = new Node(c);
                // debug
                if ( debug )  System.out.println("++ " + c + "(" + characterIndex + ")");
            }

            // move the iterator to the index
            it = it.children[characterIndex];
        }

        it.isWord = true;
        if ( debug ) System.out.println();
    }

    private Node getNode(final String word) {
        Node it = root;
        final String lowercase = word.toLowerCase();

        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            int characterIndex = c - 'a';

            if ( it.children[characterIndex] == null ) {
                return null;

            } else {
                it = it.children[characterIndex];
            }
        }

        return it;
    }

    public boolean search(final String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(final String prefix) {
        return getNode(prefix) != null;
    }
}
