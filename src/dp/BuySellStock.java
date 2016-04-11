package dp;

public class BuySellStock {

    public int atMostTwice(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // calculate max subarray from the left and right including all intermediate values
        int[] left = atMostOnceHelper(prices);
        int[] right = atMostOnceReverseHelper(prices);

        int maxSum = 0;
        for (int i = 0; i < prices.length; i++) {
            maxSum = Math.max(maxSum, left[i] + right[i + 1]);
        }

        return maxSum;
    }

    private int[] atMostOnceHelper(int[] prices) {
        if (prices == null || prices.length < 1) {
            return null;
        }

        if (prices.length == 1) {
            return new int[]{0};
        }

        int[] maxSubarray = new int[prices.length];

        int maxSum = 0;
        int currSum = 0;
        for (int i = 1; i < maxSubarray.length; i++) {
            currSum += prices[i] - prices[i - 1];
            if (currSum < 0) {
                currSum = 0;
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            maxSubarray[i] = maxSum;
        }

        return maxSubarray;
    }

    private int[] atMostOnceReverseHelper(int[] prices) {
        if (prices == null || prices.length < 1) {
            return null;
        }
        if (prices.length == 1) {
            return new int[]{0};
        }

        int[] maxSubarray = new int[prices.length];

        int maxSum = 0;
        int currSum = 0;
        for (int i = maxSubarray.length - 2; i >= 0; i--) {
            currSum += prices[i] - prices[i + 1];
            if (currSum < 0) {
                currSum = 0;
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            maxSubarray[i] = maxSum;
        }

        return maxSubarray;
    }
}
