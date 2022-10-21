package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.d_pohyb_spritu_fire;


import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);

        initSpaceShip();
    }

    private void initSpaceShip() {

        missiles = new ArrayList<>();

        loadImage("craft.png");
        getImageDimensions();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        KeyCode key = e.getCode();

        if (key == KeyCode.SPACE) {
            fire();
        }

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

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
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
