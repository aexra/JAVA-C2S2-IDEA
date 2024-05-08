package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Interfaces.IFunction2D;

import java.util.ArrayList;

public class DecartGraphCurve extends DecartGraphMember {
    public IFunction2D function;

    public DecartGraphCurve(IFunction2D func) {
        this.function = func;
    }

    @Override
    public ArrayList<Vector2> simulate(Vector3 sig) {
        ArrayList<Vector2> points = new ArrayList<>();
        var iterator = sig.x;
        while (iterator < sig.y) {
            points.add(new Vector2(iterator, function.solve(iterator)));
            iterator += sig.z;
        }
        return points;
    }
}
