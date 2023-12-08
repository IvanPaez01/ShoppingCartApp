package main.java.controller;

import main.java.gui.WindowTemplate;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import main.java.gui.*;
import main.java.model.Database;
import main.java.model.User;

/**
 * @author Justin Knight
 * The GUIController class manages the user interface components and their interactions.
 * It handles the navigation between different windows and sets up action listeners for user input.
 * It also manages communication with the database
 */
public class GUIController {

    private Database data;
    private final ArrayList<WindowTemplate> pages;
    public int pageIndex;

    /**
     * Initializes the data, creates window templates, and sets up initial observers and page index.
     */
    public GUIController() {
        data = Database.getInstance();
        pages = new ArrayList<>();
        pages.add(new LoginWindow());
        pages.add(new ProductBrowser());
        pages.add(new ShoppingCartWindow());
        pages.add(new CheckoutWindow());
        pages.add(new InventoryPanel());
        pages.add(new ProductPanel());
        data.addObserver(pages.get(4));
        data.addObserver(pages.get(5));

        pageIndex = 0;
    }

    /**
     * Gets the page at the specified index.
     *
     * @param i The index of the page
     * @return The page as WindowTemplate
     */
    public WindowTemplate getPage(int i) {
        return pages.get(i);
    }

    /**
     * Sets the current page index.
     *
     * @param pageIndex The index of the current page
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * Gets the current page
     *
     * @return The current page as WindowTemplate
     */
    public WindowTemplate getCurrentPage() {
        return getPage(pageIndex);
    }

    /**
     * Draws the current page and adds the necessary action listeners.
     */
    public void drawPage() {
        getPage(pageIndex).load();
        addListener();
    }

    /**
     * Overloaded function of drawPage()
     * @param index The index of the page to draw
     */
    public void drawPage(int index) {
        getPage(index).load();
        addListener();
    }

    /**
     * Adds action listeners based on the current page index.
     */
    public void addListener() {
        ActionListenerBuilder builder = new ActionListenerBuilder();
        builder.addListener(pageIndex);
    }

    /**
     * ActionListenerBuilder class assists in creating action listeners for various GUI components.
     */
    class ActionListenerBuilder {

        /**
         * Adds a login listener for the LoginWindow component.
         *
         * @param login The LoginWindow instance
         */
        public void addLoginListener(LoginWindow login) {
            login.addActionListener(e -> {
                String username = login.userText.getText();
                String password = new String(login.passwordText.getPassword());
                data.setActiveUser(username);
                User user = data.getUser(username, password);
                if (user == null) {
                } else {
                    if (user.isSeller()) {
                        setPageIndex(2);
                        drawPage(2);
                    } else {
                        setPageIndex(4);
                        drawPage(4);
                    }

                }
            });
        }

        /**
         * Adds a browser listener for the LoginWindow component.
         *
         * @param login The LoginWindow instance
         */
        public void addBrowserListener(LoginWindow login) {
            login.addActionListener(e -> {
                String username = login.userText.getText();
                String password = new String(login.passwordText.getPassword());
                User user = data.getUser(username, password);
                if (user == null) {
                } else {
                    if (user.isSeller()) {
                        getPage(1).load();
                    } else {
                        getPage(2).load();
                    }
                }
            });
        }

        /**
         * Adds a cart listener for the ShoppingCartWindow component.
         *
         * @param cart The ShoppingCartWindow instance
         */
        public void addCartListener(LoginWindow cart) {
            // TODO Integrate shopping cart listener
        }

        /**
         * Adds an inventory listener for the InventoryPanel component.
         *
         * @param inventory The InventoryPanel instance
         */
        public void addInventoryListener(InventoryPanel inventory) {
            inventory.addActionListener(e -> {
                setPageIndex(5);
                drawPage(5);
            });
        }

        /**
         * Adds a product browser listener for the ProductPanel component.
         *
         * @param product The ProductPanel instance
         */
        public void addProductBrowserListener(ProductPanel product) {
            product.addActionListener(e -> {
                // Retrieve input values
                String productName = product.productNameField.getText();
                int quantity = Integer.parseInt(product.quantityField.getText());
                double cost = Double.parseDouble(product.costField.getText());
                data.addProduct(productName, cost, quantity, data.getActiveUser());
            });
        }

        /**
         * Adds a listener for the ProductBrowser component.
         *
         * @param browser The ProductBrowser instance
         */
        public void addBrowserListener(ProductBrowser browser) {
            //TODO Integrate browser listener
        }

        /**
         * Adds listeners based on the specified index.
         *
         * @param index The index representing the current page
         */
        public void addListener(int index) {
            switch (index) {
                case 0:
                    addLoginListener((LoginWindow) getCurrentPage());
                    break;
                case 1:
                    addBrowserListener((LoginWindow) getCurrentPage());
                    break;
                case 2:
                    //TODO implement cart listener
                    break;
                case 3:
                    //TODO implement checkout listener
                    break;
                case 4:
                    addInventoryListener((InventoryPanel) getCurrentPage());
                    break;
                case 5:
                    addProductBrowserListener((ProductPanel) getCurrentPage());
                    break;
            }
        }
    }
}
