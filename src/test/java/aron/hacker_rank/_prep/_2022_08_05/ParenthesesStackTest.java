package aron.hacker_rank._prep._2022_08_05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesStackTest {

    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasNoOpenOrClosedTerms() {
        final String s = "this is my string";
        Assertions.assertTrue(ParenthesesStack.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParentheses() {
        final String s = "this is my (string";
        assertFalse(ParenthesesStack.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParenthesesAtTheEnd() {
        final String s = "this is my string(";
        assertFalse(ParenthesesStack.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasTwoOneOpeningParentheses() {
        final String s = "this is my (string)";
        assertTrue(ParenthesesStack.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringIsBalanced() {
        final String s = "text{[{[((text))]}]}text";
        assertTrue(ParenthesesStack.isBalanced(s));
    }
}
