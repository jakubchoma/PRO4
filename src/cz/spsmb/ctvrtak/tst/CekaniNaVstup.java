package cz.spsmb.ctvrtak.tst;

import java.util.Scanner;

public class CekaniNaVstup extends Thread{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(" Zadej cislo: ");
            int cislo = scanner.nextInt();
            System.out.format("zadals %d,tmp je %d",cislo,ZadaniVlakna.tmp);
        }
    }
}
