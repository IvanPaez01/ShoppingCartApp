package main.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;

public class Database extends Observable
{
    private static Database data = null;
    private ArrayList<Product> inventory;
    private ArrayList<User> users;

    private String activeUser;
    private Database()
    {
        inventory = new ArrayList<>();
        users = new ArrayList<>();
        importData("user");
        importData("inventory");
    }

    public static Database getInstance()
    {
        if(data == null)
        {
            data = new Database();
        }
        return data;
    }


    public void updateProduct(String name, String new_name, double price, int quantity, String seller)
    {
        if(new_name == null){new_name = name;}
        for (Product product : inventory)
        {
            if (product.getSeller_ID().equals(seller) && product.getName().equals(name))
            {
                product.setName(new_name);
                product.setPrice(price);
                product.setQuantity(quantity);
            }
        }
    }
    public void addProduct(String name, double price, int quantity, String seller)
    {
        Product product = new Product(name,price,quantity,seller);
        // Tests if the exact item exists
        if(!inventory.contains(product))
        {
            // Tests if a variant of the item exists, reroutes function if so
            updateProduct(name,null,price,quantity,seller);

            // Adds product
            inventory.add(product);
        }
    }
    public void createUser(String username, String password, boolean isSeller) throws IllegalArgumentException
    {
        User new_user = new User(username,password,isSeller);
        for (User user : users)
        {
            if (user.getUsername().equals(username))
            {
                throw(new IllegalArgumentException());
            }
        }
        users.add(new_user);

    }

    public User getUser(String username, String password)
    {
        User user = verifyCredentials(username, password);
        if(user == null)
        {
            throw(new NoSuchElementException());
        }
        return user;
    }
    private User verifyCredentials(String username, String password)
    {
        for(User user : users)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }

    public void importData(String type)
    {
        File file = new File(type + ".ser");
        try
        {
            file.createNewFile();
            if(file.length() != 0) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                switch (type) {
                    case ("inventory"):
                        inventory = (ArrayList) in.readObject();
                        break;

                    case ("user"):
                        in = new ObjectInputStream(new FileInputStream(file));
                        users = (ArrayList) in.readObject();
                        break;
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.print("Class not found : " + e);
            throw new RuntimeException(e);
        }
        catch (IOException ioe)
        {
            System.out.print("Error while reading data : " + ioe);
            ioe.printStackTrace();
        }
    }

    public void exportData(String type)
    {
        File file = new File(type + ".ser");
        try
        {
            file.createNewFile();

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                switch (type) {
                    case ("inventory"):
                        out.writeObject(inventory);
                        break;

                    case ("user"):
                        out.writeObject(users);
                        break;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.print("File not found : " + e);
            throw new RuntimeException(e);
        }
        catch (IOException ioe)
        {
            System.out.print("Error while writing data : " + ioe);
            ioe.printStackTrace();
        }
    }

    public ArrayList<Product> getInventory()
    {
        return inventory;
    }

    public String getActiveUser()
    {
        return activeUser;
    }

    public void setActiveUser(String user)
    {
        activeUser = user;
    }

}
