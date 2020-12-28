package test;

import walker.Canvas;
import walker.Walker;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class Tests {

    @Test
    public void walkerInitializationTest() {
        Canvas canvas = new Canvas();
        Walker walker = canvas.getWalker();
        int i = walker.getI(); // i = 7
        Assert.assertEquals(i, 7);
    }

    @Test
    public void walkerNormalizationTest() {
        Walker walker = new Walker(10, 10, new Rectangle(0, 0, 10, 10));
        walker.normalize();
        int i = walker.getI(); // i = 0
        Assert.assertEquals(i, 0);
    }

    @Test
    public void walkerMoveTest() {
        Canvas canvas = new Canvas();
        canvas.nextStep();
        boolean[][] field = canvas.getField();

        int check = 0;
        int startI = 7;
        int startJ = 7;
        for (int i = - 1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (field[startI + i][startJ + j]) {
                    check++;
                }
            }
        }
        //check = 2
        Assert.assertEquals(check, 2);
    }
}
