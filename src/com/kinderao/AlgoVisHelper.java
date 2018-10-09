package com.kinderao;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
    private AlgoVisHelper() {}

    public static void setStrokeWidth(Graphics2D g, int width) {
        g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void strokeCircle(Graphics2D g, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.draw(circle);
    }

    public static void fillCircle(Graphics2D g, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.fill(circle);
    }

    public static void setColor(Graphics2D g, Color color) {
        g.setColor(color);
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("error in sleeping");
        }
    }
}
