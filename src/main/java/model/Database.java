package main.java.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Database
{
    private ArrayList<Product> inventory;
    private ArrayList<User> users;
    public Database()
    {
        inventory = new ArrayList<>();
        users = new ArrayList<>();
        importData("users");
        importData("inventory");
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
            users.add(new_user);
        }

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

    private void importData(String type)
    {
        File file;
        ObjectInputStream in;
        try
        {
            switch (type)
            {
                case ("inventory"):
                    file = new File("inventory.ser");
                    file.createNewFile();
                    in = new ObjectInputStream(new FileInputStream(file));
                    inventory = (ArrayList) in.readObject();
                    break;

                case ("user"):
                    file = new File("users.ser");
                    file.createNewFile();
                    in = new ObjectInputStream(new FileInputStream(file));
                    users = (ArrayList) in.readObject();
                    break;
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

    private void exportData(String type)
    {
        File file;
        ObjectOutputStream out;
        try
        {
            switch(type)
            {
                case("inventory"):
                    file = new File("inventory.ser");
                    file.createNewFile();
                    out = new ObjectOutputStream(new FileOutputStream(file));
                    out.writeObject(inventory);
                    break;

                case("user"):
                    file = new File("users.ser");
                    file.createNewFile();
                    out = new ObjectOutputStream(new FileOutputStream(file));
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
