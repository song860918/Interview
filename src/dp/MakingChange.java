package dp;

public class MakingChange {

    public int[] minCoins(int sum, Coin[] coins) {
        if (sum < 0) {
            throw new RuntimeException("Negative number!");
        }

        int[] arr = new int[sum + 1];
        arr[0] = 0;

        for (int i = 1; i < sum + 1; i++) {
            arr[i] = Integer.MAX_VALUE;
            for (Coin coin : coins) {
                if (i - coin.getDenomination() >= 0 && arr[i - coin.getDenomination()] != Integer.MAX_VALUE) {
                    arr[i] = Math.min(arr[i], arr[i - coin.getDenomination()] + 1);
                }
            }
        }

        backtracking(arr, coins);

        return arr;
    }

    /**
     * backtracking
     * @param arr
     * @param coins
     */
    private void backtracking(int[] arr, Coin[] coins) {
        if (arr.length == 0) {
            return;
        }
        int i = arr.length - 1;

        while (i > 0) {
            int min = Integer.MAX_VALUE;
            Coin minCoin = null;
            for (Coin coin : coins) {
                if (i - coin.getDenomination() >= 0 && min > arr[i - coin.getDenomination()]) {
                    min = arr[i - coin.getDenomination()];
                    minCoin = coin;
                }
            }
            System.out.println(minCoin + ":" + minCoin.getDenomination());
            i = i - minCoin.getDenomination();
        }
    }

    /**
     * number of ways (with coin x) + number of ways(without coin x)
     * arr[i - 1][j] + arr[i - 1][j - x.getDenomination()]
     * @param sum
     * @param coins
     * @return
     */
    public int[][] numOfWays(int sum, Coin[] coins) {
        if (sum < 0) {
            throw new RuntimeException("Negative sum!");
        }

        int[][] matrix = new int[coins.length + 1][sum + 1];
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i - 1][j];

                if (j - coins[i - 1].getDenomination() >= 0) {
                    matrix[i][j] += matrix[i][j - coins[i - 1].getDenomination()];
                }
            }
        }

        return matrix;

    }

}
