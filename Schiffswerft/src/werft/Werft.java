package werft;

import definitions.Definitions;
import inout.InOut;
import schiffe.Schiff;

import java.util.ArrayList;
import java.util.List;

public class Werft {
    List<Schiff> meineSchiffe = new ArrayList<Schiff>();
    Kassa meineKassa = new Kassa();

    public Kassa getMeineKassa() {
        return meineKassa;
    }



    public Werft() {
    }

    public void arbeitetEinenMonat() throws KonkursException {
        double kontostand = meineKassa.getKontostand();
        if (!meineSchiffe.isEmpty()) {
            for (Schiff schiff : meineSchiffe) {
                if (!schiff.isDefekt()) {
                    schiff.setZustand(schiff.getZustand() * 0.92);
                    switch (schiff.getClass().getSimpleName()) {
                        case "Frachtschiff":
                            kontostand += Definitions.FRACHTSCHIFFGEWINN;
                            if (schiff.getZustand() < 25) {
                                schiff.setDefekt(true);
                                kontostand -= 5 * Definitions.FRACHTSCHIFFPREIS;
                            }
                            break;
                        case "Tankschiff":
                            kontostand += Definitions.TANKSCHIFFGEWINN;
                            if (schiff.getZustand() < 25) {
                                schiff.setDefekt(true);
                                kontostand -= 5 * Definitions.TANKSCHIFFPREIS;
                            }
                            break;
                        case "Passagierschiff":
                            kontostand += Definitions.PASSAGIERSCHIFFGEWINN;
                            if (schiff.getZustand() < 25) {
                                schiff.setDefekt(true);
                                kontostand -= 5 * Definitions.PASSAGIERSCHIFFPREIS;
                            }
                            break;
                    }
                }
            }
            if (kontostand > 0) {
                meineKassa.setKontostand(kontostand);
            } else {
                throw new KonkursException();
            }
        }
    }

    public void zustandAusgeben() {
        for (Schiff schiff : meineSchiffe) {
            if (schiff.isDefekt()) {
                InOut.printString(schiff.getClass().getSimpleName() + " Kennzeichen: " + schiff.getKennzeichen() + ", Zustand: DEFEKT");
            } else {
                System.out.printf("%s Kennzeichen: %s , Zustand: %.0f%n", schiff.getClass().getSimpleName(), schiff.getKennzeichen(), schiff.getZustand());
            }
        }
        System.out.printf("Kontostand: %.2f Mio EUR%n\n", meineKassa.getKontostand());
    }

    public void hinzufuegen(Schiff e) throws KonkursException {
        double kontostand = meineKassa.getKontostand();
        kontostand -= e.getPreis();
        meineSchiffe.add(e);
        if (kontostand > 0) {
            meineKassa.setKontostand(kontostand);
        } else {
            throw new KonkursException();
        }
    }

    public void streichen(int eingabe) throws KonkursException {
        double kontostand = meineKassa.getKontostand();
        boolean found = false;
        for (Schiff schiff : meineSchiffe) {
            if (schiff.getKennzeichen() == eingabe) {
                int reparaturen = schiff.getReparaturen();
                schiff.setZustand(100 - (reparaturen * 5));
                reparaturen++;
                found = true;
                switch (schiff.getClass().getSimpleName()) {
                    case "Frachtschiff":
                        kontostand -= 1;
                        break;
                    case "Tankschiff":
                        kontostand -= 3;
                        break;
                    case "Passagierschiff":
                        kontostand -= 5;
                        break;
                }
                schiff.setReparaturen(reparaturen);
            }
        }
        if (!found) {
            InOut.printString("Vorgang abgebrochen.");
            InOut.printString("Kein Schiff mit diesem Kennzeichen verfügbar.");
        } else {
            InOut.printString("Schiff mit dem Kennzeichen " + eingabe + "wurde gestrichen.");
        }
        found = false;
        if (kontostand > 0) {
            meineKassa.setKontostand(kontostand);
        } else {
            throw new KonkursException();
        }
    }

    public void verschrotten(int eingabe) throws KonkursException {
        double kontostand = meineKassa.getKontostand();
        boolean found = false;
        for (Schiff schiff : meineSchiffe) {
            if (schiff.getKennzeichen() == eingabe) {
                found = true;
                switch (schiff.getClass().getSimpleName()) {
                    case "Frachtschiff":
                        kontostand -= 0.1 * Definitions.FRACHTSCHIFFPREIS;
                        schiff.setDefekt(true);
                        break;
                    case "Tankschiff":
                        kontostand -= 0.1 * Definitions.TANKSCHIFFPREIS;
                        schiff.setDefekt(true);
                        break;
                    case "Passagierschiff":
                        kontostand -= 0.1 * Definitions.PASSAGIERSCHIFFPREIS;
                        schiff.setDefekt(true);
                        break;
                }
            }
        }
        if (!found) {
            InOut.printString("Vorgang abgebrochen.");
            InOut.printString("Kein Schiff mit diesem Kennzeichen verfügbar.");
        } else {
            InOut.printString("Schiff mit dem Kennzeichen " + eingabe + "wurde verschrottet.");
        }
        if (kontostand > 0) {
            meineKassa.setKontostand(kontostand);
        } else {
            throw new KonkursException();
        }
    }
}
