package cz.spsmb.ctvrtak.d_maturitni_okruhy.y_vlakna.runnable;

public class Inkrementuj implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Inkrementuj i = new Inkrementuj();
        // pokud použiji Runnable namísto Thread, musím buď implementovat členskou proměnnou Třídy Thread a metodu start ,
        // nebo rovnou použiji při vytváření instance vlákna konstruktor třídy Thread s parametrem třídy implementující Runnable (tento přístup) :
        Thread t = new Thread(i);
        t.start();
        t.join();

    }
}
