package aron.hacker_rank.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieUpdatedMap {

    private static class Node {
        public char c;
        public boolean isWord;
        public Map<Character, Node> links = null;

        public Node(final char c) {
            this.c = c;
            isWord = false;
        }
    }

    private final Node rootNode;
    private boolean debug;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public TrieUpdatedMap(boolean debug) {
        this.debug = debug;
        rootNode   = new Node('/');
    }

    public void insert(final String word) {
        final String lowercase = word.toLowerCase();
        // debug
        if ( debug ) System.out.println(lowercase);

        Node node = rootNode;
        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            // debug
            if ( debug ) System.out.println("@ " + node.c);

            // 'look up' the character in the current node
            // if it does not have create a node with that character/letter
            if ( node.links == null ) {
                node.links = new HashMap<>();
                final Node newNode = new Node(c);
                node.links.put(c, newNode);
                node = newNode;

                // debug
                if ( debug ) System.out.println("++ " + c);

            } else {
                final Node result = node.links.get(c);

                if ( result == null ) {
                    final Node newNode = new Node(c);
                    node.links.put(c, newNode);
                    node = newNode;
                    // debug
                    if ( debug ) System.out.println("++ " + c);

                } else {
                    node = result;
                }
            }
        }

        node.isWord = true;
        if ( debug ) System.out.println();
    }

    private Node getNode(final String word) {
        final String lowercase = word.toLowerCase();

        Node node = rootNode;
        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);

            Node result = node.links.get(c);
            if ( result == null ) return null;
            node = result;
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
