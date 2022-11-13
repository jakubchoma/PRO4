package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune;

import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.WofModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class WofApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        WofModel model = new WofModel();
        WofView rootView = new WofView();
        WofPresenter presenter = new WofPresenter(model, rootView);

        Scene scene = new Scene(rootView, 300, 300);
        stage.setScene(scene);
        rootView.init();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
