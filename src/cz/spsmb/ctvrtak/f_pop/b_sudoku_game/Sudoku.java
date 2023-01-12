package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import java.util.Random;

public class Sudoku {
    private int[][] plocha = new int[9][9];

    public void randomFill(){
        Random rnd = new Random();
        for (int i = 0; i < plocha.length; i++){
            for (int j = 0; j < plocha[0].length; j++) {
                plocha[i][j] = rnd.nextInt(9) + 1;
            }
        }
    }
    public String toString(){
        StringBuffer tmp = new StringBuffer();
        for (int[] row : plocha) {
            for (int cislo : row) {
                tmp.append(cislo+",");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.randomFill();
        System.out.println(sudoku);
    }
}
