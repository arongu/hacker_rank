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
        System.out.println("-----------------");
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
    public void test1(){
        System.out.println("------------test1");
        assertFalse(trie.contains("x"));
        assertTrue(trie.contains("a"));
        assertTrue(trie.contains("almale"));

        assertEquals('e', trie.getLeaf("almale").getC());

    }

    @Test
    public void test2(){
        System.out.println("------------test2");
        assertTrue(trie.contains("a"));
        trie.remove("almafa", true);
        assertFalse(trie.contains("a"));
    }

    @Test
    public void test3(){
        System.out.println("------------test3");
        assertTrue(trie.contains("baltazar"));
        assertTrue(trie.contains("balta"));
        assertTrue(trie.contains("bal"));
        trie.remove("baltazar", false);
        assertFalse(trie.contains("baltazar"));
        assertTrue(trie.contains("balta"));
        assertTrue(trie.contains("bal"));
    }
}
