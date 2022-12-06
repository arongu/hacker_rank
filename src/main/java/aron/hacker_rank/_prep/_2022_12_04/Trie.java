package aron.hacker_rank._prep._2022_12_04;

import java.util.Stack;

public class Trie {
    // static
    private static int calcIndex(final char c) {
        return c - 'a';
    }

    // instance
    // private
    private Trie[] children;
    private final char c;

    private Trie(final char c) {
        this.c = c;
    }

    private boolean isSafeToDelete() {
        if ( children == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( children[i] != null ) return false;
        }

        return true;
    }

    private Trie getChild(final char c) {
        return children == null ? null : children[calcIndex(c)];
    }

    private Stack<Trie> getNodes(final String string) {
        final Stack<Trie> visited = new Stack<>();
        visited.push(this);

        if ( string != null ) {
            Trie current = this;
            for ( char c : string.toLowerCase().toCharArray() ) {
                current = current.getChild(c);
                if ( current == null ) break;
                else visited.push(current);
            }
        }

        return visited;
    }

    private Trie add(final char c) {
        final int index = calcIndex(c);
        Trie node;

        if ( children == null ) {
            children = new Trie[26];
            node = new Trie(c);
            children[index] = node;
            System.out.println("++ " + c);

        } else {
            node = children[index];
            if ( node == null ) {
                node = new Trie(c);
                children[index] = node;
                System.out.println("++ " + c);
            } else {
                System.out.println(".." + c);
            }
        }

        return node;
    }

    // public
    public Trie() {
        this('/');
    }

    public void insert(final String string) {
        Trie current = this;
        for ( char c : string.toLowerCase().toCharArray() ) {
            current = current.add(c);
        }
    }

    public boolean contains(final String string) {
        Trie current = this;
        for ( char c : string.toLowerCase().toCharArray() ) {
            current = current.getChild(c);
            if ( current == null ) return false;
        }

        return true;
    }

    public void remove(final String string) {
        final Stack<Trie> visited = getNodes(string);

        Trie parent, child;
        child = visited.pop();

        while ( ! visited.isEmpty() ) {
            if ( child.isSafeToDelete() ) {
                parent = visited.pop();
                System.out.println("-- " + child.c);

                parent.children[calcIndex(child.c)] = null;
                child = parent;

            } else {
                System.out.println("Not safe to delete stopping! " + child.c);
                return;
            }
        }
    }
}
