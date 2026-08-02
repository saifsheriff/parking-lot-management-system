/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pls;

// Import necessary JavaFX classes
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

/**
 * Controller class for managing parking slot status updates.
 * Handles UI interactions for updating parking slot occupancy status.
 */
public class ParkingSlotController {

    // FXML-injected TextField for entering slot ID
    @FXML 
    private TextField slotIdField;

    // FXML-injected TextField for entering new status
    @FXML 
    private TextField statusField;

    // FXML-injected Label for displaying operation results
    @FXML 
    private Label resultLabel;

    /**
     * Handles the status update action triggered by the update button.
     * Validates input, simulates status update, and navigates to Vehicle page.
     *
     * @param event The ActionEvent triggered by the button click
     */
    @FXML
    private void handleStatusUpdate(ActionEvent event) {
        // Get user input from text fields
        String slotId = slotIdField.getText().trim();
        String status = statusField.getText().trim();

        // Validate that both fields are filled
        if (slotId.isEmpty() || status.isEmpty()) {
            resultLabel.setText("Please fill in all fields.");
            return; // Exit if validation fails
        }

        // Simulate updating slot status (in real app would update database)
        resultLabel.setText("Slot " + slotId + " updated to: " + status);

        // Navigate to Vehicle management screen
        try {
            // Load the Vehicle.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("Vehicle.fxml"));
            
            // Get the current stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set up and show the new scene
            stage.setScene(new Scene(root));
            stage.setTitle("Vehicle Page");
            stage.show();
            
        } catch (IOException e) {
            // Handle errors during scene transition
            e.printStackTrace();
            resultLabel.setText("Error loading Vehicle page.");
        }
    }
}