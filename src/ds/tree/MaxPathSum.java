package ds.tree;

/**
 * LeetCode
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * four condtions to consider:
 * For each node there can be four ways that the max path goes through the node:
 1. Node only
 2. Max path through Left Child + Node
 3. Max path through Right Child + Node
 4. Max path through Left Child + Node + Max path through Right Child

 The idea is to keep trace of four paths and pick up the max one in the end.
 An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved.
 This is needed for parent function call. In below code, this sum is stored in ‘max_single’ and returned by the recursive function.
 */
public class MaxPathSum {
    public int maxPathSum(IntTreeNode root) {
        // Initialize result
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(root, res);
        return res.val;
    }

    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    private int findMaxUtil(IntTreeNode node, Res res)
    {

        // Base Case
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.val,
                node.val);


        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.val);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }
    // An object of Res is passed around so that the
    // same value can be used by multiple recursive calls.
    class Res {
        public int val;
    }
}