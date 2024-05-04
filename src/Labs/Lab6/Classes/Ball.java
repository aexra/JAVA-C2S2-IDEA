package Labs.Lab6.Classes;

import Labs.Lab6.BaseClasses.GameObject2D;

import java.awt.*;
import java.util.Random;

public class Ball extends GameObject2D {
    private Vector2 velocity;
    private Color color;
    private static Color[] colors = {
            Color.RED,
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.ORANGE,
            Color.PINK,
            Color.YELLOW
    };

    public Ball(String objectName) {
        super(objectName);
        velocity = new Vector2(0.4f, 0.4f);
        transform.scale = new Vector2(50, 50);
        var rnd = new Random();
        this.color = colors[rnd.nextInt(0, colors.length)];
    }

    @Override
    public void update(long deltaTime) {
        transform.position.x += velocity.x * deltaTime;
        transform.position.y += velocity.y * deltaTime;

        // Левая граница
        if (velocity.x < 0 && transform.position.x < 0) velocity.x *= -1;
        if (transform.position.x < 0) transform.position.x = 0;

        // Правая граница
        if (velocity.x > 0 && transform.position.x + transform.scale.x > game.getWidth()) velocity.x *= -1;
        if (transform.position.x + transform.scale.x > game.getWidth()) transform.position.x = game.getWidth() - transform.scale.x;

        // Верхняя граница
        if (velocity.y < 0 && transform.position.y < 0) velocity.y *= -1;
        if (transform.position.y < 0) transform.position.y = 0;

        // Нижняя граница
        if (velocity.y > 0 && transform.position.y + transform.scale.y > game.getHeight()) velocity.y *= -1;
        if (transform.position.y + transform.scale.y > game.getHeight()) transform.position.y = game.getHeight() - transform.scale.y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.fillOval(
                (int)transform.position.x,
                (int)transform.position.y,
                (int)transform.scale.x,
                (int)transform.scale.y
        );
    }
}
