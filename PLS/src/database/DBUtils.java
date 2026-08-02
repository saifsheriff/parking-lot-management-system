
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {

    /**
     * Inserts a new user into the 'users' table in the database.
     * @param username the username to insert
     * @param password the password to insert
     * @param email the email to insert
     * @return true if insertion is successful, false otherwise
     */
    public static boolean insertUser(String username, String password, String email) {
        // Establish a connection using the database utility class
        Connection con = database.init();

        // SQL statement with placeholders for safe value insertion
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

        try {
            // Create a PreparedStatement to securely execute the SQL with parameters
            PreparedStatement stmt = con.prepareStatement(sql);

            // Set the parameters for the placeholders
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            // Execute the insert operation
            stmt.executeUpdate();

            // If we reach here, insertion was successful
            return true;
        } catch (SQLException e) {
            // Print error stack trace for debugging
            e.printStackTrace();
            return false;
        } finally {
            // Always close the connection to free resources
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                // Log any errors that occur while closing the connection
                e.printStackTrace();
            }
        }
    }
}
