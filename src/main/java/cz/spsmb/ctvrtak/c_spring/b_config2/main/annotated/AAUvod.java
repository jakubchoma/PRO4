package cz.spsmb.ctvrtak.c_spring.b_config2.main.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/***
 * Anotace jsou v Javě dostupné od verze 5 a představují možnost jak přidat metadata, které pak mohou bý použity jak
 * při překladu, tak i v runtime. Konfigurace frameworku Spring založená na anotacích byla uvedena ve frameworku Spring
 * ve verzi 2.5.
 * Stereotypy - obdobné anotace k anotaci @Component, které obsahují
 *     @AliasFor(
 *         annotation = Component.class
 *     )
 * a používají se výhradně k označení třídy:
 * @Component   - značkovací anotace, používá se k označení třídy, která je pro framework Spring tak označena
 *                jako komponenta. Pomocí metody getBean tak můžeme získat  instanci tédo třídy.
 * @Repository  - specializace anotace @Component, která pomocí parametru value označuje název objektu přístupu k datům
 *                (DAO - Data Access Object).
 * @Service     - specializace anotace @Component, používá se pro vrstvu služby. Pomocí parametru value zadáme název,
 *                který použijeme v metodě getBean.
 * @Controller  - specializace anotace @Component, používá se pro práci s web obsahem (např. zpracování HTTP požadavku).
 *
 * Další důležité anotace:
 * @Autowired   - můžeme jí označit následující deklarace:
 *                CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE
 *                Spring kontejner tak automaticky zavolá pro členskou proměnnou konstruktor, vyrobí tak instanci a
 *                přiřadí jí označené proměnné.
 */

public class AAUvod {
}
