package main.java.gui;
// Import statements

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductBrowser {

    public void open() {
        // Frame setup
        JFrame frame = new JFrame("Product Browser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Main panel
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // Product list (mock data)
        String[] products = { "Product 1", "Product 2", "Product 3" };
        JList<String> productList = new JList<>(products);
        panel.add(new JScrollPane(productList), BorderLayout.CENTER);

        // Add to cart button
        JButton addToCartButton = new JButton("Add to Cart");
        panel.add(addToCartButton, BorderLayout.SOUTH);

        // Frame visibility
        frame.setVisible(true);

        // Listener for add to cart button
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add selected product to cart
                String selectedProduct = productList.getSelectedValue();
                // Implement add to cart logic
            }
        });
    }
}
