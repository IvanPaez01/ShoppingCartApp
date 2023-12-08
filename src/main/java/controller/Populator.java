package main.java.controller;

import main.java.model.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Populator
{
    public static void main(String[] args)
    {
        Populator pop = new Populator();
        Database data = Database.getInstance();

            File user_file = new File("sample_users.txt");
            pop.populateUsers(data, user_file);
            File product_file = new File("sample_products.txt");
            pop.populateInventory(data, product_file);
    }

    public void populateUsers(Database data, File file)
    {
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        while (input.hasNextLine())
        {
            String username = input.nextLine();
            String password = input.nextLine();
            boolean isSeller = Boolean.parseBoolean(input.nextLine());
            try {
                data.createUser(username, password, isSeller);
            }catch(IllegalArgumentException e){}
        }
        data.exportData("user");
        input.close();
    }

    public void populateInventory(Database data, File file)
    {
        {
            Scanner input = null;
            try {
                input = new Scanner(file);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
                System.exit(0);
            }
            while (input.hasNextLine())
            {
                String name = input.nextLine();
                double price = Double.parseDouble(input.nextLine());
                int quantity = Integer.parseInt(input.nextLine());
                String seller = input.nextLine();
                data.addProduct(name,price,quantity,seller);
            }
            data.exportData("inventory");
            input.close();
        }
    }
}

