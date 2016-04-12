package dp;

import ds.array.IntegerMatrix;
import org.junit.Assert;
import org.junit.Test;

public class KnapsackTest {

    private Knapsack knapsack = new Knapsack();

    @Test
    public void zeroOneTest() {
        int[][] matrix = knapsack.zeroOne(new int[]{5, 4, 6, 3}, new int[]{10, 40, 30, 50}, 10);
        System.out.println(new IntegerMatrix(matrix));
        Assert.assertEquals(90, matrix[matrix.length - 1][matrix[0].length - 1]);
    }

}
