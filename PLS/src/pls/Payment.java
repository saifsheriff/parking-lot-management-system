/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pls;

/**
 * Represents a payment transaction in the parking management system.
 * Stores payment details including unique ID, amount, and payment method.
 */
public class Payment {
    // Unique identifier for the payment transaction
    private int paymentId;
    
    // The monetary amount of the payment
    private double amount;
    
    // The payment method used (e.g., "Cash", "Credit Card", "Mobile Payment")
    private String method;

    /**
     * Constructs a new Payment with specified details.
     * 
     * @param paymentId Unique identifier for the payment
     * @param amount The payment amount
     * @param method The payment method used
     */
    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    /**
     * Gets the payment's unique identifier.
     * 
     * @return The payment ID
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment's unique identifier.
     * 
     * @param paymentId The new payment ID to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Gets the payment amount.
     * 
     * @return The amount paid
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the payment amount.
     * 
     * @param amount The new amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the payment method.
     * 
     * @return The payment method used
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the payment method.
     * 
     * @param method The new payment method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }
}