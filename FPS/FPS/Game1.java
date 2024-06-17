import java.awt.*;
import javax.swing.*;

class Game1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FPS control loop");
        frame.setResizable(false);
        // Draw a game panel Here.
        Gamepanel game = new Gamepanel();
        frame.add(game);
        game.startGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}