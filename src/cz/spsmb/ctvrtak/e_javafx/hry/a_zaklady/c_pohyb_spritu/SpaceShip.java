package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;


import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

public class SpaceShip {

    private int dx=1;
    private int dy;
    private int x = 40;
    private int y = 60;
    private double w;
    private double h;
    private Image image;

    public SpaceShip() {

        loadImage();
    }

    private void loadImage() {

        //ImageIcon ii = new ImageIcon("src/resources/craft.png");
        image = new Image("craft.png");

        w = image.getWidth();
        h = image.getHeight();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public Image getImage() {

        return image;
    }

    public void keyPressed(KeyEvent e) {

        KeyCode key = e.getCode();
        //e.getEventType() == KEY_PRESSED
        if (key == KeyCode.LEFT) {
            dx = -2;
        }

        if (key == KeyCode.RIGHT) {
            dx = 2;
        }

        if (key == KeyCode.UP) {
            dy = -2;
        }

        if (key == KeyCode.DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        KeyCode key = e.getCode();

        if (key == KeyCode.LEFT) {
            dx = 0;
        }

        if (key == KeyCode.RIGHT) {
            dx = 0;
        }

        if (key == KeyCode.UP) {
            dy = 0;
        }

        if (key == KeyCode.DOWN) {
            dy = 0;
        }
    }
}
