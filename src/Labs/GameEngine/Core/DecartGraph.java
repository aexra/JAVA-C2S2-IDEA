package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Base.GameObject2D;
import Labs.GameEngine.Core.Interfaces.IDecartGraphMember;
import Labs.GameEngine.Core.Interfaces.IFunction2D;

import java.awt.*;
import java.util.ArrayList;

public class DecartGraph extends GameObject2D {

    public ArrayList<DecartGraphMember> functions;
    public Vector2 xInterval = new Vector2(-10, 10);
    public float simStep = 0.1f;
    public Vector2 margin = new Vector2(10, 10);

    public Color background = Color.WHITE;

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

        var scaleX = (game.panel.getWidth() - margin.x) / (2 * Math.PI);
        var scaleY = (game.panel.getHeight() - margin.y) / 2.0;

        drawAxes(g2, scaleX, scaleY);
        drawFunctions(g2, scaleX, scaleY);
    }

    public void drawAxes(Graphics2D g2, double scaleX, double scaleY) {
//        var iterator = xInterval.x;
//        while (iterator < xInterval.y) {
//            iterator += simStep;
//
//            if (Math.abs(iterator - (int)iterator) < 0.1) {
//                g2.drawString(Integer.toString((int)iterator), (int)(iterator + pivot.x), (int)(pivot.y));
//                System.out.println((int)(iterator + pivot.x));
//                System.out.println((int)(pivot.y));
//            }
//        }
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
