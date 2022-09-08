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
    //Anotace mohou mít parametry:
    @Testovat(druh = "A")
    public void mojeMetoda(){

    }
}
