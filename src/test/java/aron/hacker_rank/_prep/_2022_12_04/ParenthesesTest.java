package aron.hacker_rank._prep._2022_12_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesTest {
    @Test
    public void test(){
        assertTrue(Parentheses.isBalanced("aaaa(bbb{cc[ddd]qqqq}eeee)zzzz"));
        assertTrue(Parentheses.isBalanced("aaaa"));
        assertFalse(Parentheses.isBalanced("[]}"));
    }
}
