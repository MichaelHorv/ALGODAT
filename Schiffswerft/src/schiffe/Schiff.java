package schiffe;

public abstract class Schiff {
    public double getPreis;
    protected int kennzeichen;
    protected static int kennzeichenAlt;
    protected double preis;
    protected double zustand = 100;
    protected int reparaturen = 1;
    protected boolean defekt;

    public void setDefekt(boolean defekt) {
        this.defekt = defekt;
    }

    public boolean isDefekt() {
        return defekt;
    }

    public Schiff() {
        this.kennzeichen = kennzeichenAlt++;
    }

    public int getKennzeichen() {
        return kennzeichen;
    }

    public double getZustand() {
        return zustand;
    }

    public void setZustand(double zustand) {
        this.zustand = zustand;
    }

    public double getPreis() {
        return preis;
    }

    public int getReparaturen() {
        return reparaturen;
    }

    public void setReparaturen(int reparaturen) {
        this.reparaturen = reparaturen;
    }
}
