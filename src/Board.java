import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    final int DIMENSION = 320, BLOCK = 16;
    final int SIZE = DIMENSION / BLOCK;
    final int NONE = 0, PLAYER = 1;

    int x0, y0;
    int[][] map = new int[SIZE][SIZE];

    Board() {
        setPreferredSize(new Dimension(DIMENSION, DIMENSION));
        x0 = y0 = 0;
        map[x0][y0] = PLAYER;
    }

    public void move(int movex, int movey){
        int x1 = x0 + movex;
        int y1 = y0 +movey;
        if(x1 >= 0 && y1 >= 0 && x1 < SIZE && y1 < SIZE){
            map[x1][y1] = PLAYER;
            map[x0][y0] = 0;
            x0 = x1;
            y0 = y1;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == PLAYER){
                    g.setColor(new Color(0, 255, 0));
                    g.fillRect(i*BLOCK , j*BLOCK, BLOCK, BLOCK);
                    g.setColor(new Color(0, 0, 0));
                }
                if(map[i][j] == NONE){
                    g.setColor(new Color(255, 255, 255));
                    g.fillRect(i*BLOCK , j*BLOCK, BLOCK, BLOCK);
                    g.setColor(new Color(0, 0, 0));
                }
                g.drawRect(i*BLOCK , j*BLOCK, BLOCK, BLOCK);
            }
        }
    }
}
