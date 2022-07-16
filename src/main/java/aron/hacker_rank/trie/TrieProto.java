package aron.hacker_rank.trie;

public class TrieProto {
    private static class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(final char c) {
            this.c   = c;
            isWord   = false;
            children = new Node[26];
        }
    }

    private final Node root;

    public TrieProto() {
        root = new Node('\0');
    }

    public void insert(final String word) {
        Node it = root;

        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);
            int characterIndex = c - 'a';

            if ( it.children[characterIndex] == null ){
                it.children[characterIndex] = new Node(c);
            } else {
                it = it.children[characterIndex];
            }
        }

        it.isWord = true;
    }

    private Node getNode(final String word) {
        Node current = root;
        for ( int i = 0; i < word.length(); i++ ) {
            char c = word.charAt(i);

            if ( current.children[ c - 'a' ] == null ) {
                return null;

            } else {
                current = current.children[ c - 'a' ];
            }
        }

        return current;
    }

    public boolean search(final String word) {
        Node node =  getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(final String prefix) {
        return getNode(prefix) != null;
    }
}
