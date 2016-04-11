package dp;

/**
 * This is basically the same as buy and sell shares at most once. Think the maxSubarray as the diff between each days stock price
 */
public class MaxSubarray {

    public int max(int[] arr) {
        int maxSum = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

}
