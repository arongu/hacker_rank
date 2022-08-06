package aron.hacker_rank._prep._2022_08_05;

public class Trie {

    private static int getCharacterIndex(final char c) {
        return c - 'a';
    }

    private char c;
    private Trie[] leafs;

    public char getC() {
        return c;
    }

    public Trie() {
        this.c = '/';
    }

    public Trie(final char c) {
        this.c = c;
    }

    private Trie add(final Trie trie, final char c) {
        final int index = getCharacterIndex(c);
        Trie lastPos;

        if ( trie.leafs == null ) {
            trie.leafs        = new Trie[26];
            lastPos           = new Trie(c);
            trie.leafs[index] = lastPos;
            System.out.printf("@%c ++ %c\n", trie.c, lastPos.c);

        } else  {
            lastPos = trie.leafs[index];

            if ( lastPos == null ) {
                lastPos = new Trie(c);
                trie.leafs[index] = lastPos;
                System.out.printf("@%c  + %c\n", trie.c, lastPos.c);

            } else {
                System.out.printf("@%c    %c\n", trie.c, lastPos.c);
            }
        }

        return lastPos;
    }

    public void insert(final String word) {
        System.out.println("insert " + word);
        if ( word == null || word.length() == 0 ) return;
        if ( leafs == null ) leafs = new Trie[26];

        Trie node = this;
        for ( char c : word.toCharArray() ) {
            node = add(node, c);
        }

        System.out.println();
    }

    public boolean search(final String string) {
        if ( string == null || leafs == null ) {
            return false;
        }

        char[] chars = string.toCharArray();
        Trie pos = this.leafs[getCharacterIndex(chars[0])];
        // set first position where it should be root node -> leaves @ char index

        for ( int i = 0, j = 1; i < chars.length; i++, j++ ) {
            // check if character matches
            if ( pos == null || pos.c != chars[i] ) {
                return false;
            }

            // for the next loop iteration
            // move the position of the iterator for the next position
            // if possible, if not set it to null
            if ( pos.leafs != null ) {
                pos = pos.leafs[getCharacterIndex(chars[j])];
            } else {
                pos = null;
            }
        }

        return true;
    }

    public Trie startsWith(final String string) {
        if ( string == null || leafs == null )
            return null;

        char[] chars = string.toCharArray();
        Trie pos     = leafs[getCharacterIndex(chars[0])];

        for ( int i = 0, j = 1; i < chars.length; i++, j++ ) {
            if ( pos == null || pos.c != chars[i] )
                return null;

            if ( j < chars.length && pos.leafs != null ) {
                char nextChar = chars[j];
                pos = pos.leafs[getCharacterIndex(nextChar)];
            }
        }

        return pos;
    }
}
