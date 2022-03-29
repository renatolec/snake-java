import java.util.Random;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Fruits {

    public int x, y;
    public int randomFruit;
    boolean fruitUp;
    Image[] image = new Image[4];

    Fruits(int GAME_UNIT) {
        fruitImages();
        generateFruit(GAME_UNIT);
    }

    public void fruitImages(){
        try {
            image[0] = ImageIO.read(new File("../lib/carambola.png"));
            image[1] = ImageIO.read(new File("../lib/banana.png"));
            image[2] = ImageIO.read(new File("../lib/kiwi.png"));
            image[3] = ImageIO.read(new File("../lib/pera.png"));
        } catch (IOException ioe) {
            
        }
    }

    public void generateFruit(int GAME_UNIT) {
        if (fruitUp)
            return;
        Random gen = new Random();
        x = gen.nextInt(GAME_UNIT);
        y = gen.nextInt(GAME_UNIT);
        randomFruit = gen.nextInt(4);
        fruitUp = true;
    }

    public void draw(Graphics g, int UNIT_SIZE, JPanel window) {
        g.drawImage(image[randomFruit], x*UNIT_SIZE, y*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, window);
    }
}
