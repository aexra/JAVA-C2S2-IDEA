package Labs.Lab7.Tasks.Task3.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.Lab6.Classes.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AnimationGame extends Game {
    private int maxBalls = 10;
    private JLabel info;
    private Timer stringIteratingTimer;
    private boolean stringUpdateRequired = false;

    @Override
    public void start() {
        super.start();

        var runBtn = new JButton("Run");
        var stpBtn = new JButton("Stop");
        var addMaxBtn = new JButton("Increase balls limit");
        info = new JLabel();

        runBtn.addActionListener(e -> updating = true);
        stpBtn.addActionListener(e -> updating = false);
        addMaxBtn.addActionListener(e -> {
            maxBalls++;
            stringUpdateRequired = true;
        });
        info.setMinimumSize(new Dimension(100, 40));
        info.setPreferredSize(new Dimension(100, 40));
        info.setMaximumSize(new Dimension(100, 40));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (tree.head.children.size() >= maxBalls) return;
                var ball = new Ball("Ball");
                ball.transform.position.x = e.getX() - ball.transform.scale.x;
                ball.transform.position.y = e.getY() - ball.transform.scale.y;
                tree.add(ball);
                stringUpdateRequired = true;
            }
        });

        stringIteratingTimer = new Timer(100, e -> {
            var text = info.getText();
            text += text.charAt(0);
            text = text.substring(1);
            info.setText(text);
        });

        panel.add(runBtn);
        panel.add(stpBtn);
        panel.add(addMaxBtn);
        panel.add(info);

        panel.revalidate();

        setInfo();
        stringIteratingTimer.start();
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        super.beforeUpdate(deltaTime);

        if (stringUpdateRequired) {
            setInfo();
            stringUpdateRequired = false;
        }
    }

    private void setInfo() {
        var text = "Current balls count: " + tree.head.children.size() + ", maximum balls count: " + maxBalls + "             ";
        info.setText(text);
    }
}
