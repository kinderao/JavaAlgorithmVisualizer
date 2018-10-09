package com.kinderao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private Circle[] circles; //数据
    private AlgoFrame frame;  //视图

    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        //随机构造出N个圆形出来
        circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = ((int) (Math.random() * (sceneWidth - 2 * R)));
            int y = ((int) (Math.random() * (sceneHeight - 2 * R)));
            int vx = ((int) (Math.random() * 11 - 5));
            int vy = ((int) (Math.random() * 11 - 5));
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                while (true) {
                    run();
                }
            }).start();
        });

    }

    private void run() {
        //绘制数据
        frame.render(circles);
        AlgoVisHelper.pause(20);
        if (isAnimated) {
            //更新
            for (Circle circle : circles) {
                circle.move(0,0, frame.getCanvasWitdh(), frame.getCanvasHeight());
            }
        }
    }
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == ' ') {
                isAnimated = !isAnimated;
            }
        }
    }
    private class AlgoMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,
                    -(frame.getBounds().height - frame.getCanvasHeight()));
            for (Circle circle : circles) {
                if (circle.contains(e.getPoint())) {
                    circle.isFilled = !circle.isFilled;
                }
            }

//            System.out.println("getX:" + e.getX() +",getY:"+ e.getY());
//            System.out.println("getXOnScreen:" + e.getXOnScreen() +",getYOnScreen:"+ e.getYOnScreen());
//            System.out.println("getPoint: x: " + e.getPoint().getX() + ",y: " + e.getPoint().getY());
        }
    }

}
