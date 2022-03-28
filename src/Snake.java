import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Snake extends JFrame {

    Board board;
    int movex = 0, movey = 0;

    Snake() {
        super("Snake - Arcade Game");
        board = new Board();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(board);
        pack();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    movex = 0;
                    movey = -1;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    movex = 1;
                    movey = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    movex = 0;
                    movey = 1;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    movex = -1;
                    movey = 0;
                }
            }
        });

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    board.repaint();
                    board.move(movex, movey);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new Snake();
    }
}