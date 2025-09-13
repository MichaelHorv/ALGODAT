package schiffe;

import definitions.Definitions;

public class Passagierschiff extends Schiff {
    private double preis = Definitions.PASSAGIERSCHIFFPREIS;

    public Passagierschiff() {
        super();
    }

    public double getPreis() {
        return preis;
    }

}