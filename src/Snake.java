import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Snake extends JFrame {

    Board board;
    int command;

    Snake(){
        super("Snake - Arcade Game");
        board = new Board();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(board);
        pack();

        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    board.move(0, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    board.move(1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    board.move(0, 1);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                   board.move(-1, 0);
                }
            }
        });

        new Thread(new Runnable(){
            public void run(){
                while(true){
                    
                    board.repaint();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new Snake();
    }
}