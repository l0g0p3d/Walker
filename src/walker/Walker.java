package walker;

import java.awt.*;

public class Walker {

    private int i;
    private int j;
    private Rectangle bounds;

    public Walker(int i, int j, Rectangle bounds) {
        this.i = i;
        this.j = j;
        this.bounds = bounds;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void move() {
        double r = Math.random();

        if (r < 0.25) {
            i++;
        } else if (r < 0.5) {
            i--;
        } else if (r < 0.75) {
            j++;
        } else {
            j--;
        }

    }

    public void normalize() {
        i %= bounds.getHeight();
        j %= bounds.getWidth();

        if (i < 0) {
            i = (int) (bounds.getHeight() - 1);
        }
        if (j < 0) {
            j = (int) (bounds.getWidth() - 1);
        }
    }


}
