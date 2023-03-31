package cz.spsmb.ctvrtak.d_maturitni_okruhy.u_animace;

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
public class AAnimationTimer extends Application {
    private Circle kruh = new Circle(20, Color.RED);
    private int vx = 1;
    private int vy = 1;
    @Override
    public void start(Stage stage) throws Exception {


        Pane root = new Pane(kruh);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
        AnimationTimer pohyb = new AnimationTimer() {
            @Override
            public void handle(long l) {
                kruh.setCenterX(kruh.getCenterX()+vx);
                kruh.setCenterY(kruh.getCenterY()+vy);
                if (kruh.getCenterX() > scene.getWidth()){
                    vx *= -1;
                    vy *= -1;
                }
                if (kruh.getCenterX() < 0 ){
                    vx *= -1;
                    vy *= -1;
                }
            }
        };
        pohyb.start();
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
