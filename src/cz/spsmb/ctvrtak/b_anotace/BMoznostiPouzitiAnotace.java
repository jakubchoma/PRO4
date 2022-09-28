package cz.spsmb.ctvrtak.b_anotace;

/*
 * Anotovat lze atributy (proměnné), konstruktory, metody, parametry metod (vč. parametru this),
 * typové argumenty parametrizovaných typů, jakoukoliv část deklarace pole, rodičovskou třídu, či
 * implementované rozhraní, volání konstruktoru, Typ v operaci přetypování, či zjišťování příslušnosti
 * k typu, při specifikaci vyhazované výjimky, žolík a omezení hodnoty typového parametru, odkaz
 * na metodu reprezentovanou pomocí operátoru čtyřtečka
 *
 * Anotovat nelze literál datového typu
 * @A String.class
 * importovaný typ
 * import Java.lang.@A String
 */

import java.util.Comparator;

public class BMoznostiPouzitiAnotace {
    Integer o = Integer.valueOf(5);
    //Anotace atributu (proměnné):
    @MojeAnotace
    String atribut = "Atribut";
    //Anotace metody:
    @Override
    public String toString() {return "";}
    //Anotace parametrů metod, vč. this:
    @MojeAnotace
    public void metoda(/*@A BMoznostiPouzitiAnotace this,*/ @MojeAnotace int i) {
        @MojeAnotace String lp = "lokální proměnná";
    }
    //Anotace typových argumenty parametrizovaných typů:
    //List<@MojeAnotace String> list;
    //Comparator.<@MojeAnotace String> reverseOrder();

    //Anotace deklarace pole
    @MojeAnotace int[][] ai0;       //anotuje položky typu int (vždy, pokud je anotace uvedena na
                                    // začátku deklaace)
    //int @MojeAnotace [][] ai2;    //anotuje celé dvourozměrné pole int[][]
    //int[] @MojeAnotace [] ai1;    //anotuje položky typu int[]

    //Anotace rodičovské třídy a implementovaného rozhraní:
    //@MojeAnotace class Child extends @MojeAnotace Parent implements @MojeAnotace Interface

    // Anotace volání konstruktoru:
    // new @MojeAnotace Cls();


    //Anotace typu v operaci přetypování, či zjišťování příslušnosti k typu, jsou určeny pro spec.
    // nástroje na vastní operace nemají vliv:
    //String s = (@MojeAnotace String) o;
    //boolean b = o instanceof @MojeAnotace String;

    //Anotace při specifikaci vyhazované výjimky:
    //void method() throws @MojeAnotace IOException{}

    //Anotace žolíka a omezení hodnoty typového parametru:
    //List<@MojeAnotace ? extends String> laem;
    //List<? extends @MojeAnotace String> leam;

    //Anotace odkazu na metodu reprezenovaný operátorem čtyřtečka:
    //@MojeAnotace AUvod::test;


}
