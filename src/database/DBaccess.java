package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Vincent Velthuizen
 * Purpose for the class
 */
public class DBaccess {
    private Connection connection = null;

    private String connectionUrl;
    private Properties properties;

    public DBaccess(String database, String username, String password) {

        // connection should only be set when it is open.
        System.err.print("Driver laden ...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.err.println(" Driver geladen");

            connectionUrl = "jdbc:mysql://localhost:3306/" + database;

            properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
        }  catch (ClassNotFoundException classNotFoundException) {
            System.err.println(" Laden van de MySQL driver is niet gelukt.");
        }
    }

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl, properties);
            System.err.println("OK, Connection open!");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.err.println("Connection is closed!");
            } catch (SQLException sqlException) {
                System.err.println("SQL Exception: " + sqlException.getMessage());
            }
            connection = null;
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            openConnection();
        }
        return connection;
    }
}
