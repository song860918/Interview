package dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {

    private  LongestCommonSubstring lcs = new LongestCommonSubstring();

    @Test
    public void basicTest() {
        Assert.assertEquals(3, lcs.lcs("ABAB", "BABA"));
    }

}
