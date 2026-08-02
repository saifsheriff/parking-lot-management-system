/*
 * This JavaFX controller manages the Vehicle input form.
 * It handles adding vehicle information (plate number and type),
 * provides user feedback, and allows navigation to the Exit page.
 */

package pls;

// Import necessary JavaFX and utility classes
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import database.database; // Custom class for initializing database connection
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class VehicleController {

    // UI components from the FXML file
    @FXML
    private TextField plateField;   // Input field for the vehicle's plate number

    @FXML
    private TextField typeField;    // Input field for the vehicle's type (e.g., car, truck)

    @FXML
    private Label resultLabel;      // Label to display result messages (success or error)

    // Initialize a connection to the database (though unused in this controller currently)
    Connection con = database.init();

    // Method called when the "Add Vehicle" button is clicked
    @FXML
    private void handleAddVehicle() {
        // Get user input from the text fields
        String plate = plateField.getText();
        String type = typeField.getText();

        // Input validation: ensure both fields are not empty
        if (plate == null || plate.isEmpty() || type == null || type.isEmpty()) {
            resultLabel.setText("Please enter both plate number and vehicle type.");
            resultLabel.setStyle("-fx-text-fill: red;"); // Set message color to red for error
        } else {
            // Show success message with entered values
            resultLabel.setText("Vehicle added: Plate = " + plate + ", Type = " + type);
            resultLabel.setStyle("-fx-text-fill: green;"); // Set message color to green for success

            // Clear input fields after adding the vehicle
            plateField.clear();
            typeField.clear();
        }
    }

    // Method called when navigating to the Exit page
    @FXML
    private void goToExitPage(ActionEvent event) {
        try {
            // Load the Exit.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("Exit.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Get current stage
            stage.setScene(new Scene(root));   // Set the new scene
            stage.setTitle("Exit Page");       // Set window title
            stage.show();                      // Display the Exit page
        } catch (IOException e) {
            e.printStackTrace(); // Print error to console
            resultLabel.setText("Failed to load Exit page."); // Display error to user
            resultLabel.setStyle("-fx-text-fill: red;"); // Set error message color
        }
    }
}
