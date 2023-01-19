package cz.spsmb.ctvrtak.e_javafx.hry.b_snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXSnake extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //stage.setResizable(false);
        stage.setTitle("Snake game");
        Board b = new Board();
        Scene scene = new Scene(b);
        // Důležité, bez vyžádaného focusu nebudou klávesy reagovat. Focus musíme vyžádat až po vytvoření
        // instance scény.
        b.requestFocus();
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
