package ds.array;

/**
 * Cracking The Coding Interview 1.7
 */
public class MatrixZero {

    public void parseMatrix(Integer[][] matrix) {
        if (matrix == null) {
            return;
        }

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Set matrix corresponding rows and columns to 0
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
