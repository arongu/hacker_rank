package aron.hacker_rank;

import aron.hacker_rank.balanced_parentheses.BalancedParenthesesStack1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedParenthesesStack1Test {
    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasNoOpenOrClosedTerms() {
        final String s = "this is my string";
        assertTrue(BalancedParenthesesStack1.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParentheses() {
        final String s = "this is my (string";
        assertFalse(BalancedParenthesesStack1.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnFalse_whenStringHasOnlyOneOpeningParenthesesAtTheEnd() {
        final String s = "this is my string(";
        assertFalse(BalancedParenthesesStack1.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringHasTwoOneOpeningParentheses() {
        final String s = "this is my (string)";
        assertTrue(BalancedParenthesesStack1.isBalanced(s));
    }

    @Test
    public void isBalanced_shouldReturnTrue_whenStringIsBalanced() {
        final String s = "text{[{[((text))]}]}text";
        assertTrue(BalancedParenthesesStack1.isBalanced(s));
    }
}
