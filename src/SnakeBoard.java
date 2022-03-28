import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SnakeBoard extends JPanel {

    final int DIMENSION = 320, BLOCK = 16;
    final int SIZE = DIMENSION / BLOCK;
    final int NONE = 0, SNAKE = 1, APPLE = 2;

    int x[] = new int[SIZE * SIZE];
    int y[] = new int[SIZE * SIZE];
    int xApple, yApple;
    int bodyParts = 1;

    boolean appleOnBoard = false, snakeIsAlive = true;

    SnakeBoard() {
        setPreferredSize(new Dimension(DIMENSION, DIMENSION));
        x[0] = y[0] = 0;
    }

    public void movementSnake(int direction) {

        for (int i = bodyParts; i > 0; i--) {
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
        checkColision(x[0], y[0]);
        if (x[0] == xApple && y[0] == yApple)
            eatApple();
    }

    public void checkColision(int x1, int y1) {
        if (x1 >= SIZE || x1 < 0 || y1 >= SIZE || y1 < 0)
            snakeIsAlive = false;
        for(int i = 1 ; i < bodyParts ; i++){
            if(x1 == x[i] && y1 == y[i]){
                snakeIsAlive = false;
                break;
            }
        }
    }

    public void genApple() {
        if (appleOnBoard)
            return;
        Random gen = new Random();
        xApple = gen.nextInt(SIZE);
        yApple = gen.nextInt(SIZE);
        appleOnBoard = true;
    }

    public void eatApple() {
        appleOnBoard = false;
        bodyParts++;
    }

    @Override
    public void paintComponent(Graphics g) {
        // PLANO DE FUNDO
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.setColor(new Color(255, 255, 255));
                g.fillRect(i * BLOCK, j * BLOCK, BLOCK, BLOCK);
            }
        }

        // OBJETOS
        g.setColor(new Color(255, 0, 0));
        g.fillOval(xApple * BLOCK, yApple * BLOCK, BLOCK, BLOCK);

        g.setColor(new Color(0, 150, 0));
        for (int i = 0; i < bodyParts; i++) {
            if (i == 1)
                g.setColor(new Color(0, 255, 0));
            g.fillRect(x[i] * BLOCK, y[i] * BLOCK, BLOCK, BLOCK);
        }

        // MALHA QUADRICULADA
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.setColor(new Color(0, 0, 0));
                g.drawRect(i * BLOCK, j * BLOCK, BLOCK, BLOCK);
            }
        }
    }
}
