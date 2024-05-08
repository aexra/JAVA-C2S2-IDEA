package Labs.Lab6.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.DecartGraph;
import Labs.GameEngine.Core.DecartGraphCurve;
import Labs.GameEngine.Core.Vector2;

import java.awt.*;

import static java.lang.Math.sin;

public class ComplexGraphSystemGame extends Game {
    private DecartGraph graph;

    public ComplexGraphSystemGame() {
        super();
        graph = new DecartGraph("Graph");
        graph.add(new DecartGraphCurve((x) -> (float)-sin(x)));
        graph.simStep = 0.001f;
        graph.xInterval.x = -10;
        graph.xInterval.y = 10;

        graph.transform.scale = new Vector2(getWidth(), getHeight());

        tree.add(graph);
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        graph.pivot.x = (float) panel.getWidth() / 2;
        graph.pivot.y = (float) panel.getHeight() / 2;
    }
}
