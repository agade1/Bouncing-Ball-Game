package GameDev;

import java.awt.Color;
import java.awt.Graphics;

public class ball {

    private int x = 300, y = 0;
    private double gravity = 5;
    private double dx = 0, dy = 0;
    private int rad = 50;
    private double dt = .2;

    public ball(int i, int j) {
        x = i;
        y = j;
    }

    void moveRight() {
        if (x < 1230) {
            x += 20;
        }

    }

    void moveLeft() {
        if (x > 0) {
            x -= 20;
        }

    }

    public ball() {

    }

    void update(MainGame sp) {

        if (x > sp.getWidth() - rad - 1) {
            x = sp.getWidth() - rad - 1;
            dx = -dx;
        } else if (x < 0) {
            x = 0;
            dx = -dx;
        } else {
            x += dx;
        }

        if (y > sp.getHeight() - rad - 46) {
            y = sp.getHeight() - rad - 46;
            dy = -dy;
        } else if (y < 0) {
            y = 0;
            dy = -dy;
        } else {
            dy += gravity * dt;
            y += dy * dt + .5 * gravity * dt * dt;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval(x, y, rad, rad);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRad() {
        return rad;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }


}
