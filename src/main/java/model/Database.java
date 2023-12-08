package main.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;

/**
 *
 * @author Justin Knight
 * The Database class represents the data storage for products and users in the system.
 * It provides methods to manipulate and retrieve data, as well as import/export data to/from files.
 */
public class Database extends Observable {

    // Singleton instance of the Database class
    private static Database data = null;

    // Lists to store product inventory and user information
    private ArrayList<Product> inventory;
    private ArrayList<User> users;

    // The username of the active user in the system
    private String activeUser;

    // Private constructor to enforce the singleton pattern
    private Database() {
        inventory = new ArrayList<>();
        users = new ArrayList<>();
        activeUser = new String();
    }

    /**
     * Gets the singleton instance of the Database class.
     * If the instance does not exist, it creates one and imports existing data.
     *
     * @return The Database instance
     */
    public static Database getInstance() {
        if (data == null) {
            data = new Database();
            data.importData("user");
            data.importData("inventory");
        }
        return data;
    }

    /**
     * Updates the information of a product in the inventory.
     * If the new_name parameter is null, it keeps the original name.
     *
     * @param name    The current name of the product
     * @param new_name The new name for the product (null if no new name)
     * @param price    The new price of the product
     * @param quantity The new quantity of the product
     * @param seller   The username of the seller
     */
    public void updateProduct(String name, String new_name, double price, int quantity, String seller) {
        if (new_name == null) {
            new_name = name;
        }
        for (Product product : data.inventory) {
            if (product.getSeller_ID().equals(seller) && product.getName().equals(name)) {
                product.setName(new_name);
                product.setPrice(price);
                product.setQuantity(quantity);
            }
        }
        notifyObservers();
    }

    /**
     * Adds a new product to the inventory or updates an existing one.
     *
     * @param name     The name of the product
     * @param price    The price of the product
     * @param quantity The quantity of the product
     * @param seller   The seller ID of the product
     */
    public void addProduct(String name, double price, int quantity, String seller) {
        Product product = new Product(name, price, quantity, seller);
        if (!data.inventory.contains(product)) {
            updateProduct(name, null, price, quantity, seller);
        }
        data.inventory.add(product);
        setChanged();
        notifyObservers();
        clearChanged();
    }

    /**
     * Creates a new user and adds it to the user list.
     *
     * @param username   The username of the new user
     * @param password   The password of the new user
     * @param isSeller   A boolean indicating if the user is a seller
     * @throws IllegalArgumentException If a user with the same username already exists
     */
    public void createUser(String username, String password, boolean isSeller) throws IllegalArgumentException {
        User new_user = new User(username, password, isSeller);
        for (User user : data.users) {
            if (user.getUsername().equals(username)) {
                throw new IllegalArgumentException("User with the same username already exists.");
            }
        }
        data.users.add(new_user);
    }

    /**
     * Gets the user with the given username and password.
     *
     * @param username The username of the user
     * @param password The password of the user
     * @return The user object
     * @throws NoSuchElementException If no user is found with the given credentials
     */
    public User getUser(String username, String password) throws NoSuchElementException {
        User user = verifyCredentials(username, password);
        if (user == null) {
            throw new NoSuchElementException("No user found with the given credentials.");
        }
        return user;
    }

    // Private method to verify user credentials
    private User verifyCredentials(String username, String password) {
        for (User user : data.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Imports Products from a serialized file into inventory, or Users into a user list
     *
     * @param type The type of data to import ("user" or "inventory")
     */
    public void importData(String type) {
        File file = new File(type + ".ser");
        try {
            file.createNewFile();
            if (file.length() != 0) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                switch (type) {
                    case ("inventory"):
                        data.inventory = (ArrayList) in.readObject();
                        in.close();
                        break;
                    case ("user"):
                        in = new ObjectInputStream(new FileInputStream(file));
                        data.users = (ArrayList) in.readObject();
                        in.close();
                        break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.print("Class not found : " + e);
            throw new RuntimeException(e);
        } catch (IOException ioe) {
            System.out.print("Error while reading data : " + ioe);
            ioe.printStackTrace();
        }
    }

    /**
     * Exports Products to a serialized file from inventory, or Users from a user list
     *
     * @param type The type of data to export ("user" or "inventory")
     */
    public void exportData(String type) {
        File file = new File(type + ".ser");
        try {
            file.createNewFile();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            switch (type) {
                case ("inventory"):
                    out.writeObject(data.inventory);
                    out.flush();
                    out.close();
                    break;
                case ("user"):
                    out.writeObject(data.users);
                    out.flush();
                    out.close();
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found : " + e);
            throw new RuntimeException(e);
        } catch (IOException ioe) {
            System.out.print("Error while writing data : " + ioe);
            ioe.printStackTrace();
        }
    }

    /**
     * Gets the list of products in the inventory.
     *
     * @return The list of products
     */
    public ArrayList<Product> getInventory() {
        return data.inventory;
    }

    /**
     * Gets the username of the active user.
     *
     * @return The username of the active user
     */
    public String getActiveUser() {
        return data.activeUser;
    }

    /**
     * Sets the active user in the system.
     *
     * @param user The username of the active user
     */
    public void setActiveUser(String user) {
        data.activeUser = user;
    }
}
