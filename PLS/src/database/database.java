/*
 * Database connection utility class.
 * Provides a static method to initialize and return a MySQL database connection.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    // Database connection URL (change parkinglots to your actual database name)
    private static final String CONN = "jdbc:mysql://localhost/parkinglots";

    // MySQL username
    private static final String USER = "saiff";

    // MySQL password (make sure this is secure in production)
    private static final String PASSWORD = "Ss2307";

  
    public static Connection init() {
        Connection con = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection using URL, username, and password
            con = DriverManager.getConnection(CONN, USER, PASSWORD);
            System.out.println("Database connected successfully");
        } catch (ClassNotFoundException ex) {
            // Thrown if the JDBC driver is not found
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            // Thrown if connection fails (e.g., wrong credentials, database not running)
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the connection (or null if connection failed)
        return con;
    }
}
