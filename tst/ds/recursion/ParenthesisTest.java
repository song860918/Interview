package ds.recursion;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesisTest {

    private Parenthesis parenthesis = new Parenthesis();

    @Test
    public void isBalancedTest() {
        Assert.assertTrue(parenthesis.isBalanced(""));
        Assert.assertTrue(parenthesis.isBalanced("()"));
        Assert.assertTrue(parenthesis.isBalanced("(a + b)"));
        Assert.assertTrue(parenthesis.isBalanced("(a + (b * c))"));

        Assert.assertFalse(parenthesis.isBalanced("("));
        Assert.assertFalse(parenthesis.isBalanced(")"));
        Assert.assertFalse(parenthesis.isBalanced("())"));
        Assert.assertFalse(parenthesis.isBalanced("(a + (b * c)))"));
    }

    @Test
    public void findAllBalancedParenthesis() {
        parenthesis.findAllBalancedParenthesis(0);
        parenthesis.findAllBalancedParenthesis(1);
        parenthesis.findAllBalancedParenthesis(2);
        parenthesis.findAllBalancedParenthesis(3);
        parenthesis.findAllBalancedParenthesis(4);
        parenthesis.findAllBalancedParenthesis(5);
    }

}
