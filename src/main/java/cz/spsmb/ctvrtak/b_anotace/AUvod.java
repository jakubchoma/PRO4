package cz.spsmb.ctvrtak.b_anotace;

/***
 * Anotace (občas používáme termín metadata) jsou značky vkládané do zdrojového kódu a
 * určené pro
 * - nástroje pro práci se zdrojovým kódem, např. javadoc
 * - začlenění do přeloženého .class souboru a určeny pro nástroje pracující s těmito
 *   soubory (Např nástroje připravující instalaci na aplikační server), před vlastním
 *   spuštěním programu
 * - mohou být začleněny do class souboru a určeny pro zpracování za běhu programu
 *   s pomocí reflexe.
 *
 * Označení anotace provádíme znakem @. Za ním může být klidně jedna, nebo více mezer.
 *
 */
public class AUvod {
    @MojeAnotace
    public static void test(){
        return;
    }
    //Anotace mohou mít parametry:
    @Testovat(druh = "A")
    public static void mojeMetoda(){

    }
    //Parametrem anotace může být i pole. Ve skutečnosti se však žádné pole nevytváří a výčet ve
    // složených závorkách je jediným povoleným způsobem, jak anotaci předat skupinu hodnot:
    @Testovat(frekvence = {Den.SO, Den.NE})
    public static void mojeMetoda2(){

    }
    // deklaraci lze označit i více anotacemi:
    @Testovat
    @MojeAnotace
    public static void mojeMetoda3(){}

}
