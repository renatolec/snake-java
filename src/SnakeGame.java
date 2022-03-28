import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class SnakeGame extends JFrame {

    SnakeLogic game;
    int direction;

    SnakeGame() {
        super("Snake - Arcade Game");
        game = new SnakeLogic();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(game.board);
        pack();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (direction != 'S')
                        direction = 'W';
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (direction != 'A')
                        direction = 'D';
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (direction != 'W')
                        direction = 'S';
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (direction != 'D')
                        direction = 'A';
                }
            }
        });

        new Thread(new Runnable() {
            public void run() {
                while (game.board.snakeIsAlive) {
                    game.board.repaint();
                    game.genApple();
                    game.movementSnake(direction);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new SnakeGame();
    }
}