package Labs.Lab6.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RunningString extends JPanel {
    private String[] strings = { "abcdefghijklmnopqrstuvwxyz", "zxczxczxczxczxczxczxczxczxczxc", "задолдзадолдзадолдзадолдзадолдзадолдзадолдзадолдзадолд" };
    private String iterableString;
    private int selectedString = 0;
    private JFrame frame;
    private Timer t;

    public RunningString() {
        frame = new JFrame();
        iterableString = strings[selectedString];

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cycleString();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(this);
        frame.setVisible(true);

        t = new Timer(100, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               move();
               repaint();
           }
        });
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        var g2 = (Graphics2D) g;
        g2.setFont(new Font("MONTSERRAT", Font.PLAIN, 40));
        g2.drawString(iterableString, 0, 50);
    }

    private void move() {
        var fchar = iterableString.charAt(0);
        iterableString = iterableString.substring(1);
        iterableString += fchar;
    }

    private void cycleString() {
        if (selectedString == strings.length - 1) {
            selectedString = 0;
        }
        else {
            selectedString++;
        }
        iterableString = strings[selectedString];
    }
}
