package Labs.GameEngine.BaseClasses;

import Labs.GameEngine.Core.SceneTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    public GamePanel panel;
    public SceneTree tree;
    public Color backgroundColor;

    private Timer _gameTimer;
    private long _lastTimeMillis;
    private long deltaTime;

    public Game() {
        this._configure();
    }
    public Game(int width, int height) {
        this._configure(width, height);
    }
    public Game(GamePanel panel, int width, int height) {
        this._configure(panel, width, height);
    }

    private void _configure() {
        this._configure(1000, 600);
    }
    private void _configure(int width, int height) {
        this._configure(new GamePanel(this), width, height);
    }
    private void _configure(GamePanel panel, int width, int height) {
        this.panel = panel;
        this.tree = new SceneTree(this);
        this.backgroundColor = Color.white;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        add(this.panel);
        setVisible(true);

        _lastTimeMillis = System.currentTimeMillis();
        _gameTimer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });
        _gameTimer.start();
    }

    public Game run() {

        return this;
    }

    private void animate() {
        var current = System.currentTimeMillis();
        this.deltaTime = current - _lastTimeMillis;
        _lastTimeMillis = current;
        tree.update(this.deltaTime);
        panel.repaint();
    }
}
