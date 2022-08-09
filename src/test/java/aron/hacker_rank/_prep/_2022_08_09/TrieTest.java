package aron.hacker_rank._prep._2022_08_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    public void basics() {
        final TrieNode trie = new TrieNode();
        trie.insert("alma");
        trie.insert("abba");
        trie.insert("abban");
        trie.insert("bal");
        trie.insert("balaton");
        trie.insert("balta");
        trie.insert("mar");
        trie.insert("marha");
        trie.insert("marok");
        trie.insert("martaloc");
        trie.insert("malac");
        trie.insert("malacka");
        trie.insert("kerek");
        trie.insert("kerepel");
        trie.insert("kerekpar");
        trie.insert("kerekparos");
        trie.insert("tej");
        trie.insert("tejfol");
        trie.insert("tejfolos");
        trie.insert("tejes");
        trie.insert("tejbegriz");
        trie.insert("telefon");
        trie.insert("teljes");

        assertTrue(trie.contains("alma"));
        assertFalse(trie.contains("teja"));
        assertTrue(trie.contains("teljes"));
        assertEquals('l', trie.lookup("bal").getLetter());
        assertEquals('z', trie.lookup("tejbegriz").getLetter());
    }

    @Test
    public void testRemove() {
        final TrieNode trie = new TrieNode();
        trie.insert("alma");
        trie.insert("abba");
        trie.insert("abban");
        trie.insert("bal");
        trie.insert("balaton");
        trie.insert("balta");
        trie.insert("mar");
        trie.insert("marha");
        trie.insert("marok");
        trie.insert("martaloc");
        trie.insert("malac");
        trie.insert("malacka");
        trie.insert("kerek");
        trie.insert("kerepel");
        trie.insert("kerekpar");
        trie.insert("kerekparos");
        trie.insert("tej");
        trie.insert("tejfol");
        trie.insert("tejfolos");
        trie.insert("tejes");
        trie.insert("tejbegriz");
        trie.insert("telefon");
        trie.insert("teljes");


        assertTrue(trie.contains("alma"));
        assertFalse(trie.contains("teja"));
        assertTrue(trie.contains("teljes"));
        assertEquals('l', trie.lookup("bal").getLetter());
        assertEquals('z', trie.lookup("tejbegriz").getLetter());

        trie.remove("tej");
        assertTrue(trie.contains("tej"));
        trie.remove("tejes");
        assertFalse(trie.contains("tejes"));
        assertTrue(trie.contains("tej"));
        assertTrue(trie.contains("tejfol"));
    }

    @Test
    public void testRemove2() {
        final TrieNode trie = new TrieNode();
        trie.insert("alma");

        assertTrue(trie.contains("alma"));
        trie.remove("alma");
        assertFalse(trie.contains("alma"));
    }
}
