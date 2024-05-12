package Labs.Lab7.Tasks.Task8.Classes;

import Labs.Lab7.Tasks.Task6.Classes.JDice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameManagerPanel extends JPanel {
    private JLabel label1;
    private JLabel label2;
    private JLabel scoreLabel1;
    private JLabel scoreLabel2;
    private JLabel scoreValueLabel1;
    private JLabel scoreValueLabel2;

    private JPanel panel1;
    private JPanel panel2;

    private JDice dice1;
    private JDice dice2;

    private GridLayout layout;

    public GameManagerPanel() {
        label1 = new JLabel("Player1");
        label2 = new JLabel("Player2");
        scoreLabel1 = new JLabel("Score");
        scoreLabel2 = new JLabel("Score");
        scoreValueLabel1 = new JLabel("0");
        scoreValueLabel2 = new JLabel("0");
        panel1 = new JPanel();
        panel2 = new JPanel();
        dice1 = new JDice();
        dice2 = new JDice();

        dice1.pointsSpacing = 0.5f;
        dice2.pointsSpacing = 0.5f;

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel1.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel2.setHorizontalAlignment(JLabel.CENTER);
        scoreValueLabel1.setHorizontalAlignment(JLabel.CENTER);
        scoreValueLabel2.setHorizontalAlignment(JLabel.CENTER);

        dice1.setPreferredSize(new Dimension(60, 60));
        dice2.setPreferredSize(new Dimension(60, 60));

        layout = new GridLayout(4, 2);
        layout.setHgap(10);
        layout.setVgap(10);
        setLayout(layout);

        add(label1);
        add(label2);
        panel1.add(dice1);
        panel2.add(dice2);
        add(panel1);
        add(panel2);
        add(scoreLabel1);
        add(scoreLabel2);
        add(scoreValueLabel1);
        add(scoreValueLabel2);
    }
}
