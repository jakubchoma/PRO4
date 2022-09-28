package cz.spsmb.ctvrtak.a_promenny_pocet_argumentu_metod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPromennyPocetArgumentuAParametrickeTypy {
    /***
     * Takto obdržíme varovné hlášení. To lze potlačit anotací @SuppressWarnings("unchecked"),
     * nicméně pro tento případ byla vytvořena anotace @SafeVarargs
     * @param lists
     */
    public static void mtd(List<String>... lists){

    }
    @SafeVarargs
    public static void m(List<String>... stringLists){ //není bezpečné
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; //sémanticky špatně, překlad však proběhne bez problémů
        String s = stringLists[0].get(0); // Dostáváme CastClassException za běhu v silně typovaném jazyce !
    }
    public static void main(String[] args) {
        m(new ArrayList<String>(), new ArrayList<String>());
    }
}
