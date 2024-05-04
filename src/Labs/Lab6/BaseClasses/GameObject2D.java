package Labs.Lab6.BaseClasses;

import java.awt.*;

public class GameObject2D extends GameObject {

    public GameObject2D(String objectName) {
        super(objectName);
    }

    @Override
    public void update(long deltaTime) {}

    @Override
    public void draw(Graphics g) {
        draw((Graphics2D)g);
    }

    public void draw(Graphics2D g2) {}
}
