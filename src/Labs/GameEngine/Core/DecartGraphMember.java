package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Interfaces.IDecartGraphMember;

import java.awt.*;
import java.util.ArrayList;

public class DecartGraphMember implements IDecartGraphMember {

    public Color strokeColor = Color.BLACK;

    public ArrayList<Vector2> simulatedPoints;
    public Vector3 lastSimulationSignature;

    public String name = this.getClass().getName();

    public boolean visible = true;

    public DecartGraphMember() {}
    public DecartGraphMember(String name) { this.name = name; }

    @Override
    public final ArrayList<Vector2> getY(float start, float end, float step) {
        var sig = new Vector3(start, end, step);
        if (isNewSimulation(sig)) {
            simulatedPoints = simulate(sig);
            lastSimulationSignature = sig;
        }
        return simulatedPoints;
    }

    @Override
    public ArrayList<Vector2> simulate(Vector3 sig) {
        return null;
    }

    @Override
    public boolean isNewSimulation(Vector3 sig) {
        if (lastSimulationSignature != null && lastSimulationSignature.x == sig.x && lastSimulationSignature.y == sig.y && lastSimulationSignature.z == sig.z) {
            return false;
        }
        return true;
    }

    public String toString() { return name; }
}
