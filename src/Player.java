import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class Player {

    JFrame window;
    public int[] x, y;
    public int piecesBody = 1;
    boolean isAlive = true;

    Player(int GAME_UNIT) {
        x = new int[GAME_UNIT * GAME_UNIT];
        y = new int[GAME_UNIT * GAME_UNIT];
        x[0] = y[0] = 0;
    }

    public void movementPlayer(int direction) {

        for (int i = piecesBody; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'W':
                y[0] = y[0] - 1;
                break;
            case 'A':
                x[0] = x[0] - 1;
                break;
            case 'S':
                y[0] = y[0] + 1;
                break;
            case 'D':
                x[0] = x[0] + 1;
                break;
        }
        collisionPlayer();
    }

    public void collisionPlayer() {
        if (x[0] < 0 || x[0] >= Ambient.GAME_UNIT || y[0] < 0 || y[0] >= Ambient.GAME_UNIT)
            isAlive = false;
        for (int i = 1; i < piecesBody; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                isAlive = false;
                break;
            }
        }
    }

    public void draw(Graphics g, int UNIT_SIZE) {

        for (int i = 0; i < piecesBody; i++) {
            g.setColor(new Color(0, 255, 0));
            if (i == 0)
                g.setColor(new Color(0, 150, 0));
            g.fillRect(x[i] * UNIT_SIZE, y[i] * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(x[i] * UNIT_SIZE, y[i] * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
        }
    }

}
