package schiffe;

import definitions.Definitions;

public class Tankschiff extends Schiff {
    private double preis = Definitions.TANKSCHIFFPREIS;

    public Tankschiff() {
        super();
    }

    public double getPreis() {
        return preis;
    }

}