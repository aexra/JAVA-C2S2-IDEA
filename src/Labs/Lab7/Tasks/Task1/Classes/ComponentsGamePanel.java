package Labs.Lab7.Tasks.Task1.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Base.GamePanel;

import javax.swing.*;
import java.awt.*;

public class ComponentsGamePanel extends GamePanel {
    private JButton button;

    public ComponentsGamePanel() {
        super();

        button = new JButton("Hello, world!");

        add(button);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        button.repaint();
    }
}
