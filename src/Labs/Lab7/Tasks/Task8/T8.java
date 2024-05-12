package Labs.Lab7.Tasks.Task8;

import Labs.GameEngine.Core.Vector2;
import Labs.Lab7.Tasks.Task5.Classes.StrangePanel;
import Labs.Lab7.Tasks.Task8.Classes.MonoGamePanel;

import javax.swing.*;

public class T8 {
    private JFrame frame;
    private Vector2 size = new Vector2(1600, 1000);

    public T8() {
        frame = new JFrame();

        var game = new MonoGamePanel();

        frame.add(game);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int)size.x, (int)size.y);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new T8();
    }
}
