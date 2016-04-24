package misc;

import ds.misc.DrawCircle;
import org.junit.Test;

public class DrawCircleTest {

    private DrawCircle dc = new DrawCircle();

    @Test
    public void test() {
        dc.draw(1000);
    }

}
