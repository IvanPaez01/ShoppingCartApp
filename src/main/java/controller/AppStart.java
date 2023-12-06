package main.java.controller;

import main.java.gui.InventoryPanel;
import main.java.gui.LoginWindow;
import main.java.gui.*;
import main.java.model.Database;
import main.java.model.User;

public class AppStart
{
    public static void main(String[] args) {
        Database data = Database.getInstance();
        LoginWindow login = new LoginWindow();
        ProductBrowser productBrowser = new ProductBrowser();
        InventoryPanel inventoryPanel = new InventoryPanel();


        // Action listener for the login button
        //TODO Establish whether a separate class should be created for button listeners with custom logic
        login.addListener(e -> {
            String username = login.userText.getText();
            String password = new String(login.passwordText.getPassword());
            User user = data.getUser(username, password);
            if (user == null) {
            } else {
                if (user.isSeller()) {
                    inventoryPanel.open();
                } else {
                    productBrowser.open();
                }

            }

        });
    }
}
