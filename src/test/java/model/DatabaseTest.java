package test.java.model;

import main.java.model.Database;
import main.java.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Database database;

    @BeforeEach
    public void setUp()
    {
        database = new Database();
        database.addProduct("Phone",150,2,3648);
    }

    @Test
    public void testCreateUser()
    {
        String username = "test";
        String password = "password";
        database.createUser(username, password, false);
        User user = database.getUser(username, password);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetUser()
    {
        String username = "test";
        String password = "password";
        database.createUser(username, password, false);
        User user = database.getUser(username, password);
        assertNotNull(user);
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