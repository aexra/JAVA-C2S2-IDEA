package Labs.GameEngine.BaseClasses;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game) { this.game = game; }

    @Override
    public void paint(Graphics g) {
        g.setColor(game.backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        game.tree.draw(g);
    }
}
