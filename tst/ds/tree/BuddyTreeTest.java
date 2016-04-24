package ds.tree;

import org.junit.Test;

public class BuddyTreeTest {

    private BuddyTree bt = new BuddyTree(3, 1);

    @Test
    public void test1() {
        bt.clearBit(1);
        bt.setBit(1);

    }

    @Test
    public void test8() {
        bt.clearBit(8);
        bt.setBit(8);

    }

    @Test
    public void test5() {
        bt.clearBit(5);
        bt.setBit(5);

    }

    @Test
    public void multiTest() {
        bt.clearBit(5);
        //bt.clearBit(6);
        //bt.clearBit(2);
        //bt.setBit(6);
        bt.setBit(5);
        //bt.setBit(2);
    }
}
