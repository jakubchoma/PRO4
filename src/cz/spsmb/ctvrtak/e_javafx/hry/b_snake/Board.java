package cz.spsmb.ctvrtak.e_javafx.hry.b_snake;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class Board extends Group {

    private static final int B_WIDTH = 300;
    private static final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Canvas canvas;
    private Timeline timeline;
    private long frameDuration = 250;
    private Image ball;
    private Image apple;
    private Image head;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        canvas = new Canvas(this.B_WIDTH, this.B_HEIGHT);

        this.getChildren().add(this.canvas);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        //canvas.setOnKeyPressed(this::keyPressed);
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println("tl");
                keyPressed(keyEvent);
            }
        });
        //canvas.requestFocus();
        /*addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
*/
        loadImages();
        initGame();
    }

    private void loadImages() {
        this.ball = new Image("dot.png");
        this.apple = new Image("apple.png");
        this.head = new Image("head.png");
    }

    private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
        /*this.timeline = new Timeline(new KeyFrame(Duration.millis(this.frameDuration), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        }));*/
        this.timeline = new Timeline(new KeyFrame(Duration.millis(this.frameDuration), this::actionPerformed));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.play();
    }

    private void doDrawing() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        if (inGame) {
            gc.drawImage(apple, apple_x, apple_y);
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    gc.drawImage(head, x[z], y[z]);
                } else {
                    gc.drawImage(ball, x[z], y[z]);
                }
            }
        } else {
            gameOver();
        }
    }

    private void gameOver() {
        GraphicsContext gc = this.canvas.getGraphicsContext2D();
        String msg = "Game Over";
        //Font small = new Font("Helvetica", Font.BOLD, 14);
        //FontMetrics metr = getFontMetrics(small);
        //TODO: vypocet sirky zpravy v pixelech

        gc.setStroke(Color.WHITE);
        //gc.setFont(Font.font("small"));
        gc.strokeText(msg, 10, B_HEIGHT / 2);
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            this.timeline.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();

            checkCollision();
            move();
            this.doDrawing();
        }
    }

    public void keyPressed(KeyEvent e) {
        KeyCode key = e.getCode();

        if ((key == KeyCode.LEFT) && (!rightDirection)) {
            leftDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyCode.RIGHT) && (!leftDirection)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if ((key == KeyCode.UP) && (!downDirection)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if ((key == KeyCode.DOWN) && (!upDirection)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }
}