package werft;

import definitions.Definitions;
import inout.InOut;
import schiffe.Schiff;

import java.util.ArrayList;
import java.util.List;

public class Werft {
    List<Schiff> meineSchiffe = new ArrayList<Schiff>();
    List<Schiff> defekteSchiffe = new ArrayList<Schiff>();


    // TODO Fields of Werft

    public Werft() {
        // TODO Constructor of Werft
    }

    public double arbeitetEinenMonat(double kontostand) {
        for (Schiff schiff : meineSchiffe) {
            if (schiff.getZustand() > 25) {
                schiff.setZustand(schiff.getZustand() * 0.92);
                switch (schiff.getClass().getSimpleName()){
                    case "Frachtschiff":
                        kontostand += Definitions.FRACHTSCHIFFGEWINN;
                    case "Tankschiff":
                        kontostand += Definitions.TANKSCHIFFGEWINN;
                    case "Passagierschiff":
                        kontostand += Definitions.PASSAGIERSCHIFFGEWINN;
                }
            } else {
                defekteSchiffe.add(schiff);
            }
        }
        return kontostand;
    }

    public void zustandAusgeben(double i) {
        for (Schiff schiff : meineSchiffe) {
            InOut.printString(schiff.getClass().getSimpleName() + " Kennzeichen: " + schiff.getKennzeichen() + ", Zustand: " + schiff.getZustand());
        }
        System.out.println(String.format("Kontostand: %.2f Mio EUR", i));
    }

    public void hinzufuegen(Schiff e) {
        meineSchiffe.add(e);
    }

    public void streichen(int i) {
        for (Schiff schiff : defekteSchiffe) {
            if (schiff.getKennzeichen() == i){
                schiff.setZustand(100 - (schiff.getReparaturen() * 5));
            }
        }



    }


// TODO Weitere Methoden der Werft
}
