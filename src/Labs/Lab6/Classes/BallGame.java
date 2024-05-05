package Labs.Lab6.Classes;

import Labs.GameEngine.BaseClasses.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BallGame extends Game {
    public BallGame(int width, int height) {
        super(width, height);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                var ball = new Ball("Ball1");
                ball.transform.position.x = e.getX() - ball.transform.scale.x;
                ball.transform.position.y = e.getY() - ball.transform.scale.y;
                tree.add(ball);
            }
        });
    }
}
