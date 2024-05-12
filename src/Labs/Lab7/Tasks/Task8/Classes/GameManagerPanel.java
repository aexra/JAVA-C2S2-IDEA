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

    private int score1 = 0;
    private int score2 = 0;

    private int pos1 = 0;
    private int pos2 = 0;

    private MonoGamePanel mgp;

    public GameManagerPanel(MonoGamePanel mgp) {
        this.mgp = mgp;

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

        disableDice2();

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

        dice1.onDraw = (value) -> {
            mgp.panels[pos1].upperLabel.setText("");
            pos1 += value;
            pos1 = pos1 % 8;
            mgp.panels[pos1].upperLabel.setText("Player1");

            switch (pos1) {
                case 0:
                    score1 += 20;
                    break;
                case 2:
                    score1 -= 50;
                    break;
                case 3:
                    score1 = 0;
                    break;
                case 4:
                    score1 += 30;
                    break;
                case 5:
                    score1 += 10;
                    break;
                case 6:
                    score1 -= 10;
                    break;
                case 7:
                    finish();
                    break;
            }

            scoreValueLabel1.setText(Integer.toString(score1));

            disableDice1();
            enableDice2();
        };
        dice2.onDraw = (value) -> {
            mgp.panels[pos2].downLabel.setText("");
            pos2 += value;
            pos2 = pos2 % 8;
            mgp.panels[pos2].downLabel.setText("Player2");

            switch (pos2) {
                case 0:
                    score2 += 20;
                    break;
                case 2:
                    score2 -= 50;
                    break;
                case 3:
                    score2 = 0;
                    break;
                case 4:
                    score2 += 30;
                    break;
                case 5:
                    score2 += 10;
                    break;
                case 6:
                    score2 -= 10;
                    break;
                case 7:
                    finish();
                    break;
            }

            scoreValueLabel2.setText(Integer.toString(score2));

            disableDice2();
            enableDice1();
        };
    }

    private void disableDice1() {
        dice1.backgroundColor = Color.RED;
        dice1.isActive = false;
        dice1.repaint();
    }
    private void disableDice2() {
        dice2.backgroundColor = Color.RED;
        dice2.isActive = false;
        dice2.repaint();
    }
    private void enableDice1() {
        dice1.backgroundColor = Color.WHITE;
        dice1.isActive = true;
        dice1.repaint();
    }
    private void enableDice2() {
        dice2.backgroundColor = Color.WHITE;
        dice2.isActive = true;
        dice2.repaint();
    }

    private void finish() {

    }
}
