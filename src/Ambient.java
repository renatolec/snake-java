import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.*;

public class Ambient extends JPanel {

    final static int WINDOW_DIMENSION = 640, UNIT_SIZE = 32;
    final static int GAME_UNIT = WINDOW_DIMENSION / UNIT_SIZE;

    Player player;
    Fruits fruits;
    Logic logic;
    Image[] images = new Image[4];

    Ambient() {
        setPreferredSize(new Dimension(WINDOW_DIMENSION, WINDOW_DIMENSION));
        loadImages();
        player = new Player(GAME_UNIT);
        fruits = new Fruits(GAME_UNIT);
        logic = new Logic(player, fruits);
    }

    public void loadImages() {
        try {
            images[0] = ImageIO.read(new File("../lib/carambola.png"));
            images[1] = ImageIO.read(new File("../lib/banana.png"));
            images[2] = ImageIO.read(new File("../lib/kiwi.png"));
            images[3] = ImageIO.read(new File("../lib/pera.png"));
        } catch (IOException ioe) {

        }
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < GAME_UNIT; i++) {
            for (int j = 0; j < GAME_UNIT; j++) {
                g.setColor(new Color(255, 255, 255));
                g.fillRect(i * UNIT_SIZE, j * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
            }
        }
        fruits.draw(g, UNIT_SIZE, this);
        player.draw(g, UNIT_SIZE);

        g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("Ink Tree", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + player.piecesBody,
                (WINDOW_DIMENSION / 2 - metrics.stringWidth("Score: " + player.piecesBody) / 2),
                g.getFont().getSize());
        if (!player.isAlive)
            g.drawString("Game Over!",
                    (WINDOW_DIMENSION / 2 - metrics.stringWidth("Game Over!") / 2),
                    WINDOW_DIMENSION / 2 - g.getFont().getSize() / 2);
    }
}
