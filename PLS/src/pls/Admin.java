package pls;

public class Admin {
    // Private fields to store admin credentials
    private String username;
    private String password;

    /**
     * Constructor to initialize an Admin object with username and password.
     * username the admin's username
     * password the admin's password
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*
     * Getter for the username.
     * @return the admin's username
     */
    public String getUsername() {
        return username;
    }

    /*
     * Setter for the username.
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*
     * Getter for the password.
     * @return the admin's password
     */
    public String getPassword() {
        return password;
    }

    /*
     * Setter for the password.
     * @param password the new password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
