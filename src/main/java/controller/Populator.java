package main.java.controller;

import main.java.model.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Justin Knight
 *
 * The Populator class is responsible for populating the Database with sample users and products
 * by reading data from external sample files. Could be used to bridge to a Database
 */
public class Populator {

    /**
     * Runs the populator
     *
     */
    public static void main(String[] args) {
        Populator pop = new Populator();
        Database data = Database.getInstance();

        File userFile = new File("sample_users.txt");
        pop.populateUsers(data, userFile);

        File productFile = new File("sample_products.txt");
        pop.populateInventory(data, productFile);
    }

    /**
     * Populates the Database with sample users by reading data from a file.
     *
     * @param data The Database instance to populate
     * @param file The file containing sample user data
     */
    public void populateUsers(Database data, File file) {
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (input.hasNextLine()) {
            String username = input.nextLine();
            String password = input.nextLine();
            boolean isSeller = Boolean.parseBoolean(input.nextLine());
            try {
                data.createUser(username, password, isSeller);
            } catch (IllegalArgumentException e) {
                // Handle invalid user creation (if needed)
            }
        }
        data.exportData("user");
        input.close();
    }

    /**
     * Populates the Database with sample products by reading data from a file.
     *
     * @param data The Database instance to populate
     * @param file The file containing sample product data
     */
    public void populateInventory(Database data, File file) {
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (input.hasNextLine()) {
            String name = input.nextLine();
            double price = Double.parseDouble(input.nextLine());
            int quantity = Integer.parseInt(input.nextLine());
            String seller = input.nextLine();
            data.addProduct(name, price, quantity, seller);
        }
        data.exportData("inventory");
        input.close();
    }
}
