import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Player extends JPanel {
    int x = 0, y = 0;
    int directionX = 0;
    int directionY = 0;
    int speed = 3;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 100);
    }

    public void update(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(code);
        if (code == 37) {
            directionX = -1;
        } else if (code == 39) {
            directionX = 1;
        } else if (code == 38) {
            directionY = -1;
        } else if (code == 40) {
            directionY = 1;
        }

    }

    public void Move() {
        x += directionX * speed;
        y += directionY * speed;
    }

    public void Stop() {
        directionX = 0;
        directionY = 0;
    }

}
