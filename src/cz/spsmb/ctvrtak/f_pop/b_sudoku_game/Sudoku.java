package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Sudoku {
    private int[][] plocha = new int[9][9];

    public int[][] getPlocha() {
        return plocha;
    }

    public void randomFill(){
        Random rnd = new Random();
        // Pole seznamů:
        HashSet<Integer>[] columns = new HashSet[this.plocha.length];
        HashSet<Integer>[] wins = new HashSet[this.plocha.length];
        int i=0,j=0;
        loop1:
        do {
            for (int j1 = 0; j1 < this.plocha.length; j1++) {
                columns[j1] = new HashSet<>();
                wins[j1] = new HashSet<>();
                for (int k1 = 0; k1 < this.plocha.length; k1++) {
                    this.plocha[j1][k1] = 0;
                }
            }

            for (i = 0; i < this.plocha.length; i++) {
                HashSet<Integer> actualRow = new HashSet<>();
                for (j = 0; j < this.plocha[0].length; j++) {
                    int cislo;
                    HashSet<Integer> docasna = new HashSet<>(actualRow);
                    docasna.addAll(columns[j]);
                    docasna.addAll(wins[3 * (j / 3) + i / 3]);
                    if (docasna.size() == plocha.length) {
                        continue loop1;
                    }
                    do {
                        cislo = rnd.nextInt(9) + 1;
                    } while (docasna.contains(cislo));
                    actualRow.add(cislo);
                    columns[j].add(cislo);
                    wins[3 * (j / 3) + i / 3].add(cislo);
                    this.plocha[i][j] = cislo;
                }
                //System.out.println("Generuji " + i + "radek");
                //System.out.println(this);
            }
        }while(i < plocha.length && j < plocha.length);
    }
    public void prepareForLevel(int level){
        Random rnd = new Random();
        for (int i = 0; i < this.plocha.length; i++) {
            for (int j = 0; j < this.plocha[0].length; j++) {
                //hážu kostkou s 8 stranami
                if (rnd.nextInt(9) <= level){
                    this.plocha[i][j] = 0;
                }
            }

        }
    }
    public boolean isZero() {
        for (int i = 0; i < this.getPlocha().length; i++) {
            for (int j = 0; j < this.getPlocha()[0].length; j++) {
                if (this.getPlocha()[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public String toString(){
        StringBuffer tmp = new StringBuffer();
        for (int[] row : this.plocha) {
            for (int cislo : row) {
                tmp.append(cislo+",");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }
    public boolean checkCols() {
        for (int colIdx = 0; colIdx < this.plocha.length; colIdx++) {
            for (int i = 0; i < this.plocha.length; i++) {
                int cislo = this.plocha[i][colIdx];
                for (int j = i + 1; j < this.plocha.length; j++) {
                    if (cislo == this.plocha[j][colIdx]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean checkRows() {
        for (int rowIdx = 0; rowIdx < this.plocha.length; rowIdx++) {
            for (int i = 0; i < this.plocha[rowIdx].length; i++) {
                int cislo = this.plocha[rowIdx][i];
                for (int j = i + 1; j < this.plocha[rowIdx].length; j++) {
                    if (cislo == this.plocha[rowIdx][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean checkWins(){
        ArrayList<Integer>[] plocha2 = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            plocha2[i] = new ArrayList<>();
        }
        //Transformace oken 3x3 do řádků pole2
        for (int i = 0; i < plocha.length ; i++) {
            for (int j = 0; j < plocha.length; j++) {
                    plocha2[(j/3)*3 + i/3].add(plocha[i][j]);
            }
        }
        //dodělat
        for (int rowIdx = 0; rowIdx < plocha2.length; rowIdx++) {
            for (int i = 0; i < plocha2[rowIdx].size(); i++) {
                int cislo = plocha2[rowIdx].get(i);
                for (int j = i + 1; j < plocha2[rowIdx].size(); j++) {
                    if (cislo == plocha2[rowIdx].get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int cnt = 0;
        do {
            cnt++;
            sudoku.randomFill();
            //System.out.println(sudoku);
            //System.out.print("\rPočet pokusů: " + cnt);
            //System.out.print("\rPočet pokusů: " + cnt);
       } while (!sudoku.checkCols() || !sudoku.checkRows() || !sudoku.checkWins());
        System.out.println(sudoku.checkWins());
        System.out.println(sudoku);
        System.out.println("Počet pokusů: " + cnt);
    }
}
