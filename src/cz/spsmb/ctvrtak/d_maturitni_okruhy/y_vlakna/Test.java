package cz.spsmb.ctvrtak.d_maturitni_okruhy.y_vlakna;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/*
- Vytvořte program, který bude generovat náhodnou posloupnost se seed 1.
  Výsledky (celkem 10) pište do konzole každou sekundu.

- Vytvořte algoritmus, který bude generovat 3 náhodné posloupnosti o délce 10 se seed 1,
  každou v jiném vlákně. Ve finále zobrazte součty jednotlivých posloupností
  a celkový součet.

- Ve třídě Test implementujte rozhraní Runnable tak, aby ze třídy Test mohla
  vzniknout instance vlákna, které bude vypisovat do konzole posloupnost 10
  čísel z generátoru Random r = new Random(22)

* */
public class Test {
    private static Random r = new Random(1);
    static class T1 extends Thread {
        public int sum;
        @Override
        public void run() {

            for(int i=0; i<10; i++){
                sum += r.nextInt(10);
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        //Test t = new Test();
        //T1 t1 = t.new T1();
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("t1:%d, t2:%d, t3:%d%n", t1.sum, t2.sum, t3.sum);
    }


    public static void main1(String[] args) {
        Random rnd = new Random(1);
        for(int i=0; i<10; i++) {
            System.out.println(rnd.nextInt());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
