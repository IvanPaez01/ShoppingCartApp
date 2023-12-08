package main.java.gui;

// Import statements

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * The ProductBrowser class represents the graphical user interface for browsing products.
 * It extends the WindowTemplate class and implements ActionListener for handling user actions.
 */
public class ProductBrowser extends WindowTemplate {

    // Components for the product browser
    JPanel panel;
    JScrollPane productPane;
    JList<String> productList;
    JButton addToCartButton;

    /**
     * Initializes the user interface components for the ProductBrowser.
     *
     * @param frame The JFrame to which the components will be added
     */
    public void initUI(JFrame frame) {
        // Frame setup
        frame.setTitle("Product Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Main panel
        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // Product list (mock data)
        String[] products = { "Product 1", "Product 2", "Product 3" };
        productList = new JList<>(products);
        productPane = new JScrollPane(productList);
        panel.add(productPane, BorderLayout.CENTER);

        // Add to cart button
        addToCartButton = new JButton("Add to Cart");
        panel.add(addToCartButton, BorderLayout.SOUTH);
    }

    /**
     * Overrides the addActionListener method from the WindowTemplate.
     * Adds an ActionListener to the addToCartButton component.
     *
     * @param e The ActionListener to be added to the addToCartButton
     */
    public void addActionListener(ActionListener e) {
        addToCartButton.addActionListener(e);
    }

    /**
     * Overrides the update method from the Observable class.
     * This method is not used in ProductBrowser, as there are no observers to notify.
     *
     * @param o   The Observable object (not used)
     * @param arg The argument passed to notifyObservers (not used)
     */
    @Override
    public void update(Observable o, Object arg) {
        // Not used in ProductBrowser
    }
}
