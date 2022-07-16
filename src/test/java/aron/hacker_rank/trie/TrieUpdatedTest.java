package aron.hacker_rank.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieUpdatedTest {

    @Test
    public void go() {
        final TrieUpdated trie = new TrieUpdated();
//        trie.setDebug(true);

        trie.insert("alma");
        trie.insert("abba");
        trie.insert("abban");
        trie.insert("bal");
        trie.insert("balaton");
        trie.insert("balta");
        trie.insert("mar");
        trie.insert("marha");
        trie.insert("marok");

        assertTrue(trie.search("alma"));
        assertTrue(trie.startsWith("bal"));
        assertFalse(trie.startsWith("alx"));
    }
}
