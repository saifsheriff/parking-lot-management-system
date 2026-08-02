/*
 * Controller class for the Admin Dashboard UI in the Parking Lot System.
 * Responsible for loading slot statistics and handling navigation to other scenes.
 */

package pls;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    // Labels in the FXML that display slot statistics
    @FXML private Label totalSlots;
    @FXML private Label occupiedSlots;
    @FXML private Label availableSlots;

    // Database connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/parkinglots";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    /**
     * Called automatically when the dashboard view is loaded.
     * Triggers loading of parking slot statistics from the database.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSlotStats();
    }

    /**
     * Loads total, occupied, and available parking slots from the database.
     * Updates the labels on the UI with the retrieved data.
     */
    private void loadSlotStats() {
        int total = 0, occupied = 0;

        try (
            // Establish a database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            // Create a statement for executing SQL queries
            Statement stmt = conn.createStatement();
            // Execute a query to count total and occupied slots
            ResultSet rs = stmt.executeQuery(
                "SELECT COUNT(*) AS total, " +
                "SUM(CASE WHEN status = 'occupied' THEN 1 ELSE 0 END) AS occupied " +
                "FROM parking_slots")
        ) {
            if (rs.next()) {
                total = rs.getInt("total");         // Total slots
                occupied = rs.getInt("occupied");   // Occupied slots
            }

            int available = total - occupied;       // Calculate available slots

            // Update UI labels with fetched data
            totalSlots.setText(String.valueOf(total));
            occupiedSlots.setText(String.valueOf(occupied));
            availableSlots.setText(String.valueOf(available));

        } catch (SQLException e) {
            // Print error and show default values in case of failure
            e.printStackTrace();
            totalSlots.setText("200");
            occupiedSlots.setText("120");
            availableSlots.setText("80");
        }
    }

    /**
     * Handles the "Reports" button click and navigates to the Logs view.
     */
    @FXML
    private void handleGoToReports(ActionEvent event) {
        switchScene(event, "/pls/Logs.fxml");
    }

    /**
     * Handles the "Manage Parking" button click and navigates to the ParkingSlot view.
     */
    @FXML
    private void handleGoToParkingManagement(ActionEvent event) {
        switchScene(event, "/pls/ParkingSlot.fxml");
    }

    /**
     * Utility method to switch between different FXML scenes.
     *
     * @param event the triggering event (e.g., button click)
     * @param fxmlPath the path to the target FXML file
     */
    private void switchScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene newScene = new Scene(root);

            // Get the current stage from the triggering event
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.setTitle("Parking System");
            stage.show();
        } catch (IOException e) {
            // Handle failure to load the target scene
            e.printStackTrace();
        }
    }
}
