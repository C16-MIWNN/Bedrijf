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

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Afdeling andereAfdeling)) {
            return false;
        }

        return this.afdelingsnaam.equals(andereAfdeling.afdelingsnaam);
    }

    @Override
    public int hashCode() {
        return afdelingsnaam.hashCode();
    }

    @Override
    public String toString() {
        return String.format("afdeling %s te %s", this.afdelingsnaam, this.afdelingsplaats);
    }

    public String alternativeString() {
        return String.format("%s te %s", this.afdelingsnaam, this.afdelingsplaats);
    }

    public String getAfdelingsnaam() {
        return afdelingsnaam;
    }
}
