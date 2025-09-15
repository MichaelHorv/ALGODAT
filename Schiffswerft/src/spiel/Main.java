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
        // Ablauf Monat für Monat
        try {
            while (true) {
                // Werft arbeitet einen Monat
                dieWerft.arbeitetEinenMonat();
                // Ausgabe: Zustand der Werft
                dieWerft.zustandAusgeben();
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
                        dieWerft.hinzufuegen(frachtschiff);


                    }
                    case 2 -> // ein Passagierschiff bauen
                    {
                        Schiff passagierschiff = new Passagierschiff();
                        dieWerft.hinzufuegen(passagierschiff);

                    }
                    case 3 -> // ein Tankschiff bauen
                    {
                        Schiff tankschiff = new Tankschiff();
                        dieWerft.hinzufuegen(tankschiff);

                    }
                    case 4 -> // ein Schiff streichen
                    {
                        int eingabe = InOut.readInt("Kennzeichen von Schiff eingeben:");
                        dieWerft.streichen(eingabe);
                    }
                    case 5 -> // ein Schiff verschrotten
                    {
                        int eingabe = InOut.readInt("Kennzeichen von Schiff eingeben:");
                        dieWerft.verschrotten(eingabe);
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
            System.out.printf("Aktueller Kontostand: -%.2f Mio EUR\n", dieWerft.getMeineKassa().getKontostand());
            InOut.printString("Spiel Beendet");
        }
    }
}