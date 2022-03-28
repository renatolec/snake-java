import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    final int DIMENSION = 320, BLOCK = 16;
    final int SIZE = DIMENSION / BLOCK;

    Board() {
        setPreferredSize(new Dimension(DIMENSION, DIMENSION));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.drawRect(i*BLOCK , j*BLOCK, BLOCK, BLOCK);
            }
        }
    }
}
