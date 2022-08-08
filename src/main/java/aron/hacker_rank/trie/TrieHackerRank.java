package aron.hacker_rank.trie;

public class TrieHackerRank {
    public static class Node {
        private static final int NUMBER_OF_CHARACTERS = 26;

        private static int getCharIndex(final char c) {
            return c - 'a';
        }


        Node[] children = new Node[NUMBER_OF_CHARACTERS];

        private Node getNode(final char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(final char c, final Node node) {
            children[getCharIndex(c)] = node;
        }

        private void add(final String string, final int index) {
            if ( index == string.length() ) return;

            char c = string.charAt(index);
            Node childNode = getNode(c);

            if ( childNode == null ) {
                childNode = new Node();
                setNode(c, childNode);
            }

            childNode.add(string, index + 1);
        }

        public void add(final String string) {
            add(string, 0);
        }
    }
}
