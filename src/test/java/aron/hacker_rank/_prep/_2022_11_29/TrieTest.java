package aron.hacker_rank._prep._2022_11_29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {
    private static final Trie trie = new Trie();
    static {
        trie.insert("alma");
        trie.insert("almafa");
        trie.insert("almale");
        trie.insert("auto");
        trie.insert("autom");
        trie.insert("autok");
    }

    @Test
    public void test(){
        assertFalse(trie.contains("x"));
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("almale"));

        assertEquals('e', trie.getLeaf("almale").getC());

    }
}
