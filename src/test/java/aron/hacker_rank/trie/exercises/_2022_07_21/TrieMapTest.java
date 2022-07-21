package aron.hacker_rank.trie.exercises._2022_07_21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieMapTest {

    @Test
    public void go() {
        final TrieMap trie = new TrieMap(true);
        //trie.setDebug(false);

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
        assertTrue(trie.startsWith("bal"));
        assertFalse(trie.startsWith("alx"));
    }
}
