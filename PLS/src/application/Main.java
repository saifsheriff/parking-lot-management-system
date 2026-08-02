
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    // first stage for the application (main window)
    private static Stage primaryStage;

    // Logger for logging info, warnings, and errors
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    
    static {
        // Set log message format to include timestamp, log level, and message
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$s] %5$s %n");
    }

    // Called automatically when the application is launched
    @Override
    public void start(Stage stage) {
        primaryStage = stage; // Store reference to the main window
        showMainPage();       // Load the main dashboard scene initially
    }

    /**
     * Loads the FXML file and sets it as the active scene.
     *  fxmlPath the path to the FXML file
     *  title the window title to display
     */
    private static void loadScene(String fxmlPath, String title) {
        try {
            LOGGER.log(Level.INFO, "Loading FXML: {0}", fxmlPath); // Log the scene being loaded

            // Load the FXML layout file
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Parent root = loader.load();

            // first step and title for the primary stage
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(root));
            primaryStage.show(); // Display the gui
        } catch (IOException e) {
            // Handle errors during FXML loading
            LOGGER.log(Level.SEVERE, "Failed to load FXML: " + fxmlPath, e);
            e.printStackTrace();
        } catch (Exception e) {
            // Handle any other unexpected errors
            LOGGER.log(Level.SEVERE, "Unexpected error loading: " + fxmlPath, e);
            e.printStackTrace();
        }
    }

    // Method to load the Main Dashboard
    public static void showMainPage() {
        loadScene("/application/Main.fxml", "Main Dashboard");
    }

    // Method to load the Admin Login
    public static void showAdminLogin() {
        loadScene("/pls/Admin.fxml", "Admin Login");
    }

    // Method to load the User Login
    public static void showUserLogin() {
        loadScene("/pls/User.fxml", "User Login");
    }

    // Method to load the Parking Entry
    public static void showEntry() {
        loadScene("/pls/ParkingRecord.fxml", "Vehicle Entry");
    }

    // Method to close the application window (used for logout)
    public static void logout() {
        if (primaryStage != null) {
            primaryStage.close(); // Close the page
        }
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args); // Calls the start() method
    }
}
