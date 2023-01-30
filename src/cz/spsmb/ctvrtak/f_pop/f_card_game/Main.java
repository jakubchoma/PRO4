package cz.spsmb.ctvrtak.f_pop.f_card_game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane card1 = Cards.DIA_2.getCard();
        Pane card2 = Cards.CLU_2.getCard();
        card2.setLayoutX(Cards.width);
        Pane card3 = Cards.HEA_2.getCard();
        card3.setLayoutX(2*Cards.width);
        Pane card4 = Cards.SPA_2.getCard();
        card4.setLayoutX(3*Cards.width);
        Group root = new Group(card1, card2, card3, card4);
        Scene scena = new Scene(root);
        stage.setScene(scena);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
