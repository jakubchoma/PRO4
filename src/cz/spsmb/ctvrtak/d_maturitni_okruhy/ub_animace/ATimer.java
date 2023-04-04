package cz.spsmb.ctvrtak.d_maturitni_okruhy.ub_animace;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Napište program, který vykreslí kruh a bude s ním hýbat od rohu do rohu pomocí AnimationTimer
 */

public class ATimer extends Application {
    private Circle k1 = new Circle(50, Color.RED);
    private double speedX = 2;
    private double speedY = 2;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,500,600);
        root.getChildren().add(k1);
        stage.setScene(scene);
        stage.show();
        k1.setCenterX(50);
        k1.setCenterY(50);
        AnimationTimer atimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                k1.setCenterX(k1.getCenterX()+speedX);
                k1.setCenterY(k1.getCenterY()+speedY);
                if(k1.getCenterY() > scene.getHeight()- k1.getRadius() || k1.getCenterY() - k1.getRadius() < 0) speedY *= -1;
                if(k1.getCenterX() > scene.getWidth()- k1.getRadius() || k1.getCenterX() - k1.getRadius() < 0) speedX *= -1;

            }
        };
        atimer.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
