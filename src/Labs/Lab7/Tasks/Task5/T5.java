package Labs.Lab7.Tasks.Task5;

import Labs.GameEngine.Core.Vector2;
import Labs.Lab7.Tasks.Task5.Classes.MyComponent;

import javax.swing.*;
import java.awt.*;

public class T5 {
    private JFrame frame;
    private Vector2 size = new Vector2(1600, 1000);

    public T5() {
        frame = new JFrame();

        var comp = new MyComponent();

        frame.add(comp);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int)size.x, (int)size.y);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new T5();
    }
}
