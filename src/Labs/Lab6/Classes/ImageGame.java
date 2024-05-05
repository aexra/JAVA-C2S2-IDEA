package Labs.Lab6.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Sprite;
import Labs.GameEngine.Core.Vector2;
import Labs.Lab6.Enums.eModificationType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class ImageGame extends Game {
    private Sprite image;
    private eModificationType mode;

    @Override
    public void start() {
        super.start();

        image = new Sprite("./src/Labs/Lab6/Assets/WiseTree.jpg");
        image.transform.scale = new Vector2(500, 500);

        tree.add(image);

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
                        blur();
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
        image.transform.scale.x = getWidth();
        image.transform.scale.y = getHeight();
    }

    public void gray() {
        System.out.println("Применен GRAY метод");
    }

    public void blur() {
        System.out.println("Применен BLUR метод");
    }

    public void rotate() {
        image.flipX();
        System.out.println("Применен ROTATE метод");
    }
}
