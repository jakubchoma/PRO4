package cz.spsmb.ctvrtak.e_javafx.hry.a_zaklady.d_pohyb_spritu_fire;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MovingSpriteFireEx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Moving sprite");
        Board b = new Board();
        Pane root = new Pane(b.getCanvas());
        Scene scene = new Scene(root);
        // Důležité, bez vyžádaného focusu nebudou klávesy reagovat
        b.getCanvas().requestFocus();
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
