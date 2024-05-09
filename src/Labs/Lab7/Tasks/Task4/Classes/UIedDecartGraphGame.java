package Labs.Lab7.Tasks.Task4.Classes;

import Labs.GameEngine.Core.Base.Game;
import Labs.GameEngine.Core.DecartGraph;
import Labs.GameEngine.Core.DecartGraphCurve;
import Labs.GameEngine.Core.DecartGraphMember;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class UIedDecartGraphGame extends Game {
    private DecartGraph graph;

    private DecartGraphMember func1;
    private DecartGraphMember func2;
    private DecartGraphMember func3;

    @Override
    public void start() {
        super.start();

        graph = new DecartGraph("Decart Graph");

        graph.backgroundColor = Color.darkGray;
        graph.axisStrokeColor = Color.gray;
        graph.axisNumberColor = Color.white;

        func1 = new DecartGraphCurve(x -> (float)Math.sin(x), "sin(x)");
        func2 = new DecartGraphCurve(x -> (float)(Math.sin(x * x) + Math.cos(x * x)), "sin(x*x) + cos(x*x)");
        func3 = new DecartGraphCurve(x -> (float)(2 * Math.sin(x) + Math.cos(2 * x)), "2*sin(x)+cos(2*x)");
        func1.strokeColor = Color.red;
        func2.strokeColor = Color.red;
        func3.strokeColor = Color.red;
        func1.visible = false;
        func2.visible = false;
        func3.visible = false;

        graph.add(func1);
        graph.add(func2);
        graph.add(func3);

        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                var scroll = e.getWheelRotation();
                if (scroll > 0) {
                    graph.zoom -= graph.zoom / 10;
                }
                else if (scroll < 0)
                {
                    graph.zoom += graph.zoom / 10;
                }
            }
        });

        tree.add(graph);

        panel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        var checkBox1 = new JCheckBox(func1.toString());
        var checkBox2 = new JCheckBox(func2.toString());
        var checkBox3 = new JCheckBox(func3.toString());

        checkBox1.setVerticalAlignment(SwingConstants.TOP);
        checkBox2.setVerticalAlignment(SwingConstants.TOP);
        checkBox3.setVerticalAlignment(SwingConstants.TOP);

        checkBox1.addActionListener(e -> func1.visible = checkBox1.isSelected());
        checkBox2.addActionListener(e -> func2.visible = checkBox2.isSelected());
        checkBox3.addActionListener(e -> func3.visible = checkBox3.isSelected());

        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);

        var colorSelector = new JColorChooser();
        colorSelector.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                var color = colorSelector.getColor();
                if (checkBox1.isSelected()) {
                    func1.strokeColor = color;
                }
                if (checkBox2.isSelected()) {
                    func2.strokeColor = color;
                }
                if (checkBox3.isSelected()) {
                    func3.strokeColor = color;
                }
            }
        });

        panel.add(colorSelector);

        panel.revalidate();
    }

    @Override
    public void beforeUpdate(long deltaTime) {
        super.beforeUpdate(deltaTime);

        graph.transform.scale.x = panel.getWidth();
        graph.transform.scale.y = panel.getHeight();

        graph.pivot.x = graph.transform.scale.x / 2;
        graph.pivot.y = graph.transform.scale.y / 2;
    }
}
