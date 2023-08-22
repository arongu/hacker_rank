package aron.hacker_rank._prep._2023_08_21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesTest {
    @Test
    public void test() {
        assertTrue(Parentheses.isBalanced("aaaa(bbb{cc[ddd]qqqq}eeee)zzzz"));
        assertTrue(Parentheses.isBalanced("aaaa"));
        assertFalse(Parentheses.isBalanced("[]}"));
    }

    @Test
    public void test2() {
        assertTrue(Parentheses2.isBalanced("aaaa(bbb{cc[ddd]qqqq}eeee)zzzz"));
        assertTrue(Parentheses2.isBalanced("aaaa"));
        assertFalse(Parentheses2.isBalanced("[]}"));
    }

    @Test
    public void test3() {
        assertTrue(Parentheses3.isBalanced("aaaa(bbb{cc[ddd]qqqq}eeee)zzzz"));
        assertTrue(Parentheses3.isBalanced("aaaa"));
        assertFalse(Parentheses3.isBalanced("[]}"));
    }
}
