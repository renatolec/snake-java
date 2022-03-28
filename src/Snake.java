import javax.swing.JFrame;

public class Snake extends JFrame {

    Board board;

    Snake(){
        super("Snake - Arcade Game");
        board = new Board();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        add(board);
        pack();
    }

    public static void main(String[] args) throws Exception {
        new Snake();
    }
}