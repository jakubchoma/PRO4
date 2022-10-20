package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.b_animace;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class JavaFXTimerEx extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //stage.setResizable(false);
        stage.setTitle("Star");
        //setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board b = new Board();
        Pane root = new Pane();
        root.getChildren().add(b.getCanvas());

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}