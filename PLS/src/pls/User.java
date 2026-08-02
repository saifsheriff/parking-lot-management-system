/*
 * This is a simple Java class (a POJO - Plain Old Java Object) that represents a User entity.
 * It includes basic attributes like id, name, and email, along with getter and setter methods.
 */

package pls;

public class User {
    
    // Private fields to store user information (encapsulation principle)
    private int id;
    private String name;
    private String email;

    // Constructor to initialize a User object with given values
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getter for 'id' - returns the user's ID
    public int getId() {
        return id;
    }

    // Setter for 'id' - sets the user's ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for 'name' - returns the user's name
    public String getName() {
        return name;
    }

    // Setter for 'name' - sets the user's name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'email' - returns the user's email address
    public String getEmail() {
        return email;
    }

    // Setter for 'email' - sets the user's email address
    public void setEmail(String email) {
        this.email = email;
    }
}
