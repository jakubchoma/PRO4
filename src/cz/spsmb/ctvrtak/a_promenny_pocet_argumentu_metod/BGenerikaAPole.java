package cz.spsmb.ctvrtak.a_promenny_pocet_argumentu_metod;

import java.util.ArrayList;

/***
 * Není možné vytvářet pole s prvky typového parametru ani parametrizovaného typu, i když je můžeme
 * deklarovat jako typ vytvářené proměnné. Pokus o vytvoření pole generického typu vyvolá syntaktickou
 * chybu, a to přesto, že pole instancí surového typu vytvořit lze.
 */
public class BGenerikaAPole {
    public static void main(String[] args) {
        //Diamantový operátor - nelze:
        //ArrayList<String>[] listS = new ArrayList<>[5];

        //Explicitní uvedení typu - nelze:
        //ArrayList<String>[] listS = new ArrayList<String>[5];

        //Pole surových typů - lze, ale přicházíme o typovou kontrolu:
        //ArrayList[] listS = new ArrayList[5];

        // Pole je deklarováno jako generické, ale má přiřazené instance surového typu - lze, ale vypíše varování:
        ArrayList<String>[] listS2 = new ArrayList[5];
        //Důležité je, že to funguje:
        listS2[0] = new ArrayList<String>();
        //Nelze
        //listS2[1] = new ArrayList<Integer>();
    }
}
