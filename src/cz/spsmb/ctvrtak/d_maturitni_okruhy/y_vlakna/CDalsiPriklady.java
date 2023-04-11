package cz.spsmb.ctvrtak.d_maturitni_okruhy.y_vlakna;

import java.time.LocalTime;
import java.util.Random;

/*
- Vytvořte program, který bude generovat náhodnou posloupnost se seed 1.
  Výsledky (celkem 10) pište do konzole každou sekundu.

- Vytvořte algoritmus, který bude generovat 3 náhodné posloupnosti se seed 1,
  každou v jiném vlákně. Ve finále zobrazte součty jednotlivých posloupností
  a celkový součet.

* */
public class CDalsiPriklady {
    public static void main(String[] args) {
        Random rnd = new Random(LocalTime.now().toNanoOfDay());
        for(int i = 0; i<10; i++) {
            System.out.println(rnd.nextInt());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
