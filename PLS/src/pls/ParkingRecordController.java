package pls;

// Import JavaFX and other necessary classes
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import database.database;  // Database utility class (currently unused in this implementation)

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

/**
 * Controller class for managing parking slot selection and vehicle entry.
 * Implements Initializable for setup when FXML is loaded.
 */
public class ParkingRecordController implements Initializable {

    // FXML-injected ComboBox for selecting available parking slots
    @FXML
    private ComboBox<String> emptySlotComboBox;

    // FXML-injected Label for displaying operation results/messages
    @FXML
    private Label resultLabel;

    /**
     * Initializes the controller after FXML loading is complete.
     * Populates the slot selection ComboBox with available parking slots.
     * 
     * @param location The location used to resolve relative paths for the root object
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Clear any existing items and populate with available slot options
        emptySlotComboBox.getItems().clear();
        emptySlotComboBox.getItems().addAll("A1", "A2", "B1", "B2", "C1", "C2");
    }

    /**
     * Handles the vehicle entry action when a slot is selected.
     * Validates selection and navigates to vehicle details screen.
     * 
     * @param event The ActionEvent triggered by the button click
     */
    @FXML
    private void handleEntry(ActionEvent event) {
        // Get the selected slot from the ComboBox
        String selectedSlot = emptySlotComboBox.getValue();

        // Validate that a slot was selected
        if (selectedSlot == null || selectedSlot.isEmpty()) {
            resultLabel.setText("Please select an empty slot");
            return;  // Exit if no slot is selected
        }

        // In a real implementation, this would update the database
        // Currently just confirms selection to the user
        resultLabel.setText("Slot " + selectedSlot + " selected");

        try {
            // Load the Vehicle details screen
            Parent root = FXMLLoader.load(getClass().getResource("Vehicle.fxml"));
            
            // Get the current stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            // Set the new scene and window title
            stage.setScene(new Scene(root));
            stage.setTitle("Vehicle Details");
            stage.show();
        } catch (IOException e) {
            // Handle failure to load the next screen
            resultLabel.setText("Failed to load Vehicle page");
            e.printStackTrace();  // Log the error for debugging
        }
    }
}