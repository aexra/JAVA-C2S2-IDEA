package Labs.Lab6.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Sprite;
import Labs.GameEngine.Core.Vector2;
import Labs.Lab6.Enums.eModificationType;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ImageGame extends Game {
    private Sprite sprite;
    private eModificationType mode;

    @Override
    public void start() {
        super.start();

        sprite = new Sprite("./src/Labs/Lab6/Assets/WiseTree.jpg");
        sprite.transform.scale = new Vector2(500, 500);

        tree.add(sprite);

        mode = eModificationType.ROTATE;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                switch (e.getKeyChar()) {
                    case 'r', 'R':
                        mode = eModificationType.ROTATE;
                        break;
                    case 'g', 'G':
                        mode = eModificationType.GRAY;
                        break;
                    case 'b', 'B':
                        mode = eModificationType.BLUR;
                        break;
                    default:
                        break;
                }
                System.out.println("Текущий метод: " + mode);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                switch (mode) {
                    case BLUR:
                        blur(3);
                        break;
                    case GRAY:
                        gray();
                        break;
                    case ROTATE:
                        rotate();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        super.beforeUpdate(deltaTime);
        sprite.transform.scale.x = getWidth();
        sprite.transform.scale.y = getHeight();
    }

    public void gray() {
        int width = sprite.source.getWidth();
        int height = sprite.source.getHeight();

        BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(sprite.source.getRGB(x, y));
                int gray = (int) (color.getRed() * 0.299 + color.getGreen() * 0.587 + color.getBlue() * 0.114);
                Color grayColor = new Color(gray, gray, gray);
                grayscaleImage.setRGB(x, y, grayColor.getRGB());
            }
        }

        sprite.source = grayscaleImage;

        System.out.println("Применен GRAY метод");
    }

    public void blur(int intensity) {
        int width = sprite.source.getWidth();
        int height = sprite.source.getHeight();

        BufferedImage blurredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int red = 0, green = 0, blue = 0;
                int count = 0;
                for (int dy = -intensity; dy <= intensity; dy++) {
                    for (int dx = -intensity; dx <= intensity; dx++) {
                        int nx = x + dx;
                        int ny = y + dy;
                        if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                            Color color = new Color(sprite.source.getRGB(nx, ny));
                            red += color.getRed();
                            green += color.getGreen();
                            blue += color.getBlue();
                            count++;
                        }
                    }
                }
                red /= count;
                green /= count;
                blue /= count;
                Color avgColor = new Color(red, green, blue);
                blurredImage.setRGB(x, y, avgColor.getRGB());
            }
        }

        sprite.source = blurredImage;

        System.out.println("Применен BLUR метод");
    }

    public void rotate() {
        sprite.flipX();
        System.out.println("Применен ROTATE метод");
    }
}
