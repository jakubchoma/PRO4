package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory;

import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory.cars.Car;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Car car1 = factory.getCar("skoda");
        Car car2 = factory.getCar("bMw");
        Car car3 = factory.getCar("TeSla");
        Car car4 = factory.getCar(null);
        car1.drive();
        car2.drive();
        car3.drive();
        car4.drive();
    }

}
