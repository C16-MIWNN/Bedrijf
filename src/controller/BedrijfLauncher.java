package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen
 * Runt ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.getAantalPersonen());

        Persoon baas = new Persoon("Mark", "Den Haag", 10000);

        System.out.println(Persoon.getAantalPersonen());
        System.out.println(baas.getPersoneelsnummer());

        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);

        System.out.println(Persoon.getAantalPersonen());
        System.out.println(medewerker.getPersoneelsnummer());

        Persoon assistent = new Persoon("Klaas");
        Persoon manager = new Persoon();

        System.out.println(Persoon.getAantalPersonen());

        System.out.printf("%s verdient %.2f per jaar en heeft %s recht op een bonus.\n", baas.getNaam(), baas.berekenJaarinkomen(), baas.heeftRechtOpBonus() ? "wel" : "geen");
        System.out.printf("%s verdient %.2f per jaar en heeft %s recht op een bonus.\n", medewerker.getNaam(), medewerker.berekenJaarinkomen(), medewerker.heeftRechtOpBonus() ? "wel" : "geen");
    }
}
