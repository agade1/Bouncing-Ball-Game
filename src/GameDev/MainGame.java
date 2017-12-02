package GameDev;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;

public class MainGame extends Applet implements Runnable, KeyListener {

    /**
     * Bouncing Ball Game
     *
     * Summer project
     * Developed by: Amol Gade
     */
    private static final long serialVersionUID = 1L;
    private Image image;
    private Graphics graphics;
    ball ball;
    private double score = 0;
    int newScore = 0;
    platform pt[] = new platform[7];
    URL url;
    Image city;
    double cityX = 0;
    double cityDx = 1;


    public void init() {
        setSize(1250, 700);
        addKeyListener(this);
        try {
            url = getDocumentBase();
        } catch (Exception e) {
            // TODO: handle exception
        }

        city = getImage(url, "Images/backgroundImage.png");
    }

    public void start() {
        ball = new ball();


        for (int i = 0; i < pt.length; i++) {
            Random r = new Random();
            pt[i] = new platform(r.nextInt(1200), 100 + r.nextInt(500));
        }
        Thread t = new Thread(this);
        t.start();
    }

    public void stop() {

    }

    public void destroy() {

    }

    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getSize().width, this.getSize().height);
            graphics = image.getGraphics();
        }
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, this.getSize().width, this.getSize().height);

        graphics.setColor(getForeground());
        paint(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void paint(Graphics g) {
        g.drawImage(city, (int) cityX, 0, this);
        g.drawImage(city, (int) cityX + 2 * getWidth(), 0, this);
        ball.paint(g);
        for (int i = 0; i < pt.length; i++) {
            pt[i].paint(g);
            String s = Integer.toString(newScore);
            g.setColor(Color.PINK);
            g.drawString(s, getWidth() - 70, 70);
            Font font = new Font("Serif", Font.BOLD, 28);
            g.setFont(font);
            String sc = "Your Score ";
            g.drawString(sc, getWidth() - 250, 70);
        }
    }

    public void run() {

        while (true) {

            if (cityX > 2 * getWidth() * -1) {
                cityX -= cityDx;
            } else {
                cityX = 0;
            }

            score += .1;
            newScore = (int) score;
            ball.update(this);
            for (int i = 0; i < pt.length; i++) {
                pt[i].update(this, ball);
            }

            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public double getScore() {
        return score;
    }

    public int getNewScore() {
        return newScore;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setNewScore(int newScore) {
        this.newScore = newScore;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                ball.moveLeft();
                break;

            case KeyEvent.VK_RIGHT:

                ball.moveRight();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }


}
