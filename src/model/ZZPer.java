package model;

/**
 * @author Vincent Velthuizen
 * Beschrijft mensen die extern door ons bedrijf worden ingehuurd
 */
public class ZZPer extends Persoon {
    private double uurtarief;
    private int urenGewerkt;

    public ZZPer(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = 0;
    }

    public void huurIn(int uren) {
        this.urenGewerkt += uren;
    }

    @Override
    public double berekenJaarinkomen() {
        return urenGewerkt * uurtarief;
    }

    @Override
    public String toString() {
        return String.format("%s en is een ZZP-er met een uurtarief van %.2f", super.toString(), this.uurtarief);
    }
}
