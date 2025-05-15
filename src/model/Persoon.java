package model;

/**
 * @author Vincent Velthuizen
 * Dit is een persoon die op een manier betrokken is bij ons bedrijf.
 */
public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_MAANDSALARIS = 0;

    private static final double GRENSWAARDE_BONUS = 4500.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private static int aantalPersonen;

    private int personeelsnummer;
    private String naam;
    private String woonplaats;
    private double maandsalaris;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, double maandsalaris, Afdeling afdeling) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandsalaris(maandsalaris);
        this.afdeling = afdeling;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAANDSALARIS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return MAANDEN_PER_JAAR * maandsalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    public static int getAantalPersonen() {
        return aantalPersonen;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public double getMaandsalaris() {
        return maandsalaris;
    }

    public void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            System.err.println("Het maandsalaris mag niet negatief zijn.");
            maandsalaris = DEFAULT_MAANDSALARIS;
        }

        this.maandsalaris = maandsalaris;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }
}
