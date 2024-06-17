import java.awt.*;
import javax.swing.*;

public class Player extends JPanel {
    int x = 0, y = 0;
    int directionX = 0;
    int directionY = 0;
    int speed = 1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 100);
    }

    public void update() {
        directionX = 1;
        speed = 1;
    }

    public void Move() {
        x += directionX * speed;
        y += directionY * speed;
    }

    public void Stop() {
        speed = 0;
    }

}
