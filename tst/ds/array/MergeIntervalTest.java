package ds.array;

import org.junit.Test;
import util.TestUtil;

import java.util.List;

public class MergeIntervalTest {

    private MergeInterval mergeInterval = new MergeInterval();

    @Test
    public void test() {
        List<Interval> list = TestUtil.intervalList(2,3,4,5,6,7,8,9,1,10);

        list = mergeInterval.merge(list);

        System.out.println(list);
    }

}
