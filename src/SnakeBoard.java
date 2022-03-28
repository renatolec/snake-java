import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class SnakeBoard extends JPanel {

    final int DIMENSION = 320, BLOCK = 16;
    final int SIZE = DIMENSION / BLOCK;
    final int NONE = 0, SNAKE = 1, APPLE = 2;

    int x[] = new int[SIZE * SIZE];
    int y[] = new int[SIZE * SIZE];
    int xApple, yApple, randomFruit;
    int bodyParts = 1;

    boolean appleOnBoard = false, snakeIsAlive = true;

    Image[] image = new Image[4];

    SnakeBoard() {
        setPreferredSize(new Dimension(DIMENSION, DIMENSION));
        loadImages();
        x[0] = y[0] = 0;
    }

    public void loadImages(){
        try {
            image[0] = ImageIO.read(new File("../lib/carambola.png"));
            image[1] = ImageIO.read(new File("../lib/banana.png"));
            image[2] = ImageIO.read(new File("../lib/kiwi.png"));
            image[3] = ImageIO.read(new File("../lib/pera.png"));
        } catch (IOException ioe) {
            
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.setColor(new Color(255, 255, 255));
                g.fillRect(i * BLOCK, j * BLOCK, BLOCK, BLOCK);
            }
        }
        g.drawImage(image[randomFruit], xApple*BLOCK, yApple*BLOCK, BLOCK, BLOCK, this);

        for (int i = 0; i < bodyParts; i++) {
            g.setColor(new Color(0, 255, 0));
            if (i == 0)
                g.setColor(new Color(0, 150, 0));
            g.fillRect(x[i] * BLOCK, y[i] * BLOCK, BLOCK, BLOCK);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(x[i] * BLOCK, y[i] * BLOCK, BLOCK, BLOCK);
        }

        g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("Ink Tree", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + bodyParts, (DIMENSION / 2 - metrics.stringWidth("Score: " + bodyParts) / 2),
                g.getFont().getSize());
        if (!snakeIsAlive)
            g.drawString("Game Over!", (DIMENSION / 2 - metrics.stringWidth("Game Over!") / 2),
                    DIMENSION / 2 - g.getFont().getSize() / 2);
    }
}
