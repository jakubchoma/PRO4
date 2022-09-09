package cz.spsmb.ctvrtak.a_promenny_pocet_argumentu_metod;

import java.util.ArrayList;

/***
 * Díky anotaci @SafeVarargs nyní můžeme vytvořit doposud zakázaná pole. Stačí definovat metodu s proměnným počtem
 * argumentů a pole stěmito argumenty pak vrátit jako funkční hodnotu.
 */
public class DVytvoreniPoleSGenerickymiInstancemi {
    @SafeVarargs
    public static <E> E[] arrayOf(E... array){
        return array;
    }

    public static void main(String[] args) {
        var aint = arrayOf(1, 2, 3, 5, 7, 11);
        Object[] astr = arrayOf("raz", "dva", "tři");
        var abool = arrayOf(true, false, false);
        var alist = arrayOf(new ArrayList<String>(), new ArrayList<Object>());

        // U takto vytvořeného pole překladač nekontroluje typ přiřazované hodnoty. tj. následující kód vede k chybě
        // v runtime:
        Object[] oo = aint;
        oo[0] = "NULA";
    }

}
