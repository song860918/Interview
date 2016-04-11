package dp;

import ds.array.IntegerMatrix;
import org.junit.Test;

import java.util.Arrays;

public class MakingChangeTest {

    private MakingChange makingChange = new MakingChange();

    @Test
    public void minCoinsTest() {
        //System.out.println(Arrays.toString(makingChange.minCoins(25, AmericanCoin.values())));
        System.out.println(Arrays.toString(makingChange.minCoins(21, RandomCoin.values())));
    }

    @Test
    public void numOfWaysTest() {
        System.out.println(new IntegerMatrix(makingChange.numOfWays(10, AmericanCoin.values())));
        System.out.println(new IntegerMatrix(makingChange.numOfWays(21, RandomCoin.values())));
    }

}
