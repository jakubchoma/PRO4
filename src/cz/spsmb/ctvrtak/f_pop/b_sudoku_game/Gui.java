package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Button checkRows = new Button("kontrola řádků");
        Button checkCols = new Button("kontrola sloupců");
        Button checkWins = new Button("kontrola oken");
        HBox hbox = new HBox(checkRows,checkCols,checkWins);
        VBox vbox = new VBox(hbox,grid);
        Sudoku sudoku = new Sudoku();
        sudoku.randomFill();
        sudoku.prepareForLevel(7);
        int[][] plocha = sudoku.getPlocha();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField tf = new TextField(plocha[row][col]==0?"":Integer.toString(plocha[row][col]));
                tf.setPrefWidth(100);
                tf.setPrefHeight(100);
                tf.setStyle("-fx-font-size:30px");
                tf.setAlignment(Pos.CENTER);
                grid.add(tf, col, row);
            }
        }

        checkRows.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(sudoku.checkRows());
            }
        });

        checkCols.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(sudoku.checkCols());
            }
        });

        checkWins.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(sudoku.checkWins());
            }
        });


        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args) {
            launch(args);
        }
    }

