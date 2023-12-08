package main.java.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Justin Knight
 * @author Ivan Paez
 *
 * The User class represents a user with a username, password, and a flag indicating whether the user is a seller.
 * It implements the Serializable interface to support object serialization.
 */
public class User implements Serializable {

    // User attributes
    private String username;
    private String password; // In a real application, passwords should be securely hashed
    private boolean isSeller;

    /**
     * Constructs a User object with the specified username, password, and seller status.
     *
     * @param username The username of the user
     * @param password The password of the user (in a real application, should be securely hashed)
     * @param isSeller A flag indicating whether the user is a seller
     */
    public User(String username, String password, boolean isSeller) {
        this.username = username;
        this.password = password;
        this.isSeller = isSeller;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks whether the user is a seller.
     *
     * @return true if the user is a seller, false otherwise
     */
    public boolean isSeller() {
        return isSeller;
    }

    /**
     * Sets the seller status of the user.
     *
     * @param isSeller A flag indicating whether the user is a seller
     */
    public void setSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }

    /**
     * Overrides the equals method to compare two User objects based on username and password.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Make sure the object is of the same class so that class methods can be used
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // Check that username and password match
        User obj2 = (User) obj;
        return Objects.equals(getUsername(), obj2.getUsername()) && Objects.equals(getPassword(), obj2.getPassword());
    }

    /**
     * Overrides the toString method to provide a string representation of the User object.
     *
     * @return A string representation of the User object
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", isSeller=" + isSeller + '}';
    }
}
