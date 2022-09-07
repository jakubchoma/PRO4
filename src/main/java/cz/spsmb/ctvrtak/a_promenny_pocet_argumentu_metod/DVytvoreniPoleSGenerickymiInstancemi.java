package cz.spsmb.ctvrtak.a_promenny_pocet_argumentu_metod;

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
        var astr = arrayOf("raz", "dva", "tři");
        // U takto vytvořeného pole překladač nekontroluje typ přiřazované hodnoty. tj. následující kód vede k chybě
        // v runtime:
        Object[] oo = aint;
        oo[0] = "NULA";
    }

}
