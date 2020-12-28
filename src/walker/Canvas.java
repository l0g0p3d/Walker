package walker;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    private Walker walker;
    private boolean[][] field;
    private int cellSizeX;
    private int cellSizeY;

    private final static int OFFSET_X = 10;
    private final static int OFFSET_Y = 10;

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    private final static int FIELD_WIDTH = 15;
    private final static int FIELD_HEIGHT = 15;

    public Canvas() {
        setSize(WIDTH + OFFSET_X * 2, HEIGHT + OFFSET_Y * 2);
        setBackground(Color.GRAY);

        cellSizeX = WIDTH / FIELD_WIDTH;
        cellSizeY = HEIGHT / FIELD_HEIGHT;

        Rectangle bounds = new Rectangle(0, 0, FIELD_WIDTH, FIELD_HEIGHT);
        walker = new Walker(FIELD_HEIGHT / 2, FIELD_WIDTH / 2, bounds);
        field = new boolean[FIELD_HEIGHT][FIELD_WIDTH];
        field[FIELD_HEIGHT / 2][FIELD_WIDTH / 2] = true;
    }


    private void drawStep(int i, int j, Color color, Graphics g) {
        g.setColor(color);

        int y = i * cellSizeY + OFFSET_X;
        int x = j * cellSizeX + OFFSET_Y;
        g.fillRect(x + 5, y + 5, cellSizeX - 5, cellSizeY - 5);
    }

    private void drawWalker(Color color, Graphics g) {
        g.setColor(color);

        int y = walker.getI() * cellSizeY + OFFSET_X + 2;
        int x = walker.getJ() * cellSizeX + OFFSET_Y + 2;
        g.fillRect(x, y, cellSizeX, cellSizeY);
    }

    public void nextStep() {
        walker.move();
        walker.normalize();
        field[walker.getI()][walker.getJ()] = true;
    }

    public boolean[][] getField() {
        return field;
    }

    public Walker getWalker() {
        return walker;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        g.setColor(Color.BLACK);
        g.drawRect(OFFSET_X, OFFSET_Y, WIDTH + OFFSET_X, HEIGHT + OFFSET_Y);

        for (int i = 0; i < FIELD_HEIGHT; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (field[i][j]) {
                    drawStep(i, j, Color.WHITE, g);
                }
            }
        }

        drawWalker(Color.BLUE, g);

    }
}
