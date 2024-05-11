package Labs.Lab7.Tasks.Task6.Classes;

import Labs.GameEngine.Core.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class JDice extends JPanel {
    public int value;
    public Color backgroundColor = Color.WHITE;
    public Color foregroundColor = Color.BLACK;
    public Color borderColor = Color.DARK_GRAY;
    public int borderThickness = 2;
    public float pointsSpacing = 0.1f;
    public boolean isActive = true;

    public IntVoid onDraw;

    private GridLayout layout;
    private Random rnd;

    public JDice() {
        rnd = new Random();

        onDraw = this::onDraw;

        redraw();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isActive)
                    redraw();
            }
        });
    }

    public int redraw() {
        value = rnd.nextInt(6) + 1;

        onDraw.f(value);

        repaint();

        return value;
    }

    private void onDraw(int value) {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;

        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        g2.setColor(backgroundColor);
        g2.fillRoundRect(0 + borderThickness, 0 + borderThickness, getWidth() - borderThickness * 2, getHeight() - borderThickness * 2, 20, 20);

        g2.setColor(foregroundColor);
        Vector2 grid;
        Vector2[] toDraw;
        switch (value) {
            case 1:
                grid = new Vector2(1,1);
                toDraw = new Vector2[]{
                        new Vector2(0,0),
                };
                break;
            case 2:
                grid = new Vector2(2,2);
                toDraw = new Vector2[]{
                        new Vector2(1,0),
                        new Vector2(0,1),
                };
                break;
            case 3:
                grid = new Vector2(3,3);
                toDraw = new Vector2[]{
                        new Vector2(2,0),
                        new Vector2(1,1),
                        new Vector2(0,2),
                };
                break;
            case 4:
                grid = new Vector2(2,2);
                toDraw = new Vector2[]{
                        new Vector2(0,0),
                        new Vector2(0,1),
                        new Vector2(1,0),
                        new Vector2(1,1),
                };
                break;
            case 5:
                grid = new Vector2(3,3);
                toDraw = new Vector2[]{
                        new Vector2(0,0),
                        new Vector2(1,1),
                        new Vector2(2,2),
                        new Vector2(2,0),
                        new Vector2(0,2),
                };
                break;
            case 6:
                grid = new Vector2(3,2);
                toDraw = new Vector2[]{
                        new Vector2(0,0),
                        new Vector2(0,1),
                        new Vector2(0,2),
                        new Vector2(1,0),
                        new Vector2(1,1),
                        new Vector2(1,2),
                };
                break;
            default:
                grid = new Vector2();
                toDraw = new Vector2[]{};
                break;
        }

        var rowHeight = (int)(getHeight() / grid.x);
        var columnWidth = (int)(getWidth() / grid.y);

        var r = Math.min(rowHeight, columnWidth);
        r -= (int) (r * pointsSpacing);

        var xpadding = (int)(columnWidth - r) / 2;
        var ypadding = (int)(rowHeight - r) / 2;

        for (var y = 0; y < grid.x; y++) {
            for (var x = 0; x < grid.y; x++) {
                var found = false;
                for (var pos : toDraw) {
                    if (pos.x == x && pos.y == y) {
                        found = true;
                        break;
                    }
                }

                if (!found) { continue; }

                var xpos = x * columnWidth;
                var ypos = y * rowHeight;

                g2.fillOval(xpos + xpadding, ypos + ypadding, r, r);
            }
        }
    }
}
