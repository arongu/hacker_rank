package aron.hacker_rank.balanced_parentheses.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesStack2Test {
    public void isBalanced_shouldReturnTrue_whenStringHasNoOpenOrClosedTerms() {
        final String s = "this is my string";
        Assertions.assertTrue(ParenthesesStack2.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParentheses() {
        final String s = "this is my (string";
        assertFalse(ParenthesesStack2.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParenthesesAtTheEnd() {
        final String s = "this is my string(";
        assertFalse(ParenthesesStack2.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasTwoOneOpeningParentheses() {
        final String s = "this is my (string)";
        assertTrue(ParenthesesStack2.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringIsBalanced() {
        final String s = "text{[{[((text))]}]}text";
        assertTrue(ParenthesesStack2.isBalanced(s));
    }
}
