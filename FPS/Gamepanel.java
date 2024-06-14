import javax.swing.*;
import java.awt.*;

public class Gamepanel extends JPanel implements Runnable {
    Thread thread = new Thread();
    Enemy enemy = new Enemy();

    Gamepanel() {
        super();
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        enemy.paintComponent(g);

    }

    public void startGame() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        enemy.update();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / 60;
        double deltaTime = 0;
        long lastPassedTime = System.nanoTime();
        long currentTime = 0;

        while (thread != null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassedTime) / drawInterval;
            lastPassedTime = currentTime;
            if (deltaTime >= 1) {
                repaint();
                update();
                deltaTime--;
            }
        }
    }
}
