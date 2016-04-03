package ds.recursion;

import java.util.Stack;

/**
 * Cracking The Coding Interview 9.6
 */
public class Parenthesis {

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public void findAllBalancedParenthesis(int pairs) {
        findAllBalancedParenthesisHelper("", pairs, pairs);
    }

    private void findAllBalancedParenthesisHelper(String result, int left, int right) {

        if (right == 0) {
            System.out.println(result);
        }

        if (left > 0) {
            findAllBalancedParenthesisHelper(result + '(', left - 1, right);
        }

        if (right > left) {
            findAllBalancedParenthesisHelper(result + ')', left, right - 1);
        }

    }

}
