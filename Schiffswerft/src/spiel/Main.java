package spiel;

import inout.InOut;
import inout.InOutException;
import spiel.SpielendeException;
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
                                "Ein Schiff verschrotte@" +
                                "Nichts tun@" +
                                "Spielende");
                switch (auswahl) {
                    case 1 ->// ein Frachtschiff bauen
                    {
                        // TODO ein Frachtschiff bauen
                    }
                    case 2 -> // ein Passagierschiff bauen
                    {
                        // TODO ein Passagierschiff bauen
                    }
                    case 3 -> // ein Tankschiff bauen
                    {
                        // TODO ein Tankschiff bauen
                    }
                    case 4 -> // ein Schiff streichen
                    {
                        // TODO ein Schiff streichen
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
        } // catch (KonkursException x) {
        //  InOut.printString("Spielende wegen Konkurs");
        // }
    }
}