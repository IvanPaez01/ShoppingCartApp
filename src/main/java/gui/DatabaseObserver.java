package main.java.gui;

import java.util.Observable;
import java.util.Observer;

public class DatabaseObserver implements Observer {
    private static DatabaseObserver instance = null;

    private DatabaseObserver() {
        // private constructor for singleton
    }

    public static DatabaseObserver getInstance() {
        if (instance == null) {
            instance = new DatabaseObserver();
        }
        return instance;
    }

    @Override
    public void update(Observable o, Object arg) {
        // Handle database updates and notify relevant GUI components
        if (o != null) {
            // Example: Notify GUI components about the update
            // You may need to add specific methods in your GUI classes for handling updates
            // For instance, gui.updateProducts(((Database) o).getProducts());
        }
    }
}