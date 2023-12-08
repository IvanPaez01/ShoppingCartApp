package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

/**
 * @author Ivan Paez
 * @author Justin Knight
 * The ShoppingCartWindow class represents the graphical user interface for the shopping cart.
 * It extends the WindowTemplate class and implements ActionListener for handling checkout button clicks.
 */
public class ShoppingCartWindow extends WindowTemplate {

    // Components for the shopping cart window
    private JList<String> cartList;
    private DefaultListModel<String> cartModel;
    private JButton checkoutButton;

    /**
     * Initializes the user interface components for the ShoppingCartWindow.
     *
     * @param frame The JFrame to which the components will be added
     */
    @Override
    public void initUI(JFrame frame) {
        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);
        JScrollPane scrollPane = new JScrollPane(cartList);

        checkoutButton = new JButton("Checkout");

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(checkoutButton, BorderLayout.SOUTH);
    }

    /**
     * Overrides the addActionListener method from the WindowTemplate.
     * Adds an ActionListener to the checkoutButton component.
     *
     * @param e The ActionListener to be added to the checkoutButton
     */
    public void addActionListener(ActionListener e) {
        checkoutButton.addActionListener(e);
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param item The item to be added to the cart
     */
    public void addItemToCart(String item) {
        cartModel.addElement(item);
    }

    /**
     * Overrides the update method from the Observable class.
     * This method is not used in ShoppingCartWindow, as there are no observers to notify.
     *
     * @param o   The Observable object (not used)
     * @param arg The argument passed to notifyObservers (not used)
     */
    @Override
    public void update(Observable o, Object arg) {
        // Not used in ShoppingCartWindow
    }
}
