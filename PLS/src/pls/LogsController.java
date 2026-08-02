/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pls;

// Import necessary JavaFX classes
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the Logs view that displays system activity logs in a table format.
 * Implements Initializable to perform setup when the FXML is loaded.
 */
public class LogsController implements Initializable {

    // FXML-injected TableView to display the logs
    @FXML
    private TableView<Logs> logsTableView;

    // Column for displaying timestamp information
    @FXML
    private TableColumn<Logs, String> timestampColumn;

    // Column for displaying activity descriptions
    @FXML
    private TableColumn<Logs, String> activityColumn;

    // ObservableList to hold and manage the log data for the TableView
    private final ObservableList<Logs> logsData = FXCollections.observableArrayList();

    /**
     * Initializes the controller after FXML loading is complete.
     * Sets up table columns and populates with sample data.
     * 
     * @param location The location used to resolve relative paths for the root object
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configure the timestamp column to display the 'timestamp' property of Logs objects
        timestampColumn.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        
        // Configure the activity column to display the 'activity' property of Logs objects
        activityColumn.setCellValueFactory(new PropertyValueFactory<>("activity"));

        // Add sample log entries to demonstrate the table functionality
        // In a real application, these would come from a database or log file
        logsData.add(new Logs("2025-05-28 10:00", "Vehicle entered: ABC-1234"));
        logsData.add(new Logs("2025-05-28 11:30", "Vehicle exited: XYZ-5678"));

        // Connect the observable list to the TableView
        logsTableView.setItems(logsData);
    }
}