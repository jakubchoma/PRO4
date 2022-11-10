package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.d_navrhove_vzory_generatory_objektu.b_builder;

public class Main {
    public static void main(String[] args) {
        Player player = (new Player.Builder()).
                setName("John").
                setDmg(12).setHp(5).
                setMana(1).
                build();
        /* TAKHLE NE
        Player player2 = new Player();
        player.setMana(1);
        player.setHp(5);

         */
        System.out.println(player);
    }
}