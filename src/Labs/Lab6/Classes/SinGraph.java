package Labs.Lab6.Classes;

import javax.swing.*;
import java.awt.*;

public class SinGraph extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final double PI = Math.PI;
    public JFrame frame;

    public SinGraph() {
        frame = new JFrame("Sin Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SinGraph.WIDTH, SinGraph.HEIGHT);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        g.setColor(Color.BLACK);
//        ((Graphics2D)g).setStroke(new BasicStroke(3));
        g.drawLine(0, centerY, WIDTH, centerY); // X-axis
        g.drawLine(centerX, 0, centerX, HEIGHT); // Y-axis

        g.setColor(Color.RED);
        double scaleX = WIDTH / (2 * PI);
        double scaleY = HEIGHT / 2.0;

        for (int i = 0; i < WIDTH; i++) {
            double x = (i - centerX) / scaleX;
            double y = Math.sin(x);
            int j = (int) (centerY - y * scaleY);
            g.drawLine(i, j, i, j);
        }
    }
}
