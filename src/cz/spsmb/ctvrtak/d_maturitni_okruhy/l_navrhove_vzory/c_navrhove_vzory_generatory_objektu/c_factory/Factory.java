package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory;

import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory.cars.Bmw;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory.cars.Car;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory.cars.Skoda;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.c_navrhove_vzory_generatory_objektu.c_factory.cars.Tesla;
// Návrhový vzor factory využívá polymorfismu, kde daná metoda (zde getCar) vrátí požadovanou instanci více
// speifikovaného datového typu (zde rozhraní Car)
public class Factory {

    public Car getCar(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("skoda")) return new Skoda();
        if (type.equalsIgnoreCase("tesla")) return new Tesla();
        if (type.equalsIgnoreCase("bmw")) return new Bmw();
        return null;
    }

}
