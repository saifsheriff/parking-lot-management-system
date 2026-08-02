

package pls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;

import database.database;

public class AdminController {

    // UI components from FXML
    @FXML private TextField usernameField;       // TextField for entering username
    @FXML private PasswordField passwordField;   // PasswordField for entering password securely
    @FXML private Label loginStatusLabel;        // Label to show login status (success/failure)

    /*
     * Handles the admin login button action.
     * Authenticates the credentials and loads the dashboard if successful.
     */
    @FXML
    private void handleAdminLogin(ActionEvent event) {
        // Check if entered credentials are valid
        if (authenticateAdmin(usernameField.getText(), passwordField.getText())) {
            // Optionally initialize the database connection
            Connection con = database.init();

            // Load the Admin Dashboard
            loadDashboard();
        } else {
            // Show error message if login fails
            loginStatusLabel.setText("Invalid admin credentials!");
        }
    }

    /*
     * In this example, it checks against hardcoded values.
     * @param username the input username
     * @param password the input password
     * @return true if credentials match, false otherwise
     */
    private boolean authenticateAdmin(String username, String password) {
    
        return "admin".equals(username) && "admin123".equals(password);
    }

    /*
     * Loads the Admin Dashboard scene after successful login.
     */
    private void loadDashboard() {
        try {
            // Load the Dashboard.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage from the username field
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Set the new scene and show it
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } catch (IOException e) {
            // Show error message and log stack trace if loading fails
            loginStatusLabel.setText("Failed to load Dashboard.fxml");
            e.printStackTrace();
        }
    }
}
