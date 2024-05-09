package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Base.GameObject2D;

import java.awt.*;
import java.util.ArrayList;

public class DecartGraph extends GameObject2D {

    public ArrayList<DecartGraphMember> functions;
    public Vector2 xInterval = new Vector2(-10, 10);
    public float simStep = 0.1f;
    public Vector2 margin = new Vector2(20, 20);
    public float zoom = 2f;

    // FLAGS
    public boolean drawAxis = true;
    public boolean describeAxis = true;

    // COLORS
    public Color backgroundColor = Color.WHITE;
    public Color axisStrokeColor = Color.BLACK;
    public Color axisNumberColor = Color.BLACK;

    public DecartGraph(String objectName) {
        super(objectName);
        functions = new ArrayList<>();
    }

    public void add(DecartGraphMember func) {
        functions.add(func);
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setColor(backgroundColor);
        g2.fillRect((int)transform.position.x, (int)transform.position.y, (int)transform.scale.x, (int)transform.scale.y);

        var scaleX = (transform.scale.x - margin.x) / Math.PI * zoom;
        var scaleY = (double)(transform.scale.y - margin.y) * zoom;

        var aspect = scaleX / scaleY;

        scaleX /= xInterval.y - xInterval.x;

        scaleY = scaleX / aspect;

        drawAxes(g2, scaleX, scaleY);
        drawFunctions(g2, scaleX, scaleY);
    }

    public void drawAxes(Graphics2D g2, double scaleX, double scaleY) {

        // DRAW AXIS LINES
        if (drawAxis) {
            g2.setColor(axisStrokeColor);

            // draw Ox axis
            g2.drawRect(0, (int)pivot.y, (int)transform.scale.x, 1);

            // draw Oy axis
            g2.drawRect((int)pivot.x, 0, 1, (int)transform.scale.y);
        }

        // DRAW AXIS NUMBERS
        if (describeAxis) {
            g2.setColor(axisNumberColor);

            // draws numbers at Ox axis
            for (var x = (int)xInterval.x; x <= (int)xInterval.y; x++) {
                g2.drawString(Integer.toString(x), (int)(x * scaleX + pivot.x), (int)pivot.y);
            }

            // draws numbers at Oy axis
            var allY = new ArrayList<Float>();
            for (var func : functions) {
                for (var point : func.getY(xInterval.x, xInterval.y, simStep)) {
                    allY.add(point.y);
                }
            }
            var minY = allY.getFirst(); // the first value of Y interval
            var maxY = allY.getFirst(); // the last value of Y interval
            for (var y : allY) {
                if (y < minY) {
                    minY = y;
                    continue;
                }
                if (y > maxY) {
                    maxY = y;
                    continue;
                }
            }
            for (var y = minY.intValue(); y <= maxY.intValue(); y++) {
                g2.drawString(Integer.toString(y), (int)pivot.x, (int)(y * scaleY + pivot.y));
            }
        }
    }

    public void drawFunctions(Graphics2D g2, double scaleX, double scaleY) {
        for (var member : functions) {
            g2.setColor(member.strokeColor);
            var values = member.getY(xInterval.x, xInterval.y, simStep);
            for (var point : values) {
                g2.drawRect((int)(point.x * scaleX + pivot.x), (int)(point.y * scaleY + pivot.y), 1, 1);
            }
        }
    }
}
