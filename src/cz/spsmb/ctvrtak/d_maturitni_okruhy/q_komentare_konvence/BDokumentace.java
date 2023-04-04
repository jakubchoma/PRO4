package cz.spsmb.ctvrtak.d_maturitni_okruhy.q_komentare_konvence;

/**
 * Generujeme pomocí příkazu javadoc a diakritiku přidáme příkazem
 *  javadoc -encoding utf8 -docencoding utf8 -charset utf8
 *  */

// Pomocné značky:
// @author      - v dokumentaci k celé třídě. Zapisuje se do ní jméno autora dané třídy.
// @version     - v dokumentaci k celé třídě. Neexistuje předpis pro formát.
// @param       - značka pro použití v dokumentaci metod s parametry. Za ní se uvádí
//                jméno parametru z příslušné metody a pak popis.
// @returns     - popis návratové hodnoty.
// @throws      - popis důvodu, kvůli kterému může metoda vyhodit výjimku
// další užitečné značky:
// {@code text} - označený text bude neproporcionálním písmem,
// {@link text} - text je odkazem na jinou část programu. Tímto odkazem může být buď jméno
//                třídy, nebo jméno třídy následované znakem # na názvem atributu nebo názvem
//                metody následovaným seznamem typů parametrů v závorkách.
// Do "Other command line arguments" přidat -encoding utf8 -docencoding utf8 -charset utf8

/**
 * Třída {@code AUvod} slouží pouze jako ukázka použití
 * dokumentačních komentářů. <br>
 * Obsahuje pouze definici metody {@link #method(java.lang.String, int)},
 * na níž je demonstrovaná dokumentace:
 * <ul>
 *     <li>účelu metody,</li>
 *     <li>významu jednotlivých parametrů,</li>
 *     <li>návratové hodnoty,</li>
 *     <li>důvodu vedoucího k případnému vyhození výjimky.</li>
 *     </ul>
 *
 * @author Rudolf PECINOVSKÝ
 * @version 2022-Jaro
 */


public class BDokumentace {
    /** Dokumentace atributu */
    public static final String ATTR = "Veřejný konstantní atribut";

    /**
     * Stručný výklad funkce dané metody. První věta tohoto výkladu
     * (přesněji text až k první tečce) bude uvedena v úvodní tabulce metod.
     * @param p1 Popis účelu prvního parametru. Může zabrat i více řádků.
     *           Pak se většinou druhý řádek zalomuje pod začátek výkladu.
     * @param p2
     *        Popis účelu druhého parametru. Některé konvence ponechávají
     *        název parametru na samostatném řádku a jeho popis umisťují
     *        až na řádky následující.
     * @return Specifikace návratové hodnoty
     * @throws UnsupportedOperationException
     *         Za jakých podmínek metoda vyhodí tuto výjimku.
     */
    public String method(String p1, int p2) {
        throw new UnsupportedOperationException("Doposud nedefinováno");
    }

}

