package main.java.gui;
// Import statements

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ProductBrowser extends WindowTemplate{

    JPanel panel;
    JScrollPane productPane;
    JList<String> productList;
    JButton addToCartButton;

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
    public void addActionListener(ActionListener e)
    {
        addToCartButton.addActionListener(e);
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }
}
