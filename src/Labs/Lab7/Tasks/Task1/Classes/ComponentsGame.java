package Labs.Lab7.Tasks.Task1.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Base.GamePanel;

import javax.swing.*;
import java.awt.*;

public class ComponentsGame extends Game {
    private JComboBox<Integer> comboBox;
    private JLabel label;
    private JButton button;
    private JCheckBox checkbox;
    private JRadioButton radio;
    private JTable table;

    public ComponentsGame() {
        super();

        comboBox = new JComboBox<>();
        label = new JLabel();
        button = new JButton("Hello, world!");
        checkbox = new JCheckBox();
        radio = new JRadioButton();
        table = new JTable();

        panel.add(comboBox);
        panel.add(label);
        panel.add(button);
        panel.add(checkbox);
        panel.add(radio);
        panel.add(table);

        panel.revalidate();
    }
}
