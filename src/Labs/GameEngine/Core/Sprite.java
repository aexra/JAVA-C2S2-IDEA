package Labs.GameEngine.Core;

import Labs.GameEngine.Core.Base.GameObject2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sprite extends GameObject2D {
    public BufferedImage image;

    public Sprite(String path) {
        super(path);
        this.load(path);
    }
    public Sprite(String objectName, String path) {
        super(objectName);
        this.load(path);
    }

    public void load(String path) {
        try {
            this.image = ImageIO.read(new File(path));
        }
        catch (Exception _) {
            System.out.println("Ошибка загрузки изображения: файл не найден " + path);
        }
    }

    public void flipX() {
        AffineTransform tx;
        tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        var op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
    }

    public void flipY() {
        AffineTransform tx;
        tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        var op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, (int)transform.position.x, (int)transform.position.y, (int)transform.scale.x, (int)transform.scale.y, game.panel);
    }
}
