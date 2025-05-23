package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vincent Velthuizen
 */
public class AfdelingDAO {
    private final DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO Afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, afdeling.getAfdelingsnaam());
            preparedStatement.setString(2, afdeling.getAfdelingsplaats());

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public ArrayList<Afdeling> geefAfdelingen() {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam, afdelingsplaats FROM Afdeling;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsnaam = resultSet.getString("afdelingsnaam");
                String afdelingsplaats = resultSet.getString("afdelingsplaats");

                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

        return afdelingen;
    }

    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String afdelingsplaats) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        String sql = "SELECT afdelingsnaam FROM Afdeling WHERE afdelingsplaats = ?;";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, afdelingsplaats);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String afdelingsnaam = resultSet.getString("afdelingsnaam");

                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

        return afdelingen;
    }
}
