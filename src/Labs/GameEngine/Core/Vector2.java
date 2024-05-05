package Labs.GameEngine.Core;

public class Vector2 {
    public float x = 0;
    public float y = 0;

    public Vector2() {}

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static Vector2 ZERO = new Vector2(0, 0);
    public static Vector2 UP = new Vector2(0, 1);
    public static Vector2 DOWN = new Vector2(0, -1);
    public static Vector2 LEFT = new Vector2(-1, 0);
    public static Vector2 RIGHT = new Vector2(1, 0);
}
