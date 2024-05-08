package Labs.GameEngine.Core.Interfaces;

import Labs.GameEngine.Core.Vector2;
import Labs.GameEngine.Core.Vector3;

import java.util.ArrayList;

public interface IDecartGraphMember {
    ArrayList<Vector2> getY(float start, float end, float step);
    ArrayList<Vector2> simulate(Vector3 sig);
    boolean isNewSimulation(Vector3 sig);
}
