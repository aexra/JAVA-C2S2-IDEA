package Labs.Lab7.Tasks.Task5.Classes;

import Labs.GameEngine.Core.Transform;

import javax.swing.*;
import java.awt.*;

public class StrangePanel extends JPanel {
    public Transform transform;
    public Color backgroundColor = Color.WHITE;
    public JLabel upperLabel;
    public JLabel centerLabel;
    public JLabel downLabel;

    public StrangePanel() {
        _configure("Upper", "Center", "Lower");
    }

    public StrangePanel(String upper, String center, String lower) {
        _configure(upper, center, lower);
    }

    private void _configure(String upper, String center, String lower) {
        transform = new Transform();

        upperLabel = new JLabel(upper);
        centerLabel = new JLabel(center);
        downLabel = new JLabel(lower);

        upperLabel.setFont(new Font("MONTSERRAT", Font.BOLD | Font.ITALIC, 10));
        centerLabel.setFont(new Font("MONTSERRAT", Font.BOLD, 18));
        downLabel.setFont(new Font("MONTSERRAT", Font.BOLD | Font.ITALIC, 10));

        upperLabel.setHorizontalAlignment(SwingConstants.LEFT);
        centerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        setLayout(new BorderLayout());

        add(upperLabel, "North");
        add(centerLabel);
        add(downLabel, "South");

        revalidate();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(backgroundColor);
        g2.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );
    }
}
