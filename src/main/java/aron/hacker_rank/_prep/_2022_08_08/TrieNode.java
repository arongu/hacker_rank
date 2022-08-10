package aron.hacker_rank._prep._2022_08_08;

import java.util.Stack;

public class TrieNode {
    private static int calculateIndex(final char c) {
        return c - 'a';
    }

    private TrieNode[] children;
    private boolean complete;
    private final char c;

    public TrieNode() {
        c = '/';
    }

    private TrieNode(final char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    // internal methods
    private TrieNode getNode(final TrieNode node, final char c) {
        if ( node == null ) return null;
        return node.children == null ? null : node.children[calculateIndex(c)];
    }

    private TrieNode addNode(final TrieNode parent, final char c) {
        int index = calculateIndex(c);
        TrieNode trie;

        if ( parent.children == null ) {
            parent.children = new TrieNode[26];
            trie = new TrieNode(c);
            parent.children[index] = trie;

        } else {
            trie = parent.children[index];
            if ( trie == null ) {
                trie = new TrieNode(c);
                parent.children[index] = trie;
            }
        }

        return trie;
    }

    // external
    public void insert(final String string) {
        if ( string == null || string.isEmpty() ) return;

        TrieNode trie = this;
        for ( char c : string.toCharArray() ) {
            trie = addNode(trie, c);
        }

        trie.complete = true;
    }

    public boolean search(final String string) {
        if ( string == null || string.isEmpty() ) return false;

        TrieNode node = this;
        for ( char c : string.toCharArray() ) {
            node = getNode(node, c);
            if ( node == null ) return false;
        }

        return true;
    }

    public TrieNode startsWith(final String string) {
        if ( string == null || string.isEmpty() ) return null;

        TrieNode node = this;
        for ( char c :  string.toCharArray() ) {
            node = getNode(node, c);
            if ( node == null ) return null;
        }

        return node;
    }

    /*
       /
        \
         a
          \
           p
            \
             p - is a word
           /  \
          s    l
                \
                 e - is a word
     */

    private Stack<TrieNode> getTraversed(final String string) {
        Stack<TrieNode> traversed = new Stack<>();
        TrieNode node = this;
        traversed.push(node);

        if ( string != null && !string.isEmpty() ) {
            for ( char c : string.toCharArray() ) {
                node = getNode(node, c);
                traversed.push(node);
            }
        }

        return traversed;
    }

    private boolean isSafeToDelete(final TrieNode node) {
        if ( node == null || node.children == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( node.children[i] != null ) return false;
        }

        return true;
    }

    public void remove(final String string) {
        if ( string == null || string.isEmpty() ) return;

        Stack<TrieNode> history = getTraversed(string);
        TrieNode parent, child = history.pop();

        System.out.printf("remove: %s\n", string);
        while ( ! history.isEmpty() ) {
            parent = history.pop();
            if ( child == null || parent == null ) {
                return;

            } else if ( isSafeToDelete(child) ) {
                System.out.printf("delete: %c\n", child.c);

                parent.children[calculateIndex(child.c)] = null;
                child = parent;

            } else {
                return;
            }
        }
    }
}