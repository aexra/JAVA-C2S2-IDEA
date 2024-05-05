package Labs.Lab6.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.Sprite;
import Labs.GameEngine.Core.Vector2;

public class ImageGame extends Game {
    private Sprite image;

    @Override
    public void start() {
        super.start();

        image = new Sprite("./src/Labs/Lab6/Assets/WiseTree.jpg");
        image.transform.scale = new Vector2(500, 500);

        tree.add(image);
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        super.beforeUpdate(deltaTime);
        image.transform.scale.x = getWidth();
        image.transform.scale.y = getHeight();
    }
}
