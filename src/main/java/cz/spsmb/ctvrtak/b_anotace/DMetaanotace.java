package cz.spsmb.ctvrtak.b_anotace;

/***
 * Metaanotace jsou anotace určené k označení definic jiných anotací.
 *
 * @Documented - bez parametrů. Sděluje, že jí anotovaná anotace má být uvedena v dokumentaci touto
 *               anotací označených entit. Javadoc jí pak uvede jako součást popisu dokumentace. Příkladem
 *               je anotace @Deprecated.
 * @Inherited  - indikuje, že anotace jejíž definici s ní označíme, se stane součístí dědictví dceřinných
 *               tříd touto anotací označené třídy. Má smysl pouze v případě, že se na ní dotazujeme v
 *               runtime a jen u tříd.
 * @Repeatable - označuje, že jí označená anotace může být v jedné deklaraci použita opakovaně.
 * @Retention  - jednoparametrická, parametr typu java.lang.annotation.RetentionPolicy, což je výčtový typ:
 *    SOURCE   - pouze pro programy pracující se zdrojovým kódem (např. překladač). Do přeloženého
 *               souboru se už daná informace nedostane.
 *    CLASS    - takto označená anotace se dostane až do .class souboru. Využít to mohou programy pro
 *               instalaci. Zavaděč tříd jí však nezapracuje do runtime. Výchozí hodnota.
 *    RUNTIME  - informace o anotaci se dostane až do class-objektu třídy, kterou anotace označuje.
 *               pomocí reflexe je pak možné za běhu příslušnou informaci zjistit.
 * @Target     - jednoparametrická, specifikuje, které druhy entit je možno jí označenou anotací
 *               označit výčtový typ java.lang.annotation.ElementType:
 *    ANNOTATION_TYPE - definice jiné anotace
 *    CONSTRUCTR      - definice konstruktoru
 *    FIELD           - deklarace atributu
 *    LOCAL_VARIABLE  - deklarace lokální proměnné
 *    METHOD          - deklarace metody
 *    MODULE          - deklarace modulu
 *    PACKAGE         - deklarace balíčku
 *    PARAMETER       - deklarace parametru
 *    TYPE            - deklarace třídy, rozhraní (vč anotací) nebo výčtu
 *    TYPE_PARAMETER  - deklarace typového parametru
 *    TYPE_USE        - použití datového typu.
 *
 *    Anotace parametrů a lokálních proměnných se nikdy nedostanou dál, než je zdrojový kód.
 */
public class DMetaanotace {
}
