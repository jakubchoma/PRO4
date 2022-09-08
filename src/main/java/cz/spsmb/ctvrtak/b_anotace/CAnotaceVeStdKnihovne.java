package cz.spsmb.ctvrtak.b_anotace;

/***
 * @Deprecated - nemá parametry, lze použít u libovolné deklarace. Oznamuje, že jí označená
 *               deklarace je považována za zavrženou a neměla by se používat (nejčastěji metoda, typ).
 *               Překladač je povinnen vydat varovná hlášení. Ty lze potlačit anotací
 *               @SuppressWarning("deprecation")
 * @Override   - bezparametrická, určena k označení metod, které mají přebít stejnojmenné metody
 *               v rodičovské třídě. Užitečné, neboť často dochází k nechtěnému přetěžování namísto
 *               překrytí.
 * @SuppressWarnings - jako parametr má definován vektor stringů specifikujících varování, která
 *               má překladač potlačit při překladu anotované entity a všech entit, které obsahuje.
 *               Příklad: @SuppressWarnings({"unchecked", "rawtypes"})
 * @SafeVarargs
 * @FunctionalInterface - kontrola, zda rozhraní je funkční, tedy má deklarovánu právě jednu metodu a
 *               může být použito pro lambda výraz.
 *
 */
public class CAnotaceVeStdKnihovne {

}
