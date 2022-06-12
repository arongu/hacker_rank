package aron.hacker_rank.gyak;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedGyak5Test {
    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasNoOpenOrClosedTerms() {
        final String s = "this is my string";
        assertTrue(BalancedGyak5.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParentheses() {
        final String s = "this is my (string";
        assertFalse(BalancedGyak5.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParenthesesAtTheEnd() {
        final String s = "this is my string(";
        assertFalse(BalancedGyak5.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasTwoOneOpeningParentheses() {
        final String s = "this is my (string)";
        assertTrue(BalancedGyak5.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringIsBalanced() {
        final String s = "text{[{[((text))]}]}text";
        assertTrue(BalancedGyak5.isBalanced(s));
    }
}
