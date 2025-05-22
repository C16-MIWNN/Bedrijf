package model;

/**
 * @author Vincent Velthuizen
 * Beschrijft iemand in loondienst bij ons bedrijf
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.0;
    private static final double DEFAULT_MAANDSALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private double maandsalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandsalaris) {
        super(naam, woonplaats, afdeling);
        setMaandsalaris(maandsalaris);
    }

    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAANDSALARIS);
    }

    public Werknemer() {
        super();
        setMaandsalaris(DEFAULT_MAANDSALARIS);
    }

    @Override
    public double berekenJaarinkomen() {
        double jaarInkomen = MAANDEN_PER_JAAR * maandsalaris;

        if (heeftRechtOpBonus()) {
            jaarInkomen += maandsalaris;
        }

        return jaarInkomen;

        // alternatieve berekening:
//        return MAANDEN_PER_JAAR * maandsalaris + (heeftRechtOpBonus() ? maandsalaris : 0);
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris > GRENSWAARDE_BONUS;
    }

    @Override
    public String toString() {
//        String bonusRecht = heeftRechtOpBonus() ? "met" : "zonder";
        String bonusRecht = "zonder";
        if (heeftRechtOpBonus()) {
            bonusRecht = "met";
        }
        return String.format("%s en is een werknemer %s recht op bonus", super.toString(), bonusRecht);
    }

    public void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn.");
        }
        this.maandsalaris = maandsalaris;
    }
}
