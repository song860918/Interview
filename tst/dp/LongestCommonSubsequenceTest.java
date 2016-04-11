package dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    private LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @Test
    public void basicTest() {
        Assert.assertEquals(6, lcs.lcs("CGATAATTGAGA", "GTTCCTAATA"));
    }

}
