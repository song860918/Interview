package ds.array;

import org.junit.Test;

public class MatrixZeroTest {

    private MatrixZero matrixZero = new MatrixZero();

    @Test
    public void oneZeroTest() {
        Matrix<Integer> matrix = matrixWithOneZero();

        matrixZero.parseMatrix(matrix.getMatrix());

        System.out.println(matrix);
    }

    private Matrix<Integer> matrixWithOneZero() {

        Integer[][] matrix = new Integer[10][10];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != 5 || j != 5) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return new Matrix<>(matrix);
    }
}
