package GameDev;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class platform {
    private int dx;
    private int x, y, width, height;

    public platform() {
        x = 250;
        y = 450;
        width = 120;
        height = 50;
    }

    public platform(int i, int j) {
        x = i;
        y = j;
        width = 120;
        height = 40;
        dx = -1;
    }

    void update(MainGame sp, ball b) {
        x += dx;
        Random r = new Random();
        if (x + width < 0) {
            x = sp.getWidth() + r.nextInt(400);
        }
        checkForCollision(b);

    }

    private void checkForCollision(ball b) {
        int ballX = b.getX();
        int ballY = b.getY();
        int rad = b.getRad();
        if (ballY + rad > y && ballY + rad < y + height) {
            if (ballX + rad > x && ballX < x + width) {
                double newDy = -60;
                b.setY(y - rad);
                b.setDy(newDy);


            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(new Color(160, 82, 45));
        g.fillRect(x, y, width, height);
    }

    void moveRight() {
        if (x < 500) {
            x += 60;
        }

    }

    void moveLeft() {
        if (x > 0) {
            x -= 60;
        }

    }
}
