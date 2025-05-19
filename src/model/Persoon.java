package model;

/**
 * @author Vincent Velthuizen
 * Dit is een persoon die op een manier betrokken is bij ons bedrijf.
 */
public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";

    private static int aantalPersonen;

    private int personeelsnummer;
    private String naam;
    private String woonplaats;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.getNaam(), this.woonplaats, this.afdeling);
    }

    public static int getAantalPersonen() {
        return aantalPersonen;
    }

    public String getNaam() {
        if (naam == null || naam.isEmpty()) {
            return "geen naam";
        }
        return naam;
    }
}
