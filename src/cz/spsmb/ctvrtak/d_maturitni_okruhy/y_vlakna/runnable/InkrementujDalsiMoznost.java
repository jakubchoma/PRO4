package cz.spsmb.ctvrtak.d_maturitni_okruhy.y_vlakna.runnable;

public class InkrementujDalsiMoznost implements Runnable {
    // pokud použiji Runnable namísto Thread, musím buď implementovat členskou proměnnou Třídy Thread a metodu
    // start (tento přístup),
    // nebo rovnou použiji při vytváření instance vlákna konstruktor třídy Thread s parametrem třídy implementující Runnable :
    private Thread zobrazVl = null;

    public Thread getZobrazVl() {
        return zobrazVl;
    }

    public void start() {
        this.zobrazVl = new Thread(this);
        this.zobrazVl.start();
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InkrementujDalsiMoznost i = new InkrementujDalsiMoznost();
        i.start();
        i.getZobrazVl().join();

    }
}
