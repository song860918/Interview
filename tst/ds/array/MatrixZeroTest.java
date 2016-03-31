package ds.array;

import org.junit.Assert;
import org.junit.Test;

public class MatrixZeroTest {

    private MatrixZero matrixZero = new MatrixZero();

    @Test
    public void oneZeroTest() {
        Matrix<Integer> matrix = matrixWithZeros(5, 5);

        matrixZero.parseMatrix(matrix.getMatrix());

        System.out.println(matrix);

        verifyZeros(matrix.getMatrix(), 5, 5);
    }

    @Test
    public void noZeroTest() {
        Matrix<Integer> matrix = matrixWithNoZero();

        matrixZero.parseMatrix(matrix.getMatrix());

        verifyZeros(matrix.getMatrix());
    }

    @Test
    public void twoZeroTest() {
        Matrix<Integer> matrix = matrixWithZeros(1, 2, 3, 4);

        matrixZero.parseMatrix(matrix.getMatrix());
        System.out.println(matrix);
        verifyZeros(matrix.getMatrix(), 1, 2, 3, 4);
    }

    // First is row, second is column, and so on...
    private void verifyZeros(Integer[][] matrix, int... index) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < index.length - 1; i += 2) {
            rows[index[i]] = true;
            cols[index[i + 1]] = true;
        }

        for (int i = 0; i < matrix.length; i += 2) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || cols[j]) {
                    Assert.assertEquals(0, matrix[i][j].intValue());
                } else {
                    Assert.assertEquals(1, matrix[i][j].intValue());
                }
            }
        }
    }

    private Matrix<Integer> matrixWithNoZero() {

        Integer[][] matrix = new Integer[10][10];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;

            }
        }

        return new Matrix<>(matrix);
    }

    private Matrix<Integer> matrixWithZeros(int... index) {

        Integer[][] matrix = new Integer[10][10];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
                for (int k = 0; k < index.length - 1; k += 2) {
                    if (index[k] == i && index[k + 1] == j) {
                        matrix[i][j] = 0;
                        break; // This should go to the outer for loop
                    }
                }
            }
        }

        return new Matrix<>(matrix);
    }
}
