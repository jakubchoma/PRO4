package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.c_pohyb_spritu;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MovingSpriteEx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Moving sprite");
        Board b = new Board();
        //setSize(400, 300);
        Pane root = new Pane(b.getCanvas());
        //root.getChildren().add(b.getCanvas());
        Scene scene = new Scene(root);
        b.getCanvas().requestFocus();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                int i;
            }
        });
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
