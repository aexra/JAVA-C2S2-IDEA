package Labs.Lab6.Classes;

import Labs.Lab6.BaseClasses.Game;
import Labs.Lab6.BaseClasses.GameObject;
import Labs.Lab6.Interfaces.ISceneTree;
import Labs.Lab6.Interfaces.ISceneTreeNode;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public final class SceneTree implements ISceneTree {
    public GameObject head;

    public SceneTree(Game game) {
        head = new Scene("Root");
        head.game = game;
    }

    public void update(long deltaTime) {
        if (head == null) return;
        recurseUpdate(head, deltaTime);
    }
    public void draw(Graphics g) {
        if (head == null) return;
        recurseDraw(head, g);
    }
    public GameObject add(GameObject object) {
        return ((ISceneTreeNode)head).add(object);
    }

    public GameObject search(String name) {
        if (head == null) return null;
        return recurseSearch(head, name);
    }

    private void recurseUpdate(@NotNull GameObject object, long deltaTime) {
        object.update(deltaTime);
        for (var child : object.children) {
            recurseUpdate(child, deltaTime);
        }
    }
    private void recurseDraw(@NotNull GameObject object, @NotNull Graphics g) {
        object.draw(g);
        for (var child : object.children) {
            recurseDraw(child, g);
        }
    }
    private GameObject recurseSearch(GameObject object, String name) {
        if (Objects.equals(object.objectName, name)) return object;
        for (var child : object.children) {
            var result = recurseSearch(child, name);
            if (result != null) return result;
        }
        return null;
    }
}
