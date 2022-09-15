package cz.spsmb.ctvrtak.a_promenny_pocet_argumentu_metod;

import java.util.Arrays;

/***
 * Java umožňuje definovat metody, které můžeme pokaždé volat s jiným počtem argumentů, přestože
 * se počet jejich parametrů nezmění.
 * Chceme-li definovat metodu s proměnným počtem argumentů, je potřeba definovat společný typ argumentů,
 * jejichž počet předem neznáme. V seznamu parametrů tento typ uvádíme jako poslední a připíšeme za něj
 * tzv. "výpustku" v podobě tří teček.
 * Tento proměnný počet argumentů je reprezentován obyčejným jednorozměrným polem.
 *
 */
public class AUvod {
    public static void variant(String title, int... args) {
        int count = args.length;
        System.out.println(count + " volitelných argumentů pro " + title);
        System.out.println("Argumenty: " + Arrays.toString(args));
    }

    public static void main(String[] args) {
        // může být i nulový počet argumentů
        variant("Nic");
        variant("pět", 1, 2, 3, 4, 5);
        variant("cosi", 5, 6, 7);
        // mohu zadat i pole jako argumenty
        int[] a = {5, 4, 3, 2, 1};
        variant("dalsi", a);
    }
}
