package aron.hacker_rank._prep._2022_12_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieImplTest {
    @Test
    public void insertTest(){
        final TrieImpl trie = new TrieImpl();
        trie.insert("alma");
        trie.insert("almafa");
        trie.insert("almale");
        trie.insert("a");

        assertTrue(trie.contains("alma"));
        assertTrue(trie.contains("almafa"));
        assertTrue(trie.contains("almale"));
        assertTrue(trie.contains("a"));
        assertFalse(trie.contains("almak"));

        trie.remove("a");
        trie.remove("almakok");
        trie.remove("almak");
        trie.remove("almale");
        trie.remove("almafa");
        trie.remove("alma");
        trie.remove("");
    }
}

