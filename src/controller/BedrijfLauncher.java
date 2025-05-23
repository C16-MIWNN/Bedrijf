package controller;

import database.AfdelingDAO;
import database.DBaccess;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Runt ons bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");

        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);

        afdelingDAO.slaAfdelingOp(new Afdeling("HR2", "Hilversum"));
        dBaccess.closeConnection();

        afdelingDAO.slaAfdelingOp(new Afdeling("HR3", "Hilversum"));
        dBaccess.closeConnection();

    }

    private static void schrijfPersonenPerAfdeling(String bestandsnaam,
                                                   ArrayList<Afdeling> afdelingen,
                                                   ArrayList<Persoon> personen) {
        try (PrintWriter personenPerAfdelingSchrijver = new PrintWriter(bestandsnaam)) {
            for (Afdeling afdeling : afdelingen) {
                personenPerAfdelingSchrijver.printf("Afdeling: %s\n", afdeling.getAfdelingsnaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        personenPerAfdelingSchrijver.printf("-- %s\n", persoon);
                    }
                }

                personenPerAfdelingSchrijver.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Het is niet gelukt het Personen per Afdeling bestand te openen.");
        }
    }

    private static ArrayList<Persoon> leesPersonenIn(String bestandsnaam, ArrayList<Afdeling> afdelingen) {
        ArrayList<Persoon> personen = new ArrayList<>();

        try (Scanner personenLezer = new Scanner(new File(bestandsnaam))) {
            while (personenLezer.hasNextLine()) {
                String[] persoon = personenLezer.nextLine().split(",");

                String type = persoon[0];
                String naam = persoon[1];
                String woonplaats = persoon[2];
                int afdelingsindex = Integer.parseInt(persoon[3]);

                switch (type) {
                    case "Werknemer":
                        double maandsalaris = Double.parseDouble(persoon[4]);
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsindex), maandsalaris));
                        break;
                    case "Zzper":
                        double uurtarief = Double.parseDouble(persoon[4]);
                        personen.add(new ZZPer(naam, woonplaats, afdelingen.get(afdelingsindex), uurtarief));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsindex)));
                        break;
                    default:
                        System.err.printf("Een persoon van onbekend type tegengekomen (type: %s), " +
                                "deze persoon genegeerd.",
                                type);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Het is niet gelukt het personenbestand te openen.");
        }

        return personen;
    }

    private static ArrayList<Afdeling> leesAfdelingenIn(String bestandsnaam) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        try (Scanner afdelingLezer = new Scanner(new File(bestandsnaam))) {
            while (afdelingLezer.hasNextLine()) {
                String afdelingsnaam = afdelingLezer.nextLine();
                String afdelingsplaats = afdelingLezer.nextLine();

                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Het is niet gelukt het afdelingenbestand te openen.");
        }

        return afdelingen;
    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }


}
