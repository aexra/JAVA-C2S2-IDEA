package Labs.Lab6.Classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageContainer extends JPanel {
    private boolean rotated = false;
    private JFrame frame;
    private BufferedImage image;


    public ImageContainer() throws IOException {
        frame = new JFrame();
        image = ImageIO.read(new File("./src/Labs/Lab6/Assets/WiseTree.png"));

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                flip();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(this);
        frame.setVisible(true);

        repaint();
    }

    public void flip() {
        if (image != null) {
            AffineTransform tx;
            tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(null), 0);
            var op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            image = op.filter(image, null);
            rotated = !rotated;
            System.out.println("Flipped");
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), this);
    }
}
