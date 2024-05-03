package Labs.Lab6.Tasks;

import Labs.Lab6.Classes.Curve;

public class Task2 {
    public static void main(String[] args) {
        var curve = new Curve();

        double[] xValues = new double[101];
        double[] yValues = new double[101];

        double x = 0;

        for (int i = 0; i < 101; i++) {
            xValues[i] = x;
            yValues[i] = Math.sin(x);
            x += 2 * Math.PI / 100;
        }

        curve.setLimits(0, 2*Math.PI, -1, 1);
        curve.setData(xValues, yValues);
    }
}
