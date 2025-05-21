package model;

/**
 * @author Vincent Velthuizen
 * Beschrijft iemand die wel werkt voor ons, maar niet betaald wordt
 */
public class Vrijwilliger extends Persoon implements Oproepbaar {
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        this.urenGewerkt = 0;
    }

    @Override
    public double berekenJaarinkomen() {
        return 0;
    }

    @Override
    public void huurIn(int uren) {
        this.urenGewerkt += uren;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }
}
