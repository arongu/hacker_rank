package aron.hacker_rank._prep._2022_11_29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesStackTest {
    @Test
    public void test1() {
        final String s0 = null;
        final String s1 = "";
        final String s2 = "xxx(alma{[asdsada]})";
        final String s3 = "xxx(alma{[asdsada]})]";

        assertTrue(ParenthesesStack.isBalanced(s0));
        assertTrue(ParenthesesStack.isBalanced(s1));
        assertTrue(ParenthesesStack.isBalanced(s2));
        assertFalse(ParenthesesStack.isBalanced(s3));
    }
}
