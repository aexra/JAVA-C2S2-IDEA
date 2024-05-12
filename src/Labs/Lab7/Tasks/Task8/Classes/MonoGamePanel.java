package Labs.Lab7.Tasks.Task8.Classes;

import Labs.Lab7.Tasks.Task5.Classes.StrangePanel;

import javax.swing.*;
import java.awt.*;

public class MonoGamePanel extends JPanel {
    private StrangePanel sp1;
    private StrangePanel sp2;
    private StrangePanel sp3;
    private StrangePanel sp4;
    private StrangePanel sp5;
    private StrangePanel sp6;
    private StrangePanel sp7;
    private StrangePanel sp8;

    private GameManagerPanel gmp;

    public StrangePanel[] panels;

    public MonoGamePanel() {
        sp1 = new StrangePanel("Player1", "+20", "Player2");
        sp2 = new StrangePanel("", "Try Again...", "");
        sp3 = new StrangePanel("", "-50", "");
        sp4 = new StrangePanel("", "Finish!", "");
        sp5 = new StrangePanel("", "Lost All", "");
        sp6 = new StrangePanel("", "-10", "");
        sp7 = new StrangePanel("", "+10", "");
        sp8 = new StrangePanel("", "+30", "");

        panels = new StrangePanel[] {
            sp1, sp2, sp3, sp5, sp8, sp7, sp6, sp4
        };

        gmp = new GameManagerPanel(this);

        sp1.backgroundColor = new Color(152, 254, 152);
        sp2.backgroundColor = new Color(254, 254, 203);
        sp3.backgroundColor = new Color(254, 152, 152);
        sp4.backgroundColor = new Color(0, 203, 101);
        sp5.backgroundColor = new Color(254, 50, 101);
        sp6.backgroundColor = new Color(254, 203, 203);
        sp7.backgroundColor = new Color(203, 254, 203);
        sp8.backgroundColor = new Color(50, 254, 0);

        setLayout(new GridLayout(3, 3));

        add(sp1);
        add(sp2);
        add(sp3);
        add(sp4);
        add(gmp);
        add(sp5);
        add(sp6);
        add(sp7);
        add(sp8);
    }
}
