package ds.misc;

public class DrawCircle {

    public void draw(int radius) {
        if (radius <= 0) {
            throw new RuntimeException("Non positive radius");
        }

        int x = radius, y = 0;
        System.out.println("x=" + x + ", y=" + y);
        while (x != 0) {
            x--;
            int tmp = findY(x, y, radius);
            if (tmp > 0) {
                y = tmp;
                System.out.println("x=" + x + ", y=" + y);
            }
        }
    }

    private int findY(int x, int y, int radius) {

        while (true) {
            if (Math.abs(x * x + y * y - radius * radius) < radius / 10) {
                return y;
            } else if (x * x + y * y < radius * radius) {
                y++;
            } else {
                return -1;
            }
        }

    }

}
