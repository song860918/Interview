package dp;

import ds.array.IntegerMatrix;

public class LongestCommonSubstring {

    public int lcs(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }

        int max = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(max, matrix[i][j]);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(new IntegerMatrix(matrix));

        return max;
    }

}
