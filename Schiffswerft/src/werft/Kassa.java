package werft;

import definitions.Definitions;

public class Kassa {
    private double kontostand = Definitions.ANFANGSKAPITAL;

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void abziehen(double betrag) {
        this.kontostand -= betrag;
    }

}
