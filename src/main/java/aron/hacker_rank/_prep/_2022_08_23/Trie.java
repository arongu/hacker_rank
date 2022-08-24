package aron.hacker_rank._prep._2022_08_23;

import java.util.Stack;

public class Trie {
    // static
    private static int getIndex(final char c) {
        return c - 'a';
    }

    private static boolean isSafeToDelete(final Trie trie) {
        if ( trie.nodes == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( trie.nodes[i] != null ) return false;
        }

        return true;
    }

    // class private
    private Trie[] nodes;
    private final char letter;

    private Trie getNode(final char c) {
        return nodes != null ? nodes[getIndex(c)] : null;
    }

    private Trie getLeaf(final String string) {
        Trie curr = this;
        for ( char c : string.toCharArray() ) {
            curr = curr.getNode(c);
            if ( curr == null ) break;
        }

        return curr;
    }

    private Trie add(final char c) {
        int index = getIndex(c);

        System.out.printf("@%c\n", this.letter);
        if ( nodes == null ) {
            nodes = new Trie[26];
            System.out.printf("++ %c\n", c);
            return nodes[index] = new Trie(c);
        }

        if ( nodes[index] != null ) {
            System.out.printf("== %c\n", c);
            return nodes[index];

        } else {
            System.out.printf("++ %c\n", c);
            return nodes[index] = new Trie(c);
        }
    }

    // ctor
    private Trie(final char letter) {
        this.letter = letter;
    }

    // class public
    public Trie() {
        this('/');
    }

    public char getLetter() {
        return letter;
    }

    public void insert(final String string) {
        Trie node = this;
        for ( char c : string.toCharArray() ) {
            node = node.add(c);
        }

        System.out.println();
    }

    public boolean contains(final String string) {
        return getLeaf(string) != null;
    }

    public Trie lookup(final String string) {
        return getLeaf(string);
    }

    public void remove(final String string) {
        // empty nothing to do
        if ( string == null || string.isEmpty() ) return;

        // prepare to store the visited nodes
        // process the string and find each visited nodes


        Stack<Trie> visited = new Stack<>();
        visited.push(this);
        Trie curr = this;

        for ( char c : string.toCharArray() ) {
            curr = curr.getNode(c);
            if ( curr == null ) return;
            visited.push(curr);
        }

        // remove all the child nodes if possible
        Trie parent, child = visited.pop();
        while ( ! visited.isEmpty() && isSafeToDelete(child) ) {
            parent = visited.pop();
            System.out.printf("@%c\n", parent.letter);
            System.out.printf("--%c\n", child.letter);
            parent.nodes[getIndex(child.letter)] = null;
            child = parent;
        }
    }
}
