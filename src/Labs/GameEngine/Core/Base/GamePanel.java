package Labs.GameEngine.Core.Base;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Game game;

    public GamePanel() {}
    public GamePanel(Game game) { this.game = game; }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(game.backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        game.tree.draw(g);
    }
}
