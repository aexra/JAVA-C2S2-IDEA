package Labs.GameEngine.Core;

public class Transform {
    public Vector2 position;
    public Vector2 scale;

    public Transform() {
        position = new Vector2(0, 0);
        scale = new Vector2(1, 1);
    }
    public Transform(Vector2 position, Vector2 scale) {
        this.position = new Vector2(position.x, position.y);
        this.scale = new Vector2(scale.x, scale.y);
    }
    public Transform(int x, int y, int cx, int cy) {
        this.position = new Vector2(x, y);
        this.scale = new Vector2(cx, cy);
    }

    public Vector2 getCenter() {
        return new Vector2(
                position.x + scale.x / 2,
                position.y + scale.y / 2
        );
    }

    public Vector2 translate(int dx, int dy) {
        position.x += dx;
        position.y += dy;
        return position;
    }
    public Vector2 scale(int dcx, int dcy) {
        scale.x *= dcx;
        scale.y *= dcy;
        return scale;
    }
}
