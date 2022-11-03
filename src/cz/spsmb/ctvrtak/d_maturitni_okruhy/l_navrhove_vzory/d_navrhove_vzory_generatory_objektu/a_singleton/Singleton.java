package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.a_singleton;

/***
 * Návrhový vzor jedináček (singleton) předpokládá, že daná třída bude mít právě jednu instanci. Teoreticky by
 * pak bylo možné vůbec instanční členy a metody nepoužívat a namísto toho udělat vše static. Nicméně bychom tak
 * přišli o snadnou manipulaci s objektem v podobě jeho předávání jako parametr metod.
 */
public class Singleton {
    // Statická proměnná singleton obsahuje jedinou instanci třídy Singleton
    private static Singleton singleton = new Singleton();
    // znemožnění vytvoření instance klasickým způsobem pomocí operátoru new
    private Singleton() {}

    private String name = "Foo";

    public static Singleton getInstance() {
        return singleton;
    }

    public void doSomething() {
        System.out.println("Something");
    }

    public String getName() {
        return name;
    }
}
