package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;


public class Board extends AnimationTimer {
    private SpaceShip spaceShip;
    private Canvas canvas;
    //private final int DELAY = 10;

    public Board() {
        this.canvas = new Canvas(300,300);
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

        spaceShip = new SpaceShip();

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
        spaceShip.move();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY());
        //repaint(spaceShip.getX()-1, spaceShip.getY()-1,
        //        spaceShip.getWidth()+2, spaceShip.getHeight()+2);
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
