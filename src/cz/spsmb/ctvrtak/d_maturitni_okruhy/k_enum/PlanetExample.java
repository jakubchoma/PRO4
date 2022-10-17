package cz.spsmb.ctvrtak.d_maturitni_okruhy.k_enum;

public class PlanetExample {
    // Example usage (slight modification of Sun's example):
    public static void main(String[] args) {
        Planet pEarth = Planet.EARTH;
        double earthRadius = pEarth.radius(); // Just threw it in to show usage

        // Argument passed in is earth Weight.  Calculate weight on each planet:
        double earthWeight = 5.972E24;//Double.parseDouble(args[0]);
        double mass = earthWeight/pEarth.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}
