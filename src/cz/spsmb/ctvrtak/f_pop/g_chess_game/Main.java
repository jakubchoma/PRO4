package cz.spsmb.ctvrtak.f_pop.g_chess_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;



class LabelInfo {
    public final int row;
    public final int column;

    public LabelInfo(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        Label l = new Label("");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                l = new Label("");
                l.setMinSize(100,100);
                l.setUserData(new LabelInfo(i,j));
                root.add(l,i,j);
                l.setStyle("-fx-border-color: BLACK");
                if ((i+j) % 2 == 0) {
                    l.setStyle("-fx-background-color: WHITE");
                }else {
                    l.setStyle("-fx-background-color: GREY");
                }
            }
        }

        SVGPath svg = new SVGPath();
        svg.setContent("M19.97,17.758A1,1,0,0,0,19,17h-.536c-1.377-1.76-1.87-5.044-2-7H17a1,1,0,0,0,0-2h-.064a5.145,5.145,0,0,0,.314-1.75,5.25,5.25,0,0,0-10.5,0A5.145,5.145,0,0,0,7.064,8H7a1,1,0,0,0,0,2h.533c-.127,1.956-.62,5.24-2,7H5a1,1,0,0,0-.97.758l-1,4A1,1,0,0,0,4,23H20a1,1,0,0,0,.97-1.242ZM12,3a3.254,3.254,0,0,1,3.25,3.25A3.158,3.158,0,0,1,14.72,8H9.28a3.158,3.158,0,0,1-.53-1.75A3.254,3.254,0,0,1,12,3ZM9.536,10h4.928a18.915,18.915,0,0,0,1.641,7H7.9A18.915,18.915,0,0,0,9.536,10ZM5.281,21l.5-2H18.219l.5,2Z");
        svg.setScaleX(3);
        svg.setScaleY(3);
        l.setGraphic(svg);



        Scene scena = new Scene(root);
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
