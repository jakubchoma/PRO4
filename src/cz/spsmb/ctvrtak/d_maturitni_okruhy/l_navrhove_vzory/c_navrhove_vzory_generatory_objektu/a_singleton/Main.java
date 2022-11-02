package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.a_singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
        System.out.println(singleton.getName());
    }

}
