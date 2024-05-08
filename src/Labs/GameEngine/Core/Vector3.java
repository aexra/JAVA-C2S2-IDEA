package Labs.GameEngine.Core;

public class Vector3 {
    public float x = 0;
    public float y = 0;
    public float z = 0;

    public Vector3() {}

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static Vector3 ZERO = new Vector3(0, 0, 0);
    public static Vector3 UP = new Vector3(0, 1, 0);
    public static Vector3 DOWN = new Vector3(0, -1, 0);
    public static Vector3 LEFT = new Vector3(-1, 0, 0);
    public static Vector3 RIGHT = new Vector3(1, 0, 0);
    public static Vector3 FORWARD = new Vector3(0, 0, 1);
    public static Vector3 BACK = new Vector3(0, 0, -1);
}
