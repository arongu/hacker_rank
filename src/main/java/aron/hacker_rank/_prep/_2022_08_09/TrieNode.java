package aron.hacker_rank._prep._2022_08_09;

import java.util.Stack;

public class TrieNode {
    // static
    private static int calcIndex(final char c) {
        return c - 'a';
    }

    // private members
    private TrieNode[] leafs;
    private boolean isWord;
    private char letter;

    // private methods
    private TrieNode getNode(final char c) {
        return leafs != null ? leafs[calcIndex(c)] : null;
    }

    private TrieNode insertNode(final char c) {
        TrieNode nodeOfChar = null;

        if ( leafs == null ) {
            leafs               = new TrieNode[26];
            nodeOfChar          = new TrieNode(c);
            leafs[calcIndex(c)] = nodeOfChar;

        } else {
            nodeOfChar = leafs[calcIndex(c)];
            if ( nodeOfChar == null ) {
                nodeOfChar          = new TrieNode(c);
                leafs[calcIndex(c)] = nodeOfChar;
            }
        }

        return nodeOfChar;
    }

    // constructors
    private TrieNode(final char letter) {
        this.letter = letter;
    }

    public TrieNode() {
        this('/');
    }

    // public methods
    public char getLetter() {
        return letter;
    }

    public void insert(final String s) {
        if ( s == null || s.isEmpty() ) return;

        TrieNode current = this;
        for ( char c : s.toCharArray() ) {
            current = current.insertNode(c);
        }

        current.isWord = true;
    }

    public boolean contains(final String s) {
        if ( s == null || s.isEmpty() ) return false;

        TrieNode it = this;
        for ( char c : s.toCharArray() ) {
            it = it.getNode(c);
            if ( it == null ) return false;
        }

        return true;
    }

    // remove node
    private static boolean isSafeToDelete(final TrieNode trieNode) {
        if ( trieNode == null || trieNode.leafs == null ) return true;

        for ( int i = 0; i < 26; i++ ) {
            if ( trieNode.leafs[i] != null ) return false;
        }

        return true;
    }

    private Stack<TrieNode> getVisitedNodes(final String s) {
        Stack<TrieNode> visited = new Stack<>();
        visited.push(this);

        if ( s == null || s.isEmpty() ) {
            return visited;
        }

        TrieNode current = this;
        for ( char c : s.toCharArray() ) {
            current = current.getNode(c);
            if ( current == null ) break;
            visited.push(current);
        }

        return visited;
    }

    public void remove(final String s) {
        if ( s == null || s.isEmpty() ) return;

        Stack<TrieNode> visited = getVisitedNodes(s);
        if ( visited.size() != s.length() + 1 ) return;

        TrieNode child = visited.pop(), parent = visited.pop();
        while ( ! visited.isEmpty() ) {

            if ( isSafeToDelete(child) ) {
                System.out.printf("delete %c\n", child.letter);
                parent.leafs[calcIndex(child.letter)] = null;
                child = parent;
                parent = visited.pop();

            } else {
                return;
            }
        }
    }

    public TrieNode lookup(final String s) {
        if ( s == null || s.isEmpty() ) return null;

        TrieNode current = this;
        for ( char c : s.toCharArray() ) {
            current = current.getNode(c);
            if ( current == null ) break;
        }

        return current;
    }
}
