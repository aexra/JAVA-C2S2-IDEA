package Labs.Lab6.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.DecartGraph;
import Labs.GameEngine.Core.DecartGraphCurve;
import Labs.GameEngine.Core.Vector2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import static java.lang.Math.sin;

public class ComplexGraphSystemGame extends Game {
    private DecartGraph graph;

    public ComplexGraphSystemGame() {
        super();
        graph = new DecartGraph("Graph");

        graph.backgroundColor = Color.darkGray;
        graph.axisStrokeColor = Color.gray;
        graph.axisNumberColor = Color.white;

        graph.transform.scale = new Vector2(getWidth(), getHeight());

        var curve = new DecartGraphCurve((x) -> (float)-sin(x));
        curve.strokeColor = Color.getHSBColor(180, 0.79f, 0.81f);
        graph.add(curve);

        tree.add(graph);

        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                var scroll = e.getWheelRotation();
                if (scroll > 0) {
                    graph.zoom -= graph.zoom / 10;
                }
                else if (scroll < 0)
                {
                    graph.zoom += graph.zoom / 10;
                }
            }
        });
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        graph.transform.scale.x = panel.getWidth();
        graph.transform.scale.y = panel.getHeight();

        graph.pivot.x = graph.transform.scale.x / 2;
        graph.pivot.y = graph.transform.scale.y / 2;
    }
}
