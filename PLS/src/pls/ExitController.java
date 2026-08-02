package pls;

// Import necessary JavaFX and Java classes
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Controller class for the exit functionality
public class ExitController {

    // FXML annotation links this field to the TextField in the FXML file
    @FXML
    private TextField vehicleNumberField;

    // FXML annotation links this field to the Label in the FXML file
    @FXML
    private Label exitMessage;

    // Method to handle the exit button action
    @FXML
    private void handleExit(ActionEvent event) {
        // Get the vehicle number from the text field and trim whitespace
        String vehicleNumber = vehicleNumberField.getText().trim();

        // Check if the vehicle number is empty
        if (vehicleNumber.isEmpty()) {
            exitMessage.setText("Please enter a vehicle number.");
            return; // Exit the method if no vehicle number is entered
        }

        // Get the current time for the exit record
        String exitTime = getCurrentTime();

        // Simulate successful exit (in a real app, this would interact with a database)
        exitMessage.setText("Vehicle " + vehicleNumber + " exited at " + exitTime);
        vehicleNumberField.clear(); // Clear the input field

        // Load and display the payment screen
        try {
            // Create a loader for the Payment.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
            Parent root = loader.load(); // Load the FXML file

            // Get the controller for the Payment screen
            PaymentController controller = loader.getController();
            controller.setAmount(49.99); // Set a static amount (would be calculated in real app)

            // Get the current stage from the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Set the new scene with the payment screen
            stage.setScene(new Scene(root));
            stage.setTitle("Payment Page"); // Set the window title
            stage.show(); // Display the new screen

        } catch (IOException e) {
            e.printStackTrace(); // Print error stack trace
            exitMessage.setText("Failed to load Payment page."); // Show error to user
        }
    }

    // Helper method to get the current date and time as a formatted string
    private String getCurrentTime() {
        // Define the date/time format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Get current date/time and format it
        return LocalDateTime.now().format(formatter);
    }
}