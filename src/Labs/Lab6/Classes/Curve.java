package Labs.Lab6.Classes;

import javax.swing.*;
import java.awt.*;

public class Curve {
    // SOME PROPERTIES
    private final JPanel panel;
    private Double left;
    private Double right;
    private Double up;
    private Double bottom;

    // DATA
    private double[] xValues;
    private double[] yValues;

    // CONSTRUCTOR
    public Curve() {
        JFrame frame = new JFrame("App 2");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                int w = getWidth();
                int h = getHeight();
                var g2 = ((Graphics2D)g);
                g2.setStroke(new BasicStroke(3));
                g.setColor(Color.BLUE);
                for (int i = 0; i < xValues.length - 1; i++) {
                    int currentX = (int) convert(xValues[i], left, right, 0, w);
                    int currentY = h - (int) convert(yValues[i], bottom, up, 0, h);
                    int nextX = (int) convert(xValues[i + 1], left, right, 0, w);
                    int nextY = h - (int) convert(yValues[i + 1], bottom, up, 0, h);
                    g.drawLine(currentX, currentY, nextX, nextY);
                }
                g.setColor(Color.BLACK);
                if (left * right <= 0) {
                    int x = (int)(Math.abs(left)/(Math.abs(left)+Math.abs(right))*w);
                    g.drawLine(x, 0, x, h);
                    g2.drawString(bottom.toString(), x + 10, h - 10);
                    g2.drawString(up.toString(), x + 10, 10);
                }
                if (bottom * up <= 0) {
                    int y = (int)(Math.abs(up)/(Math.abs(bottom)+Math.abs(up))*h);
                    g.drawLine(0, y, w, y);
                    g2.drawString(left.toString(), 10, y-10);
                    g2.drawString(right.toString(), w - 30, y-10);
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    // CONFIGURATION METHODS
    public void setLimits(double left, double right, double bottom, double up) {
        if (left >= right) {
            throw new IllegalArgumentException("Чо с размерами?");
        }
        if (bottom >= up) {
            throw new IllegalArgumentException("Чо с размерами?");
        }
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.up = up;
        panel.repaint();
    }
    public void setData(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new IllegalAccessError("Количество точек по X не равно количеству точек по Y");
        }
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i] >= xValues[i + 1]) {
                throw new IllegalAccessError("Ну не может у тебя следующий Х быть меньше прошлого");
            }
        }
        this.xValues = xValues.clone();
        this.yValues = yValues.clone();
        panel.repaint();
    }
    static double convert(double value1, double low1, double high1, double low2, double high2) {
        double relative_value = (value1 - low1) / (high1 - low1);
        return low2 + (high2 - low2) * relative_value;
    }
}