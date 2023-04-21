package cz.spsmb.ctvrtak.d_maturitni_okruhy.y_vlakna;

import java.time.LocalTime;
import java.util.Random;

/*
- Vytvořte program, který bude generovat náhodnou posloupnost se seed 1.
  Výsledky (celkem 10) pište do konzole každou sekundu.

- Vytvořte algoritmus, který bude generovat 3 náhodné posloupnosti odélce 10 se seed 1,
  každou v jiném vlákně. Ve finále zobrazte součty jednotlivých posloupností
  a celkový součet.

* */

public class CDalsiPriklady {
    /*public static void main(String[] args) {
        Random rnd = new Random(LocalTime.now().toNanoOfDay());
        for(int i = 0; i<10; i++) {
            System.out.println(rnd.nextInt());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    static class InnerThread extends Thread {
        private Random rnd;
        private long sum = 0;

        public InnerThread(long seed) {
            super();
            this.rnd = new Random(seed);
        }

        public InnerThread() {
            this(LocalTime.now().toNanoOfDay());
        }

        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                sum += rnd.nextInt();
            }
        }
        public long getSum() {
            return sum;
        }
    }
    public static void main(String[] args) {
        InnerThread it1 = new InnerThread(1);
        InnerThread it2 = new InnerThread(2);
        InnerThread it3 = new InnerThread(3);

        it1.start();
        it2.start();
        it3.start();

        try {
            it1.join();
            it2.join();
            it3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.format("thread1: %d%nthread2: %d%nthread3: %d%n", it1.getSum(), it2.getSum(), it3.getSum());
        long sum = it1.getSum() + it2.getSum() + it3.getSum();
        System.out.println(sum);
    }
}
