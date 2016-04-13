package ds.sorting;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import util.TestUtil;

import java.util.Arrays;
import java.util.List;

@Ignore
public class SortTest {

    protected Sort<Integer> sort;

    @Test
    public void fixedSortTest() {
        List<Integer> list = Arrays.asList(25, 47, 13, 17, 30, 222, 5, 19);
        sort.sort(list);
        verifySorted(list);
    }

    @Test
    public void randomeSortTest() {
        List<Integer> list = TestUtil.randomIntegerList();
        sort.sort(list);

        verifySorted(list);
    }

    private void verifySorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) {
                Assert.fail();
            }
        }
    }

}
