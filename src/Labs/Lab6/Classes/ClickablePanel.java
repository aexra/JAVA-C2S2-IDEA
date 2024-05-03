package Labs.Lab6.Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickablePanel extends JPanel {
    private int lastClickX;
    private int lastClickY;
    private Color strokeColor = Color.BLACK;

    public ClickablePanel() {
        super();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Clicked: " + e.getX() + "," + e.getY());
                lastClickX = e.getX();
                lastClickY = e.getY();
                repaint();
            }
        });

        var frame = new JFrame("Sin Graph");
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("KeyTyped: " + e.getKeyChar());

                switch (e.getKeyChar())
                {
                    case 'b':
                        strokeColor = Color.BLACK;
                        break;
                    case 'w':
                        strokeColor = Color.WHITE;
                        break;
                    case 'r':
                        strokeColor = Color.RED;
                        break;
                    case 'g':
                        strokeColor = Color.GREEN;
                        break;
                    case 'o':
                        strokeColor = Color.ORANGE;
                        break;
                    default:
                        break;
                }

                repaint();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        var g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(strokeColor);
        g2.drawString("(" + lastClickX + ", " + lastClickY + ")", lastClickX, lastClickY);
    }
}
