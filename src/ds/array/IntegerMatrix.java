package ds.array;

import java.util.Arrays;

public class IntegerMatrix {

    private int[][] matrix;

    public IntegerMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]));
            sb.append("\n");
        }

        return sb.toString();
    }

}
