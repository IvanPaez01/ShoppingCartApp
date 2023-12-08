package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

/**
 * @author Ivan Paez
 * @author Justin Knight
 * Window to display checkout screen
 */
public class CheckoutWindow extends WindowTemplate {

    // Components for the checkout window
    private JTextArea checkoutArea;
    private JButton payButton;

    /**
     * Initializes the user interface components for the CheckoutWindow.
     * Creates a JTextArea for reviewing items and a JButton for initiating payment.
     *
     * @param frame The JFrame to which the components will be added
     */
    @Override
    public void initUI(JFrame frame) {
        frame.setTitle("Checkout");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize and configure components
        checkoutArea = new JTextArea("Review your items here...");
        checkoutArea.setEditable(false);

        payButton = new JButton("Pay");
        payButton.addActionListener(e -> performPayment(frame));

        // Add components to the frame
        frame.getContentPane().add(new JScrollPane(checkoutArea), BorderLayout.CENTER);
        frame.getContentPane().add(payButton, BorderLayout.SOUTH);
    }

    /**
     * Overrides the addActionListener method from the WindowTemplate.
     *
     *
     * @param e The ActionListener to be added
     */
    @Override
    public void addActionListener(ActionListener e) {
        //TODO implement listener
    }

    /**
     * Displays a simple message dialog assuming a successful payment.
     *
     * @param frame The JFrame associated with the CheckoutWindow
     */
    public void performPayment(JFrame frame) {
        // Payment message
        JOptionPane.showMessageDialog(frame, "Payment Successful!", "Payment", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Overrides the update method from the Observable class.
     * This method is not used in CheckoutWindow, as there are no observers to notify.
     *
     * @param o   The Observable object (not used)
     * @param arg The argument passed to notifyObservers (not used)
     */
    @Override
    public void update(Observable o, Object arg) {
        //TODO implement Observable on ShoppingCart
    }
}
