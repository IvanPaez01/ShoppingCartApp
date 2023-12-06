package test.java.model;

import main.java.model.Database;
import main.java.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Database database;

    @BeforeEach
    public void setUp()
    {
        database = Database.getInstance();
        try{
            database.addProduct("Phone",150,2,"jerry");
            database.createUser("jerry","jerryrocks",true);
        }catch(IllegalArgumentException e)
        {
            System.out.print("User already exists");
        }
    }

    @Test
    public void testGetCreateUser()
    {
        String username = "test";
        String password = "password";
        database.createUser(username, password, false);
        User user = database.getUser(username, password);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetUserException()
    {
        // Trying to get a nonexistent user
        assertThrows(NoSuchElementException.class, () ->
        {
            database.getUser("invalid", "invalid");
        });
    }
}