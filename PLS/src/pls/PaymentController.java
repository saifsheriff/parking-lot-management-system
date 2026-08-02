/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pls;

// Import necessary JavaFX classes
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for handling payment processing in the parking system.
 * Manages payment method selection and processes payment transactions.
 */
public class PaymentController implements Initializable {

    // FXML-injected ComboBox for payment method selection
    @FXML
    private ComboBox<String> paymentMethodComboBox;

    // FXML-injected Label for displaying payment status/result
    @FXML
    private Label paymentStatusLabel;

    // FXML-injected Label for displaying the payment amount
    @FXML
    private Label amountLabel;

    // The payment amount (default value set, can be changed dynamically)
    private double amount = 99.99;

    /**
     * Initializes the controller after FXML loading is complete.
     * Sets up payment method options and displays the initial amount.
     * 
     * @param location The location used to resolve relative paths
     * @param resources The resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize payment method options
        paymentMethodComboBox.setItems(FXCollections.observableArrayList(
            "Cash", "Visa", "Mastercard"));
        
        // Update the amount display
        updateAmountLabel();
    }

    /**
     * Sets the payment amount and updates the display.
     * 
     * @param amount The payment amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
        updateAmountLabel();
    }

    /**
     * Updates the amount label with the current payment amount.
     */
    private void updateAmountLabel() {
        if (amountLabel != null) {
            amountLabel.setText("Amount: $" + amount);
        }
    }

    /**
     * Handles the payment process when the pay button is clicked.
     * Validates payment method selection and processes the payment.
     * 
     * @param event The ActionEvent triggered by the button click
     */
    @FXML
    private void handlePayment(ActionEvent event) {
        // Get selected payment method
        String method = paymentMethodComboBox.getValue();

        // Validate that a payment method was selected
        if (method == null || method.trim().isEmpty()) {
            paymentStatusLabel.setText("Please select a payment method.");
            return;
        }

        // Simulate successful payment processing
        // In a real implementation, this would interface with a payment gateway
        paymentStatusLabel.setText("Payment of $" + amount + " via " + method + " was successful!");
    }
}