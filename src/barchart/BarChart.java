/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barchart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Windows 10
 */
public class BarChart extends JPanel {

    private static Map<Color, Integer> bars
            = new LinkedHashMap<Color, Integer>();
    private int max = 1;
    private final int value = 100;
    private final int[] markedColumn = {value * 1, value * 10, value * 100, value * 1000, value * 10000};
    private Dimension dimension;

    /**
     * 17. Add new bar to chart 18.
     *
     * @param color color to display bar 19.
     * @param value size of bar 20.
     */
    public void addBar(Color color, int value) {
        bars.put(color, value);
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
// determine longest bar

// paint bars
        int width = (getWidth() / bars.size()) - 2;
        int x = 10;
        for (Color color : bars.keySet()) {
            int value = bars.get(color);
            float ratio = 0.20f;
            if (value <= markedColumn[0]) {
                max = markedColumn[0];
            } else if (value <= markedColumn[1]) {
                max = markedColumn[1];
                ratio = 0.40f;

            } else if (value <= markedColumn[2]) {
                max = markedColumn[2];
                ratio = 0.60f;

            } else if (value <= markedColumn[3]) {
                max = markedColumn[3];
                ratio = 0.80f;

            } else {
                max = (int) ((int) markedColumn[4] * 0.98f);
                ratio = 0.90f;

            }
            int height = (int) ((getHeight() - 5) * ((double) value / max) * ratio);
            int y = getHeight() - height;
            g.setColor(color);
            g.fillRect(x, y, width, height);
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
            g.drawString("a", x + (width
                    / 2), y - 5);
            x += (width + 2);
        }
    }

    @Override

    public Dimension getPreferredSize() {

        return new Dimension(bars.size() * 30 + 2, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bar Chart");
        BarChart chart = new BarChart();
        chart.addBar(Color.red, 1000000);
        chart.addBar(Color.green, 8);
        chart.addBar(Color.blue, 54);
        chart.addBar(Color.black, 23);
        chart.addBar(Color.yellow, 23);
        chart.addBar(Color.black, 23);
        chart.addBar(Color.black, 23);

        frame.getContentPane().add(chart);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
