package dp;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubarrayTest {

    private MaxSubarray maxSubarray = new MaxSubarray();

    @Test
    public void basicTest() {
        Assert.assertEquals(5, maxSubarray.max(new int[]{2, -8, 3, -2, 4, -10}));
    }

}
