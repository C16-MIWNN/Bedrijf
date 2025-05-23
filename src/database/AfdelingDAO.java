package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
