package walker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private Canvas canvas;

    public MainWindow() {
        setSize(530, 555);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Walker");

        canvas = new Canvas();
        getContentPane().add(BorderLayout.CENTER, canvas);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.nextStep();
                canvas.repaint();
            }
        });
        timer.start();
    }
}
