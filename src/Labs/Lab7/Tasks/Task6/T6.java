package Labs.Lab7.Tasks.Task6;

import Labs.GameEngine.Core.Vector2;
import Labs.Lab7.Tasks.Task6.Classes.JDice;

import javax.swing.*;

public class T6 {
    private static Vector2 size = new Vector2(500, 500);

    public static void main(String[] args) {
        var frame = new JFrame();

        var dice = new JDice();
        dice.onDraw = System.out::println;
        dice.redraw();

        frame.add(dice);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int)size.x, (int)size.y);
        frame.setVisible(true);
    }
}
