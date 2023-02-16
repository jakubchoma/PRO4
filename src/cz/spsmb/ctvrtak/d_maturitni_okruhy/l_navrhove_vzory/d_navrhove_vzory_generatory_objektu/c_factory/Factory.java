package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.c_factory;

import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.c_factory.cars.Bmw;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.c_factory.cars.Car;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.c_factory.cars.Skoda;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.c_factory.cars.Tesla;
// Návrhový vzor factory používá pomocnou metodu, (zde getCar), která vrátí požadovanou instanci více
// specifikovaného datového typu (zde rozhraní Car). Zde se využívá polymorfismu Car může být Skoda, Bmw i Tesla.
public class Factory {

    public Car getCar(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("skoda")) return new Skoda();
        if (type.equalsIgnoreCase("tesla")) return new Tesla();
        if (type.equalsIgnoreCase("bmw")) return new Bmw();
        return null;
    }

}
