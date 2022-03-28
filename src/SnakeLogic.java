import java.util.Random;

public class SnakeLogic {
    
    SnakeBoard board;
    
    SnakeLogic(){
        board = new SnakeBoard();
    }

    public void movementSnake(int direction) {

        for (int i = board.bodyParts; i > 0; i--) {
            board.x[i] = board.x[i - 1];
            board.y[i] = board.y[i - 1];
        }

        switch (direction) {
            case 'W':
                board.y[0] = board.y[0] - 1;
                break;
            case 'A':
                board.x[0] = board.x[0] - 1;
                break;
            case 'S':
                board.y[0] = board.y[0] + 1;
                break;
            case 'D':
                board.x[0] = board.x[0] + 1;
                break;
        }
        checkColision(board.x[0], board.y[0]);
        if (board.x[0] == board.xApple && board.y[0] == board.yApple)
            eatApple();
    }

    public void checkColision(int x1, int y1) {
        if (x1 >= board.SIZE || x1 < 0 || y1 >= board.SIZE || y1 < 0)
            board.snakeIsAlive = false;
        for (int i = 1; i < board.bodyParts; i++) {
            if (x1 == board.x[i] && y1 == board.y[i]) {
                board.snakeIsAlive = false;
                break;
            }
        }
    }

    public void genApple() {
        if (board.appleOnBoard)
            return;
        Random gen = new Random();
        board.xApple = gen.nextInt(board.SIZE);
        board.yApple = gen.nextInt(board.SIZE); 
        board.randomFruit = gen.nextInt(4);
        board.appleOnBoard = true;
    }

    public void eatApple() {
        board.appleOnBoard = false;
        board.bodyParts++;
    }

}
