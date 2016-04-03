package ds.linkedlist;

/**
 * Cracking The Coding Interview 2.7
 */
public class Palindrome<T> {

    public boolean isPalindrome(LinkedListNode<T> root) {
        if (root == null) {
            return true;
        }

        return isPalindromeHelper(root, root.next).isPalindrome;
    }

    private Result isPalindromeHelper(LinkedListNode<T> slow, LinkedListNode<T> fast) {

        if (fast == null) {
            // odd number nodes; slow is the center node
            return new Result(true, slow.next);
        } else if (fast.next == null) {
            // even number nodes; slow + slow.next are the center nodes
            if (!slow.data.equals(slow.next.data)) {
                return new Result(false, null);
            } else {
                return new Result(true, slow.next.next);
            }
        }

        Result subResult = isPalindromeHelper(slow.next, fast.next.next);
        return new Result(subResult.isPalindrome && slow.data.equals(subResult.rest.data), subResult.rest.next);
    }

    private class Result {
        public boolean isPalindrome;
        public LinkedListNode<T> rest;

        private Result(boolean isPalindrome, LinkedListNode<T> rest) {
            this.isPalindrome = isPalindrome;
            this.rest = rest;
        }
    }

}
