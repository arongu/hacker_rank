package aron.hacker_rank._prep._2022_08_08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    public void basics() {
        final TrieNode trie = new TrieNode();

        long start = System.nanoTime();
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
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("duration: " + duration);

        assertTrue(trie.search("alma"));
        assertFalse(trie.search("teja"));
        assertTrue(trie.search("teljes"));
        assertEquals('l', trie.startsWith("bal").getC());
        assertEquals('z', trie.startsWith("tejbegriz").getC());
    }

    @Test
    public void testRemove() {
        final TrieNode trie = new TrieNode();

        long start = System.nanoTime();
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
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("duration: " + duration);

        assertTrue(trie.search("alma"));
        assertFalse(trie.search("teja"));
        assertTrue(trie.search("teljes"));
        assertEquals('l', trie.startsWith("bal").getC());
        assertEquals('z', trie.startsWith("tejbegriz").getC());

        trie.remove("tej");
        assertTrue(trie.search("tej"));
        trie.remove("tejes");
        assertFalse(trie.search("tejes"));
        assertTrue(trie.search("tej"));
        assertTrue(trie.search("tejfol"));
    }

    @Test
    public void testRemove2() {
        final TrieNode trie = new TrieNode();
        trie.insert("alma");

        assertTrue(trie.search("alma"));
        trie.remove("alma");
        assertFalse(trie.search("alma"));
    }

    @Test
    public void testRemove3() {
        final TrieNode trie = new TrieNode();
        trie.insert("alma");

        assertFalse(trie.search("almakok"));
        trie.remove("almakok");
        assertTrue(trie.search("alma"));
    }
}
