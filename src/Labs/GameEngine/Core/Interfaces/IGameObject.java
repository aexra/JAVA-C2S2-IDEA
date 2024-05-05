package Labs.GameEngine.Core.Interfaces;

import java.awt.*;

public interface IGameObject {
    public void update(long deltaTime);
    public void draw(Graphics g);
}
