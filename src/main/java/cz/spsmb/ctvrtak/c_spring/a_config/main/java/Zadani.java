package cz.spsmb.ctvrtak.c_spring.a_config.main.java;

/***
 * 1.
 * V balíčku cz.spsmb.ctvrtak.c_spring.a_config.main.java vytvořte následující třídy
 * s konstruktorem, gettery a settery:
 * Type, členské proměnné name, desc, extension - všechny typu String
 * Doc, členské proměnné String name, String location, Type type
 *
 * Dále vytvořte ve stejném balíčku rozhraní SearchEngine, které obsahuje metody
 * List<Doc> listAll();
 * List<Doc> findByType()
 *
 * 2. V nově vytvořeném balíčku cz.spsmb.ctvrtak.c_spring.a_config.test.java vytvořte třídu
 *  MySearchEngine, která bude implementovat rozhraní SearchEngine z bodu 1. Implementujte zde
 *  i privátní pomocnou metodu storage(), která vrátí vámi vygenerovaný ArrayList instancí třídy Doc.
 *  Vymyslete si 2 typy (třída Type) a ke každému typu si vymyslete 2 dokumenty (třída Doc)
 *
 * 3. v balíčku cz.spsmb.ctvrtak.c_spring.a_config.test.java vytvořte třídu MyDocumentTest, která
 * obsahuje členskou proměnnou
 * private SearchEngine engine = new MySearchEngine;
 *
 * Třída MyDocumentTest bude pomocí frameworku junit.jupiter (v projektu PRO4 již zaimplementován)
 * implementovat metodu
 * @Test testFindByType(), která otestuje, zda vámi zadaný typ uvnitř této metody je nalezen pomocí
 * metody engine.findByType(vasDocumentType) a metodu
 * @Test testListAll, která zkontroluje, zda metoda engine.listAll(vrací správný počet argumentů).
 *
 * V obou případech použijte třídu Assertions pro kontrolu výsledků.
 *
 * 4. výsledek pošlete pull-requestem zpátky na github pro oznámkování.
 */
public class Zadani {
}
