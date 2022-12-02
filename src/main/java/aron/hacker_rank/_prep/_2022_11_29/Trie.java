package aron.hacker_rank._prep._2022_11_29;

import java.util.NoSuchElementException;

public class Trie {
    private Trie[] nodes;

    private static int getIndex(final char c) {
        return c - 'a';
    }

    private static Trie getNode(final Trie trie, final char c) {
        if ( trie == null || trie.nodes == null ) {
            return null;
        }

        return trie.nodes[getIndex(c)];
    }

    public Trie getLeaf(final String string) throws NoSuchElementException {
        if ( string == null || string.isEmpty() ) throw new NoSuchElementException();

        Trie node = this;
        for (final char c : string.toLowerCase().toCharArray()){
            node = getNode(node, c);
            if ( node == null ) throw new NoSuchElementException();
            else System.out.printf("@ %c\n", c);
        }

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

    private Trie addNode(final char c) {
        final int index = getIndex(c);
        Trie trie;


        System.out.printf("@ %c\n", index + 'a');
        if ( nodes == null ) {
            nodes = new Trie[26];
            trie = new Trie();
            nodes[index] = trie;
            System.out.printf("++ %c\n", index + 'a');

        } else {
            trie = nodes[index];
            if ( trie == null ) {
                trie = new Trie();
                nodes[index] = trie;
                System.out.printf("++ %c\n", index + 'a');
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
}
