package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid = new GridPane();
        Sudoku sudoku = new Sudoku();
        sudoku.randomFill();
        sudoku.prepareForLevel(0);
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
        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args) {
            launch(args);
        }
    }

