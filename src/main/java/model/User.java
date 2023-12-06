package main.java.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{
    private String username;
    private String password; // In a real application, passwords should be securely hashed
    private boolean isSeller;

    public User(String username, String password, boolean isSeller) {
        this.username = username;
        this.password = password;
        this.isSeller = isSeller;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }

    @Override
    public boolean equals(Object obj) {
        // Make sure object is of the same class so that class methods can be used
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        // Check that username and password match
        User obj2 = (User) obj;
        return Objects.equals(getUsername(), obj2.getUsername()) && Objects.equals(getPassword(), obj2.getPassword());
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", isSeller=" + isSeller + '}';
    }
}
