package aron.hacker_rank._prep._2022_12_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieTest {
    @Test
    public void test() {
        Trie trie = new Trie();

        assertFalse(trie.contains("alma"));
        trie.insert("alma");
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("al"));
        assertTrue(trie.contains("alm"));
        assertTrue(trie.contains("alma"));

        trie.insert("almas");
        trie.insert("almak");
        trie.remove("alma");

        trie.remove("almak");
        trie.remove("almas");
        trie.remove("alma");
    }
}
