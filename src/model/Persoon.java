package model;

/**
 * @author Vincent Velthuizen
 * Dit is een persoon die op een manier betrokken is bij ons bedrijf.
 */
public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_MAANDSALARIS = 0;

    public static int aantalPersonen;

    public int personeelsnummer;
    public String naam;
    public String woonplaats;
    public double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandsalaris = maandsalaris;
    }

    public Persoon(String naam) {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = naam;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandsalaris = DEFAULT_MAANDSALARIS;
    }

    public Persoon() {
        this.personeelsnummer = ++aantalPersonen;
        this.naam = DEFAULT_NAAM;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandsalaris = DEFAULT_MAANDSALARIS;
    }


}
