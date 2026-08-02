package pls;

// Import necessary JavaFX and utility classes
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.*;
import database.DBUtils; // Custom utility class for database operations

import java.io.IOException;

public class RegisterController {

    // UI elements injected from FXML file
    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label registerStatusLabel;

    // Method triggered when the user clicks the "Register" button
    @FXML
    private void handleRegister(ActionEvent event) {
        // Retrieve user input from the form fields
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Check if any field is empty
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            registerStatusLabel.setText("All fields are required.");
            return; // Stop execution if validation fails
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            registerStatusLabel.setText("Passwords do not match.");
            return; // Stop execution if passwords don't match
        }

        // Save user details to the database using a utility method
        boolean success = DBUtils.insertUser(username, password, email);
        if (!success) {
            registerStatusLabel.setText("Registration failed. Try again.");
            return; // Stop if user couldn't be saved in the database
        }

        // Load Exit.fxml after successful registration
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Exit.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Exit Page");
            stage.show(); // Show Exit page
        } catch (IOException e) {
            e.printStackTrace();
            registerStatusLabel.setText("Failed to load Exit page."); // Handle loading error
        }
    }

    // Method triggered when the user clicks a link or button to go to the login page
    @FXML
    private void goToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("User.fxml")); // Load login page
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("User Login");
            stage.show(); // Show login page
        } catch (IOException e) {
            e.printStackTrace();
            registerStatusLabel.setText("Failed to load Login page."); // Handle loading error
        }
    }
}
