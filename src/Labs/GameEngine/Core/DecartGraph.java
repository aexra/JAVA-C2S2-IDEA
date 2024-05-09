package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Base.GameObject2D;

import java.awt.*;
import java.util.ArrayList;

public class DecartGraph extends GameObject2D {

    // LIST OF FUNCTIONS
    public ArrayList<DecartGraphMember> functions;

    // DRAWING VARIABLES
    public float zoom = 1f;
    public Vector2 xInterval = new Vector2(-5, 5);
    public float simStep = 0.1f;


    // FLAGS
    public boolean drawAxis = true;
    public boolean describeAxis = true;
    public boolean manualInterval = false;

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
    public void update(long deltaTime) {
        super.update(deltaTime);

        // Пусть при zoom = 1 наш xInterval принимает значения от -5 до 5
        // Тогда..

        if (!manualInterval) {
            xInterval.x = -5 / zoom;
            xInterval.y = 5 / zoom;
            simStep = 0.001f / zoom;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);

        g2.setColor(backgroundColor);
        g2.fillRect((int)transform.position.x, (int)transform.position.y, (int)transform.scale.x, (int)transform.scale.y);

        var scaleX = (transform.scale.x) / Math.PI;
        var scaleY = (double)(transform.scale.y);

        var aspect = scaleX / scaleY;

        scaleX *= zoom;

        scaleY = scaleX / aspect;

        drawAxes(g2, scaleX, scaleY);
        drawFunctions(g2, scaleX, scaleY);
    }

    private void drawAxes(Graphics2D g2, double scaleX, double scaleY) {

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
//            var incrementor = zoom < 1? (int)(1 / zoom) : 1;
            var incrementor = 1;
//            var startX = zoom < 1? (int)xInterval.x : xInterval.x;
            var startX = (int)xInterval.x;
            var xIterator = startX;
            while (xIterator < xInterval.y) {
                xIterator += incrementor;
                g2.drawString(Float.toString(xIterator), (int)(xIterator * scaleX + pivot.x), (int)pivot.y);
                g2.drawString(Float.toString(xIterator), (int)pivot.x, (int)(xIterator * scaleY + pivot.y));
            }
        }
    }

    private void drawFunctions(Graphics2D g2, double scaleX, double scaleY) {
        for (var member : functions) {
            if (!member.visible) continue;
            g2.setColor(member.strokeColor);
            var values = member.getY(xInterval.x, xInterval.y, simStep);
            for (var point : values) {
                g2.drawRect((int)(point.x * scaleX + pivot.x), (int)(- point.y * scaleY + pivot.y), 1, 1);
            }
        }
    }
}
