/*
 * This JavaFX controller handles user interactions on the login screen.
 * It provides functionality to:
 * - Validate login form inputs (name and email).
 * - Navigate to the Payment page after login.
 * - Redirect to the registration page if the user doesn't have an account.
 */

package pls;

// Import necessary JavaFX classes for UI interaction
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class UserController {

    // Input fields and status label from the FXML layout
    @FXML private TextField nameField;        // Field for user's name input
    @FXML private TextField emailField;       // Field for user's email input
    @FXML private Label statusLabel;          // Label to show status messages (e.g. errors)

    // Method triggered when the user clicks the "Login" button
    @FXML
    private void handleLogin(ActionEvent event) {
        // Retrieve user input
        String name = nameField.getText();
        String email = emailField.getText();

        // Simple validation: check if fields are filled
        if (name.isEmpty() || email.isEmpty()) {
            statusLabel.setText("Please enter name and email.");
        } else {
            // Attempt to load the Payment page
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Payment.fxml")); // Load Payment.fxml
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get current stage
                stage.setScene(new Scene(root)); // Set new scene
                stage.setTitle("Payment Page"); // Update window title
                stage.show(); // Display the Payment page
            } catch (IOException e) {
                e.printStackTrace(); // Print error to console for debugging
                statusLabel.setText("Failed to load Payment page."); // Display error in the UI
            }
        }
    }

    // Method triggered when the user clicks the "Register" link or button
    @FXML
    private void goToRegister(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml")); // Load Register.fxml
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get current stage
            stage.setScene(new Scene(root)); // Set new scene
            stage.setTitle("User Registration"); // Update window title
            stage.show(); // Display the Register page
        } catch (IOException e) {
            e.printStackTrace(); // Print error to console
            statusLabel.setText("Failed to load Register page."); // Display error in the UI
        }
    }
}
