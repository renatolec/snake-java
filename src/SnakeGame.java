import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class SnakeGame extends JFrame {

    SnakeBoard board;
    int direction;

    SnakeGame() {
        super("Snake - Arcade Game");
        board = new SnakeBoard();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(board);
        pack();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    direction = 'W';
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    direction = 'D';
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    direction = 'S';
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = 'A';
                }
            }
        });

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    board.repaint();
                    board.genApple();
                    board.movementSnake(direction);
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