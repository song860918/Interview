package dp;

import util.TODO;

@TODO
public class Knapsack {

    /**
     * rows: each block
     * cols: weight
     * f(0, y) = 0
     * f(x, 0) = 0
     * f(x, y) = Max(f(x - 1, y), f(x - 1, y - W(i)))
     */
    public int[][] zeroOne(int[] weightArr, int[] valueArr, int weightLimit) {
        int[][] matrix = new int[weightArr.length + 1][weightLimit + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if (j - weightArr[i - 1] >= 0) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - weightArr[i - 1]] + valueArr[i - 1]);
                }
            }
        }

        return matrix;
    }

}
