package aron.hacker_rank.trie.exercises._2022_07_21;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {

    private static class TrieNode {
        private Map<Character, TrieNode> leafs = null;
        private final char letter;
        private boolean isWord;

        public TrieNode(final char letter) {
            this.letter = letter;
            this.isWord = false;
        }

        public TrieNode(final char letter, final boolean isWord) {
            this.letter = letter;
            this.isWord = isWord;
        }
    }

    private boolean debug;
    private final TrieNode root = new TrieNode('/');

    public TrieMap(final boolean debug) {
        this.debug = debug;
    }

    public void setDebug(final boolean debug) {
        this.debug = debug;
    }

    private TrieNode lookup(final String word) {
        if ( word == null ) return null;

        TrieNode node = root;
        for ( char c : word.toCharArray() ) {
            node = node.leafs.get(c);
            if ( node == null ) return null;
        }

        return node;
    }

    public void insert(final String word) {
        if ( word == null ) return;

        if ( debug) System.out.println("--- " + word);
        TrieNode node = root;
        for ( char c : word.toCharArray() ) {
            if ( debug) System.out.println("@ " + node.letter);

            if ( node.leafs == null ) {
                TrieNode n = new TrieNode(c);
                node.leafs = new HashMap<>();
                node.leafs.put(c, n);
                node = n;
                if ( debug) System.out.println("+ " + node.letter);

            } else {
                TrieNode n = node.leafs.get(c);
                if ( n == null ) {
                    n = new TrieNode(c);
                    node.leafs.put(c, n);
                }

                node = n;
                if ( debug) System.out.println("+ " + node.letter);
            }
        }

        node.isWord = true;
    }

    public boolean search(final String word) {
        TrieNode n = lookup(word);
        return  n != null && n.isWord;
    }

    public boolean startsWith(final String prefix) {
        return lookup(prefix) != null;
    }
}
