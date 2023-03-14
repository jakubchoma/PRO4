package cz.spsmb.ctvrtak.tst;
// Vytvořte vlákno, které bude zvyšovat statickou proměnnou tmp o danou
// hodnotu každých 200ms
// Vytvořte vlákno, které bude čekat na vstup od uživatele (třída Scanner). Po zadání vstupního
// čísla se zobrazí toto číslo i hodnota proměnné tmp inkrementované prvním vláknem


public class ZadaniVlakna {

    static int tmp;

    public static void main(String[] args) throws InterruptedException {
        Thread vlakno = new Thread(){
            @Override
            public void run() {
                while(true) {
                    ZadaniVlakna.tmp += 1;

                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("došlo k přetušení vlákna");
                        e.printStackTrace();
                    }
                }
            }
        };
        CekaniNaVstup vlakno2 = new CekaniNaVstup();
        vlakno2.start();
        vlakno.start();
       /* System.out.println(tmp);
        Thread.sleep(1000);
        System.out.println(tmp);
        vlakno.join(1000);
        System.out.println(tmp);
        vlakno.interrupt();*/
    }
}
