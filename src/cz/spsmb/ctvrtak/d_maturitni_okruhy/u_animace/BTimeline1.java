package cz.spsmb.ctvrtak.d_maturitni_okruhy.u_animace;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BTimeline1 extends Application {
    private Circle kruh = new Circle(20, Color.RED);
    private int vx = 1;
    private int vy = 1;
    @Override
    public void start(Stage stage) throws Exception {


        Pane root = new Pane(kruh);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
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
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
