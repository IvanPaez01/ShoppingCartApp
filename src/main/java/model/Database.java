package main.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Database
{
    private static Database data = null;
    private ArrayList<Product> inventory;
    private ArrayList<User> users;
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


    public void addProduct(String name, double price, int quantity, String seller)
    {
        Product product = new Product(name,price,quantity,seller);
        inventory.add(product);
    }
    public void createUser(String username, String password, boolean isSeller)
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

}
