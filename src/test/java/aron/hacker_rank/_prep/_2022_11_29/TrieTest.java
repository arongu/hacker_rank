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
        trie.insert("bal");
        trie.insert("balta");
        trie.insert("baltas");
        trie.insert("baltazar");
        trie.insert("baromfi");
        trie.insert("barna");
        trie.insert("barnul");
    }

    @Test
    public void a(){

    }

    @Test
    public void contains(){
        assertFalse(trie.contains("x"));
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("almale"));
    }

    @Test
    public void test2(){
        System.out.println("------------test2");
        assertTrue(trie.contains("a"));
        trie.remove("almafa");
        assertTrue(trie.contains("alma"));
        assertTrue(trie.contains("almale"));
    }

    @Test
    public void test3(){
        System.out.println("------------test3");
        assertTrue(trie.contains("baltazar"));
        assertTrue(trie.contains("balta"));
        assertTrue(trie.contains("bal"));
        trie.remove("baltazar");
        assertFalse(trie.contains("baltazar"));
        assertTrue(trie.contains("balta"));
        assertTrue(trie.contains("bal"));
    }
}
