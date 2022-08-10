package aron.hacker_rank._prep._2022_08_10;

import java.util.Stack;

public class Trie {
    // static methods
    private static boolean isStringBad(final String s) {
        return s == null || s.isEmpty();
    }

    private static int getIndex(final char c) {
        return c - 'a';
    }

    private static boolean isSafeToDelete(final Trie trie) {
        if ( trie == null || trie.leafs == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( trie.leafs[i] != null ) return false;
        }

        return true;
    }

    // class properties
    private Trie[] leafs;
    private final char value;

    // constructors
    private Trie(final char value) {
        this.value = value;
    }

    public Trie() {
        this('/');
    }

    // private utility
    // read
    private Trie getNode(final char c) {
        return leafs != null ? leafs[getIndex(c)] : null;
    }

    private Trie getNode(final String s) {
        if (isStringBad(s)) return null;

        Trie pos = this;
        for ( char c : s.toCharArray() ) {
            pos = pos.getNode(c);
            if ( pos == null ) break;
        }

        return pos;
    }

    private Stack<Trie> getVisitedNodes(final String s) {
        final Stack<Trie> visited = new Stack<>();
        visited.push(this);

        if ( isStringBad(s) ) return visited;

        Trie curr = this;
        for ( char c : s.toCharArray() ) {
            curr = curr.getNode(c);
            if ( curr == null ) break;
            visited.push(curr);
        }

        return visited;
    }

    // write
    private Trie addLeaf(final char c) {
        int index = getIndex(c);
        Trie leaf;

        if ( leafs == null ) {
            leafs = new Trie[26];
            leaf = new Trie(c);
            leafs[index] = leaf;

        } else {
            leaf = leafs[index];
            if ( leaf == null ) {
                leaf = new Trie(c);
                leafs[index] = leaf;
            }
        }

        return leaf;
    }

    // public methods
    // read
    public char getLetter() {
        return value;
    }

    public boolean contains(final String s) {
        return getNode(s) != null;
    }

    public Trie lookup(final String s) {
        return getNode(s);
    }

    // write
    public void insert(final String s) {
        if (isStringBad(s)) return;

        Trie pos = this;
        for ( char c : s.toCharArray() ) {
            pos = pos.addLeaf(c);
        }
    }

    public void remove(final String s) {
        System.out.println("delete " + s);
        if ( isStringBad(s) ) return;
        final Stack<Trie> visited = getVisitedNodes(s);

        if ( visited.size() - 1 != s.length() ) return;

        Trie parent, child = visited.pop();
        while ( ! visited.isEmpty() ) {
            parent = visited.pop();

            if ( isSafeToDelete(child) ) {
                System.out.printf("delete %c\n", child.value);
                parent.leafs[getIndex(child.value)] = null;
                child = parent;

            } else {
                return;
            }
        }
    }
}
