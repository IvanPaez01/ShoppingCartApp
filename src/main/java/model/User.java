public class User {
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
}
