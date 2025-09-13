package spiel;

import definitions.Definitions;
import schiffe.Frachtschiff;
import schiffe.Passagierschiff;
import schiffe.Schiff;
import schiffe.Tankschiff;
import inout.InOut;
import inout.InOutException;
import werft.Kassa;
import werft.KonkursException;
import werft.Werft;

public class Main {
    public static void main(String[] args) {
        Werft dieWerft = new Werft();
        Kassa meineKassa = new Kassa();
        // Ablauf Monat für Monat
        try {
            while (true) {
                // Werft arbeitet einen Monat
                meineKassa.setKontostand(dieWerft.arbeitetEinenMonat(meineKassa.getKontostand()));
                // Ausgabe: Zustand der Werft
                dieWerft.zustandAusgeben(meineKassa.getKontostand());
                // Auswahl
                int auswahl = InOut.readMenu("Was ist zu tun?",
                        "Ein Frachtschiff bauen@" +
                                "Ein Passagierschiff bauen@" +
                                "Ein Tankschiff bauen@" +
                                "Ein Schiff streichen@" +
                                "Ein Schiff verschrotten@" +
                                "Nichts tun@" +
                                "Spielende");
                switch (auswahl) {
                    case 1 ->// ein Frachtschiff bauen
                    {
                        Schiff frachtschiff = new Frachtschiff();
                        if (frachtschiff.getPreis() > meineKassa.getKontostand()) {
                            throw new KonkursException();
                        } else {
                            meineKassa.abziehen(frachtschiff.getPreis());
                            dieWerft.hinzufuegen(frachtschiff);
                        }

                    }
                    case 2 -> // ein Passagierschiff bauen
                    {
                        Schiff passagierschiff = new Passagierschiff();
                        if (passagierschiff.getPreis() > meineKassa.getKontostand()) {
                            throw new KonkursException();
                        } else {
                            meineKassa.abziehen(passagierschiff.getPreis());
                            dieWerft.hinzufuegen(passagierschiff);
                        }

                    }
                    case 3 -> // ein Tankschiff bauen
                    {
                        Schiff tankschiff = new Tankschiff();
                        if (tankschiff.getPreis() > meineKassa.getKontostand()) {
                            throw new KonkursException();
                        } else {
                            meineKassa.abziehen(tankschiff.getPreis());
                            dieWerft.hinzufuegen(tankschiff);
                        }

                    }
                    case 4 -> // ein Schiff streichen
                    {
                        int eingabe = InOut.readInt("Kennzeichen von Schiff eingeben.");
                        dieWerft.streichen(eingabe);
                    }
                    case 5 -> // ein Schiff verschrotten
                    {
                        // TODO ein  Schiff verschrotten
                    }
                    case 6 -> // Pause
                    {
                        InOut.printString("Pause");
                    }
                    case 7 -> // Spielende
                    {
                        throw new SpielendeException();
                    }
                    default -> {
                        InOut.printString("Unknown menu entry!");
                    }
                }
            }
        } catch (InOutException x) {
            InOut.printString("Fehleingabe, Spielende");
        } catch (SpielendeException x) {
            InOut.printString("Spielende");
        } catch (KonkursException e) {
            InOut.printString("---KONKURS---");
            InOut.printString("Spiel Beendet");
        }
    }
}