package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.b_builder;

/***
 * Mějme třídu Player s vlastnostmi name, hp, man a dmg. Návrhový vzor builder umožňuje jednoduše přebít výchozí hodnoty
 * těchto vlastností ještě před vlastním vytvořením objektu.
 * Základem je statická vnořená třída (nested class). Statická proto, aby bylo možné vytvářet instanci vnořené třídy
 * Build bez vytvoření instance vnější třídy Player. Konstruktor třídy Player je private, aby builder byla jediná možnost,
 * jak vytvořit instanci třídy Player.
 */
public class Player {

    private String name;
    private double hp;
    private double mana;
    private double dmg;
    /*
    TAKHLE NE
    public Player() {
        this("Steve", 100,100,2);
    }*/
    private Player(String name, double hp, double mana, double dmg) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.dmg = dmg;
    }

    public static class Builder {
        // výchozí hodnoty, které jsou nastaveny při zavolání
        // new Player.Builder()
        private String name = "Steve";
        private double hp = 100;
        private double mana = 100;
        private double dmg = 2;
        // všechny settery vrací tentýž objekt pro možné řetězení
        // př.: (new Player.Builder()).setName("John").setDmg(12).setHp(5).setMana(1).build()
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHp(double hp) {
            this.hp = hp;
            return this;
        }

        public Builder setMana(double mana) {
            this.mana = mana;
            return this;
        }

        public Builder setDmg(double dmg) {
            this.dmg = dmg;
            return this;
        }
        // Jedniné volání operátoru new a vrácení instance třídy Player
        public Player build() {
            return new Player(name, hp, mana, dmg);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    @Override
    public String toString() {
        return "com.spsmb.builder.Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", mana=" + mana +
                ", dmg=" + dmg +
                '}';
    }
}
