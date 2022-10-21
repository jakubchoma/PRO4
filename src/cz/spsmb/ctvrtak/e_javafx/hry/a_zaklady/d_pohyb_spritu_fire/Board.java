package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.d_pohyb_spritu_fire;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.List;


public class Board extends AnimationTimer {
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private SpaceShip spaceShip;
    private Canvas canvas;
    //private final int DELAY = 10;

    public Board() {
        this.canvas = new Canvas(300,300);
        // Canvas je transparentní. Tj. pokud chceme pozadí nějaké barvy, vykreslíme obdelník
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        initBoard();
    }

    private void initBoard() {

        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                spaceShip.keyPressed(keyEvent);
            }
        });
        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                spaceShip.keyReleased(keyEvent);
            }
        });
        //addKeyListener(new TAdapter());
        //setBackground(Color.black);
        //setFocusable(true);

        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        //timer = new Timer(DELAY, this);
        this.start();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    @Override
    public void handle(long l) {
        step();
    }

    private void step() {
        this.updateMissiles();
        this.updateSpaceShip();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(6);
        gc.strokeRect(spaceShip.getX()-3, spaceShip.getY()-3, spaceShip.getImage().getWidth()+6, spaceShip.getImage().getHeight()+6);
        gc.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY());

        List<Missile> missiles = spaceShip.getMissiles();

        for (Missile missile : missiles) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(3);
            gc.strokeLine(missile.getX()-3, missile.getY(), missile.getX()-3, missile.getY()+missile.height);
            gc.drawImage(missile.getImage(), missile.getX(),
                    missile.getY());
        }
        //repaint(spaceShip.getX()-1, spaceShip.getY()-1,
        //        spaceShip.getWidth()+2, spaceShip.getHeight()+2);
    }

    private void updateMissiles() {
        List<Missile> missiles = spaceShip.getMissiles();
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }
    }

    private void updateSpaceShip() {
        spaceShip.move();
    }
/*
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceShip.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceShip.keyPressed(e);
        }
    }*/
}
