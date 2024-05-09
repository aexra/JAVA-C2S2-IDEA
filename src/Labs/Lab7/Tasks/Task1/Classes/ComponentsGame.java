package Labs.Lab7.Tasks.Task1.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Base.GamePanel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComponentsGame extends Game {
    private JComboBox<UIManager.LookAndFeelInfo> comboBox;
    private JLabel label;
    private JButton button;
    private JCheckBox checkbox;
    private JRadioButton radio;
    private JTable table;

    public ComponentsGame() {
        super();

        comboBox = new JComboBox<>();
        label = new JLabel("This is label");
        button = new JButton("Hello, world!");
        checkbox = new JCheckBox();
        radio = new JRadioButton();
        table = new JTable(
                new String[][] {
                        { "Си", "Деннис Ритчи", "1972" },
                        { "C++", "Бьерн Страуструп", "1983" },
                        { "Python", "Гвидо ван Россум", "1991" },
                        { "Java", "Джеймс Гослинг", "1995" },
                        { "JavaScript", "Брендон Айк", "1995" },
                        { "C#", "Андерс Хейлсберг", "2001" },
                        { "Scala", "Мартин Одерски", "2003" }
                },
                new String[] { "Язык", "Автор", "Год" }
        );

        var lafs = UIManager.getInstalledLookAndFeels();
        for (var laf : lafs) {
            comboBox.addItem(laf);
        }
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        UIManager.setLookAndFeel(((UIManager.LookAndFeelInfo)e.getItem()).getClassName());
                    } catch (Exception _) {

                    }
                }
            }
        });

        panel.add(comboBox);
        panel.add(label);
        panel.add(button);
        panel.add(checkbox);
        panel.add(radio);
        panel.add(table);

        panel.revalidate();
    }
}
