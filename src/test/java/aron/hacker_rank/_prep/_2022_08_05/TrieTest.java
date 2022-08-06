package aron.hacker_rank._prep._2022_08_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    public void go() {
        final Trie trie = new Trie();

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
        assertEquals('l', trie.startsWith("bal").getC());
        assertEquals('z', trie.startsWith("tejbegriz").getC());
    }
}
