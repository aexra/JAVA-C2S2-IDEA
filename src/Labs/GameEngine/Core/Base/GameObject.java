package Labs.GameEngine.Core.Base;

import Labs.GameEngine.Core.Transform;
import Labs.GameEngine.Core.Interfaces.IGameObject;
import Labs.GameEngine.Core.Interfaces.ISceneTreeNode;

import java.awt.*;
import java.util.ArrayList;

public class GameObject implements IGameObject, ISceneTreeNode {
    public Transform transform;
    public GameObject parent;
    public ArrayList<GameObject> children;
    public String objectName;
    public Game game;

    public GameObject(String objectName) {
        this.transform = new Transform();
        this.objectName = objectName;
        this.children = new ArrayList<GameObject>();
    }

    @Override
    public void update(long deltaTime) {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public GameObject add(GameObject object) {
        object.parent = this;
        object.game = this.game;
        children.add(object);
        return object;
    }
}
