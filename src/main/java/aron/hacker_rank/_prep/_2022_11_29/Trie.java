package aron.hacker_rank._prep._2022_11_29;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Trie {
    // class
    private static int getIndex(final char c) {
        return c - 'a';
    }

    private static Trie getNode(final Trie trie, final char c) {
        if ( trie == null || trie.nodes == null ) {
            return null;
        }

        return trie.nodes[getIndex(c)];
    }

    private static Stack<Trie> getNodesInOrder(final Trie trie, final String string) throws NoSuchElementException {
        if ( trie == null || string == null || string.isEmpty() ) throw new NoSuchElementException();

        final Stack<Trie> visited = new Stack<>();
        visited.push(trie);

        Trie node = trie;
        for ( final char c : string.toLowerCase().toCharArray() ) {
            node = getNode(node, c);
            if ( node == null ) throw new NoSuchElementException();
            else visited.push(node);
        }

        return visited;
    }

    // instance
    private Trie[] nodes;
    private final char c;

    // ctor
    private Trie(final char c) {
        this.c = c;
    }

    public Trie(){
        this('/');
    }

    public char getC() {
        return c;
    }

    public void deleteChildren() {
        this.nodes = null;
    }

    public boolean isNodesSafeToDelete() {
        if ( nodes == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( nodes[i] != null ) return false;
        }

        return true;
    }

    // getLeaf <- contains
    public Trie getLeaf(final String string) throws NoSuchElementException {
        if ( string == null || string.isEmpty() ) throw new NoSuchElementException();

        Trie node = this;
        for (final char c : string.toLowerCase().toCharArray()){
            node = getNode(node, c);
            if ( node == null ) {
                System.out.println("!! " + string);
                throw new NoSuchElementException();
            }
            else System.out.printf("@ %c ", c);
        }

        System.out.println();
        return node;
    }

    public boolean contains(final String string) {
        try {
            getLeaf(string);
            return true;

        } catch (NoSuchElementException e){
            return false;
        }
    }

    // insert -> contains
    private Trie addNode(final char c) {
        final int index = getIndex(c);
        Trie trie;

        System.out.printf("@ %c ", this.c);
        if ( nodes == null ) {
            nodes = new Trie[26];
            trie = new Trie(c);
            nodes[index] = trie;
            System.out.printf("++ %c\n", c);

        } else {
            trie = nodes[index];
            if ( trie == null ) {
                trie = new Trie(c);
                nodes[index] = trie;
                System.out.printf("++ %c\n", c);

            } else {
                System.out.printf(".. %c\n", c);
            }
        }

        return trie;
    }

    public void insert(final String string) {
        if (string == null || string.isEmpty()) return;

        Trie node = this;
        for (final char c : string.toLowerCase().toCharArray()) {
            node = node.addNode(c);
        }
    }

    // remove
    private void removeRecursively(final String string, final boolean safe) {
        try {
            final Stack<Trie> visited = getNodesInOrder(this, string);
            Trie child = visited.pop(), parent;

            while ( ! visited.isEmpty() ) {
                parent = visited.pop();
                int index = getIndex(child.c);

                if ( !safe ) {
                    child.deleteChildren();
                    parent.nodes[index] = null;
                    child = parent;
                    System.out.printf("--- %c ", 'a' + index);

                } else {
                    if ( child.isNodesSafeToDelete() ) {
                        child.deleteChildren();
                        parent.nodes[index] = null;
                        System.out.printf("-- %c ", 'a' + index);
                        child = parent;

                    } else {
                        System.out.println("!! " + child.c + " (" + string + ")");
                        break;
                    }
                }
            }

        } catch (NoSuchElementException ex) {
            System.out.println("No element removed!");
        }
    }

    public void removeRecursively(final String string) {
        removeRecursively(string, false);
    }

    public void remove(final String string) {
        removeRecursively(string, true);
    }
}
