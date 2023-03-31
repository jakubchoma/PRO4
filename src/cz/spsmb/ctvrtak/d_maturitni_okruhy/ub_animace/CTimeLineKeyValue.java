package cz.spsmb.ctvrtak.d_maturitni_okruhy.ub_animace;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CTimeLineKeyValue extends Application {
    private Circle k1 = new Circle(50, Color.RED);
    private double speedX = 2;
    private double speedY = 2;

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 600);
        root.getChildren().add(k1);
        k1.setCenterX(50);
        k1.setCenterY(50);
        stage.setScene(scene);
        stage.show();
        Timeline tline = new Timeline();
        tline.setAutoReverse(true);
        tline.getKeyFrames().addAll(
                new KeyFrame(Duration.seconds(5), new KeyValue(k1.translateXProperty(), scene.getWidth())),
                new KeyFrame(Duration.seconds(5), new KeyValue(k1.translateYProperty(), scene.getHeight())),
                new KeyFrame(Duration.seconds(1), new KeyValue(k1.radiusProperty(),100))
        );
        tline.setCycleCount(Animation.INDEFINITE);
        tline.play();
    }




    public static void main(String[] args) {
        Application.launch(args);
    }
}
