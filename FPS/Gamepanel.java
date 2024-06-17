import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gamepanel extends JPanel implements Runnable {
    Thread thread = new Thread();
    Enemy enemy = new Enemy();
    Enemy[] enemies = new Enemy[10];
    Player player = new Player();

    Gamepanel() {
        super();
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy();
        }

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("User has Pressed a key.");
                player.Move();
            }

            public void keyReleased(KeyEvent e) {
                player.Stop();
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        enemy.paintComponent(g);
        player.paintComponent(g);

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
