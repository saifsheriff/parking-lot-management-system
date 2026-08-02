
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

   
    private void switchScene(String fxmlPath, ActionEvent event) throws IOException {
        // Load the new screen from the specified FXML file
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));

        // Get the current page from the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set and show the new scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
     * Handles button click to go to the Admin Login screen.
     * @param event the button click event
     * @throws IOException if Admin.fxml can't be loaded
     */
    @FXML
    void goToAdminLogin(ActionEvent event) throws IOException {
        switchScene("/pls/Admin.fxml", event);
    }

    /**
     * Handles button click to go to the User Login screen.
     * @throws IOException if User.fxml can't be loaded
     */
    @FXML
    void goToUserLogin(ActionEvent event) throws IOException {
        switchScene("/pls/User.fxml", event);
    }

    // Handles button click to go to the Vehicle Entry screen.
    @FXML
    void goToEntry(ActionEvent event) {
        try {
            // Load the ParkingRecord.fxml manually
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pls/ParkingRecord.fxml"));
            Parent root = loader.load();

            System.out.println("FXML Loaded successfully"); // Log success

            // Switch to the new screen
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Print detailed error to console
            System.out.println("Failed to load ParkingRecord.fxml"); // Log failure
        }
    }

    // Handles logout by closing the current application window.
    @FXML
    void logout(ActionEvent event) {
        // Close the window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
