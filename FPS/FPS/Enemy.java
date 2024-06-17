import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;

public class Enemy extends JPanel {
    Random randomNum = new Random();
    int x = randomNum.nextInt(500);
    int y = 0;
    Image image;

    Enemy() {
        try {
            image = ImageIO.read(new File("./Asteroid.png"));
        } catch (Exception e) {
            // To Do EXception handling.
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, 100, 100, this);
    }

    public void update() {
        y = y + 1;
        if (y == 500) {
            y = 0;
            x = randomNum.nextInt(500);
        }
    }
}
