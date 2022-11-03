package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhovy_vzor_prepravka;
/***
 * https://zooom.cz/navrhove-vzory-messenger-prepravka/#priklady-pouziti
 * počet atributů = počet přenášených hodnot
 * instance třídy jsou tzv. immutable objects
 * atributy třídy jsou veřejné konstanty
 * lze k nim (z důvodu efektivity) přistupovat přímo
 * nelze je dále měnit
 * lze definovat přístupové metody (gettery), příp. další užitečné metody
 * atributy třídy jsou nastaveny v konstruktoru, dále je nelze měnit (bezpečné předání dat)
 *
 * Možnosti použití
 * pokud potřebujeme, aby metoda vracela více hodnot najednou
 * (vrací stále jen jeden messenger, ale ten má více atributů)
 * pokud potřebujeme předat více hodnot jedním parametrem
 */

public class Point {
    public final int x;
    public final int y;

    public Point( int x, int y )
    {
        this.x = x;
        this.y = y;
    }
}
