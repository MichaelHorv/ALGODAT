package schiffe;

import definitions.Definitions;

public class Frachtschiff extends Schiff {
    private double preis = Definitions.FRACHTSCHIFFPREIS;

    public Frachtschiff() {
        super();
    }

    public double getPreis() {
        return preis;
    }

}
