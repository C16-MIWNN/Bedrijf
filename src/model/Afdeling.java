package model;

/**
 * @author Vincent Velthuizen
 * Een afdeling binnen ons bedrijf, verantwoordelijk voor bepaalde taken
 */
public class Afdeling {
    private static final String DEFAULT_AFDELINGSNAAM = "Onbekend";
    private static final String DEFAULT_AFDELINGSPLAATS = "Onbekend";

    private String afdelingsnaam;
    private String afdelingsplaats;

    public Afdeling(String afdelingsnaam, String afdelingsplaats) {
        this.afdelingsnaam = afdelingsnaam;
        this.afdelingsplaats = afdelingsplaats;
    }

    public Afdeling() {
        this(DEFAULT_AFDELINGSNAAM, DEFAULT_AFDELINGSPLAATS);
    }

    public String getAfdelingsnaam() {
        return afdelingsnaam;
    }

    public String getAfdelingsplaats() {
        return afdelingsplaats;
    }
}
