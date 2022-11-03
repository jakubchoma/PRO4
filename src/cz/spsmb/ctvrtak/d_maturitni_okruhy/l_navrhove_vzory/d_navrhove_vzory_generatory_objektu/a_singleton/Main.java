package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.a_singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        //Nelze
        //Singleton mujSin = new Singleton();
        singleton.doSomething();
        System.out.println(singleton.getName());
    }
}
