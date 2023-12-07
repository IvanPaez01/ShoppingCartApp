package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

public class ShoppingCartWindow extends WindowTemplate {
    private JList<String> cartList;
    private DefaultListModel<String> cartModel;
    private JButton checkoutButton;

    @Override
    public void initUI(JFrame frame) {
        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);
        JScrollPane scrollPane = new JScrollPane(cartList);

        checkoutButton = new JButton("Checkout");

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(checkoutButton, BorderLayout.SOUTH);
    }

    public void addActionListener(ActionListener e)
    {
        checkoutButton.addActionListener(e);
    }

    // Method to add items to the cart
    public void addItemToCart(String item) {
        cartModel.addElement(item);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}

