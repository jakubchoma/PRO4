package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.b_animace;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Board extends javafx.animation.AnimationTimer {

    private final int INITIAL_X = 0;
    private final int INITIAL_Y = 0;
    private final int DELAY = 25;

    private Image star;
    // private Timer timer;
    private int x, y;
    private Canvas canvas;

    public Board() {
        this.canvas = new Canvas();
        this.canvas.heightProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Board.this.prepareCanvas();
            }
        });
        /*
        this.canvas.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Board.this.prepareCanvas();
            }
        });*/
        initBoard();
        this.start();
    }
    public void prepareCanvas(){
        // Canvas je transparentní. Tj. pokud chceme pozadí nějaké barvy, vykreslíme obdelník
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
    }

    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void handle(long l) {
        x += 1;
        y += 1;

        if (y > this.canvas.getHeight()) {
            y = INITIAL_Y;
            x = INITIAL_X;
        }
        this.drawStar();
    }

    private void loadImage() {

        //ImageIcon ii = new ImageIcon("star.png");
        star = new Image("star.png");
    }

    private void initBoard() {
        //setBackground(Color.BLACK);
        //setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImage();
        x = INITIAL_X;
        y = INITIAL_Y;
    }
    private void drawStar() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(this.x-1, this.y-1, star.getWidth()+2, star.getHeight()+2);

        gc.drawImage(star, x, y);
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.strokeText("Text", 10, 10);
        gc.strokeText("Text2", 100, 10, 40);
    }
}