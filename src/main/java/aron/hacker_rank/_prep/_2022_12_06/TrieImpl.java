package aron.hacker_rank._prep._2022_12_06;

import java.util.Stack;

public class TrieImpl implements Trie {
    private static int calculateIndex(final char c) {
        return c - 'a';
    }

    private final char c;
    TrieImpl[] children;

    private TrieImpl(final char c) {
        this.c = c;
    }

    public TrieImpl() {
        this('/');
    }

    private TrieImpl add(final char c) {
        final int index = calculateIndex(c);
        TrieImpl node;

        if ( children == null ) {
            children = new TrieImpl[26];
            node = new TrieImpl(c);
            children[index] = node;
            System.out.printf("+%c ", c);

        } else {
            node = children[index];
            if ( node == null ) {
                node = new TrieImpl(c);
                children[index] = node;
                System.out.printf("+%c ", c);

            } else {
                System.out.printf("> %c ", c);
            }
        }

        return node;
    }

    private TrieImpl getNode(final char c) {
        if ( this.c == c ) return this;

        int index = calculateIndex(c);
        return children != null ? children[index] : null;
    }

    private Stack<TrieImpl> getVisitedNodes(final String string) {
        final Stack<TrieImpl> visited = new Stack<>();
        visited.push(this); // for the root node '/'
        TrieImpl iterator = this;

        for ( char c : string.toLowerCase().toCharArray() ) {
            iterator = iterator.getNode(c);

            if ( iterator != null ) visited.push(iterator);
            else break;
        }

        return visited;
    }

    private boolean isSafeToDelete() {
        if ( children == null ) return true;
        for ( int i = 0; i < 26 ; i++) {
            if ( children[i] != null ) return false;
        }

        return true;
    }

    @Override
    public void insert(final String string) {
        if ( string == null || string.isEmpty() ) return;

        TrieImpl iterator = this;
        for ( char c : string.toLowerCase().toCharArray() ) {
            iterator = iterator.add(c);
        }

        System.out.println();
    }

    @Override
    public boolean contains(final String string) {
        if ( string == null || string.isEmpty() ) return false;

        TrieImpl iterator = this;
        for ( char c : string.toLowerCase().toCharArray() ) {
            iterator = iterator.getNode(c);
            if ( iterator == null || iterator.c != c ) return false;
        }

        return true;
    }

    @Override
    public void remove(final String string) {
        System.out.printf("- '%s' ", string);
        final Stack<TrieImpl> visited = getVisitedNodes(string);

        TrieImpl child = visited.pop(), parent;
        while ( ! visited.isEmpty() ) {
            parent = visited.pop();

            if ( child.isSafeToDelete() ) {
                int index = calculateIndex(child.c);
                System.out.printf("-%c ", child.c);
                parent.children[index] = null;

                child = parent;


            } else {
                System.out.printf("!-%c", child.c);
                break;
            }
        }

        System.out.println();
    }
}
