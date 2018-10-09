package com.kinderao;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int canvasWitdh;
    private int canvasHeight;

    private Circle[] circles;


    public AlgoFrame(String title, int canvasWidth, int canvasHeight)  {
        super(title);

        this.canvasHeight = canvasHeight;
        this.canvasWitdh = canvasWidth;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public void render(Circle[] circles) {
        this.circles = circles;
        repaint();
    }

    public int getCanvasWitdh() {
        return canvasWitdh;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }


    private class AlgoCanvas extends JPanel {
        public AlgoCanvas() {
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING
                    ,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            g2d.setColor(Color.RED);
            AlgoVisHelper.setStrokeWidth(g2d, 5);


            for (Circle circle : circles) {
                if (circle.isFilled) {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWitdh, canvasHeight);
        }
    }
}
