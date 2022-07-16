package aron.hacker_rank.trie;

public class TrieUpdated {
    private static class Node {
        public char c;
        public boolean isWord;
        public Node[] links;

        public Node(final char c) {
            this.c = c;
            isWord = false;
            links = new Node[26]; // 26 possible 'links/leafs' to support english alphabet
                                  // a - a = 0, b - a = 1, c - a = 2, """hash""" value, a = 97 crude """hash function"""
        }
    }

    private final Node rootNode;
    private boolean debug = false;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public TrieUpdated() {
        rootNode = new Node('/');
    }

    public void insert(final String word) {
        final String lowercase = word.toLowerCase();
        if ( debug ) System.out.println(lowercase);

        Node node = rootNode;
        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            int linkIndex = c - 'a';

            if ( debug ) System.out.println("@ " + node.c);


            if ( node.links[linkIndex] == null ) {
                node.links[linkIndex] = new Node(c);

                if ( debug )  System.out.println("++ " + c + "(" + linkIndex + ")");
            }

            node = node.links[linkIndex];
        }

        node.isWord = true;
        if ( debug ) System.out.println();
    }

    private Node getNode(final String word) {
        Node node = rootNode;
        final String lowercase = word.toLowerCase();

        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            int linkIndex = c - 'a';

            if ( node.links[linkIndex] == null ) {
                return null;

            } else {
                node = node.links[linkIndex];
            }
        }

        return node;
    }

    public boolean search(final String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(final String prefix) {
        return getNode(prefix) != null;
    }
}
