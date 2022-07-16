package aron.hacker_rank.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieUpdatedMap {
    private static class Node {
        public char c;
        public boolean isWord;
        public Map<Character, Node> children = null;

        public Node(final char c) {
            this.c   = c;
            isWord   = false;
        }
    }

    private final Node root;
    private boolean debug = false;

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public TrieUpdatedMap() {
        root = new Node('/');
    }

    public void insert(final String word) {
        Node it = root;
        final String lowercase = word.toLowerCase();
        // debug
        if ( debug ) System.out.println(lowercase);

        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);
            // debug
            if ( debug ) System.out.println("@ " + it.c);

            // 'look up' the character in the current node
            // if it does not have create a node with that character/letter
            Node node;
            if ( it.children == null ) {
                it.children = new HashMap<>();
                node = new Node(c);
                it.children.put(c, node);
                it = node;

                // debug
                if ( debug ) System.out.println("++ " + c);

            } else if ( it.children.get(c) == null ) {
                node = new Node(c);
                it.children.put(c, node);
                it = node;
                // debug
                if ( debug ) System.out.println("++ " + c);

            } else {
                it = it.children.get(c);
            }
        }

        it.isWord = true;
        if ( debug ) System.out.println();
    }

    private Node getNode(final String word) {
        Node it = root;
        final String lowercase = word.toLowerCase();

        for ( int i = 0; i < lowercase.length(); i++ ) {
            char c = lowercase.charAt(i);

            Node node = it.children.get(c);
            if ( node == null ) return null;
            it = node;
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
