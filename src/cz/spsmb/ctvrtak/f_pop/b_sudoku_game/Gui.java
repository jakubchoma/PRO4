package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


class TfInfo {
    public final int row;
    public final int column;

    public TfInfo(int row, int column) {
        this.row = row;
        this.column = column;
    }



}

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
        sudoku.prepareForLevel(0);
        int[][] plocha = sudoku.getPlocha();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField tf = new TextField(plocha[row][col]==0?"":Integer.toString(plocha[row][col]));
                tf.setPrefWidth(100);
                tf.setPrefHeight(100);
                tf.setStyle("-fx-font-size:30px");
                tf.setAlignment(Pos.CENTER);
                tf.setUserData(new TfInfo(row,col));
                tf.setOnKeyTyped(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        System.out.println("Zadali jste: "+keyEvent.getCharacter());
                        ArrayList<String> kontrola = new ArrayList<>();
                        TextField currentTf = (TextField) keyEvent.getSource();
                        for (int i = 1; i < 10; i++) {
                            kontrola.add(Integer.toString(i));
                        }
                        if(kontrola.contains(keyEvent.getCharacter())){
                            System.out.println("ok");
                            vbox.requestFocus();
                            TfInfo ti = (TfInfo) currentTf.getUserData();
                            sudoku.getPlocha()[ti.row][ti.column] = Integer.valueOf(keyEvent.getCharacter());
                        }else{
                            System.out.println("neni ok");
                            currentTf.setText("");
                        };
                    }
                });
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

