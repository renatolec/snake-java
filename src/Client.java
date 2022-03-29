import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Client extends JFrame{

    Ambient game;
    public int command;

    Client(){
        this.setTitle("Snake");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        game = new Ambient();
        this.add(game);
        this.pack();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (command != 'S')
                        command = 'W';
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (command != 'A')
                        command = 'D';
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (command != 'W')
                        command = 'S';
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (command != 'D')
                        command = 'A';
                }
            }
        });

        new Thread(new Runnable() {
            public void run() {
                while (game.player.isAlive) {
                    game.repaint();
                    game.logic.update(command);
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        new Client();
    }
}