package com.kinderao;

import java.awt.*;

public class Circle {
    public int x, y;

    private int r;
    public int vx, vy;
    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;

        //碰撞检测
        checkCollisionWithEdge(minx, miny, maxx, maxy);

        // 和其他的圆环碰撞检测

    }

    public void checkCollisionWithEdge(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) {
            x = r; vx = -vx;
        }
        if (x + r> maxx) {
            x = maxx -r; vx = -vx;
        }
        if (y - r < miny) {
            y = r; vy = -vy;
        }
        if (y + r > maxy) {
            y = maxy - r; vy = -vy;
        }
    }

    public void checkCollisionWithOther(Circle[] circles) {

    }


    public boolean contains(Point point) {
        return (point.x - x) * (point.x - x) + (point.y - y) * (point.y - y) <= r * r;
    }
}
