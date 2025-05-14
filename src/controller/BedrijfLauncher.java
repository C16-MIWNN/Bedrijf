package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen
 * Runt ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);

        Persoon baas = new Persoon("Mark", "Den Haag", 10000);

        System.out.println(Persoon.aantalPersonen);
        System.out.println(baas.personeelsnummer);

        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);

        System.out.println(Persoon.aantalPersonen);
        System.out.println(medewerker.personeelsnummer);

        Persoon assistent = new Persoon("Klaas");
        Persoon manager = new Persoon();

        System.out.println(Persoon.aantalPersonen);

        System.out.printf("%s verdient %.2f per jaar\n", baas.naam, baas.maandsalaris);
    }
}
