/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pls;

/**
 * Represents a user registration record in the system.
 * Stores user credentials including ID, username, email, and password.
 * Note: In a production system, passwords should be hashed and not stored as plain text.
 */
public class Register {
    // Unique identifier for the user
    private int id;
    
    // User's chosen username (must be unique)
    private String username;
    
    // User's email address (typically used for account verification and recovery)
    private String email;
    
    // User's password (should be hashed in production)
    private String password;

    /**
     * Constructs a new Register object with user credentials.
     * 
     * @param id Unique user identifier
     * @param username User's chosen username
     * @param email User's email address
     * @param password User's password (should be hashed before storage)
     */
    public Register(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // ========== Getter and Setter Methods ========== //

    /**
     * Gets the user's unique ID.
     * @return The user ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's unique ID.
     * @param id The new user ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user's username.
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     * @param username The new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's email address.
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     * @param email The new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's password.
     * @return The password (plain text - should be hashed in production)
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     * @param password The new password (should be hashed before storage)
     */
    public void setPassword(String password) {
        this.password = password;
    }
}