package ds.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import util.TestUtil;

public class PalindromeTest {

    private Palindrome<Integer> palindrome = new Palindrome<>();

    @Test
    public void palindromeTest() {
        Assert.assertTrue(palindrome.isPalindrome(TestUtil.integerLinkedList(1)));
        Assert.assertTrue(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 1)));
        Assert.assertTrue(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 1)));
        Assert.assertTrue(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 2, 1)));
        Assert.assertTrue(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 3, 2, 1)));

        Assert.assertFalse(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2)));
        Assert.assertFalse(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 3)));
        Assert.assertFalse(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 2, 3)));
        Assert.assertFalse(palindrome.isPalindrome(TestUtil.integerLinkedList(1, 2, 3, 2, 3)));
    }

}
