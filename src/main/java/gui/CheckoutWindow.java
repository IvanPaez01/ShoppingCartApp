package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckoutWindow extends JFrame {
    private JTextArea checkoutArea;
    private JButton payButton;

    public CheckoutWindow() {
        setTitle("Checkout");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        checkoutArea = new JTextArea("Review your items here...");
        checkoutArea.setEditable(false);

        payButton = new JButton("Pay");
        payButton.addActionListener(e -> performPayment());

        getContentPane().add(new JScrollPane(checkoutArea), BorderLayout.CENTER);
        getContentPane().add(payButton, BorderLayout.SOUTH);
    }

    private void performPayment() {
        // Logic to handle payment
        JOptionPane.showMessageDialog(this, "Payment Successful!", "Payment", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); // Close the checkout window
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheckoutWindow window = new CheckoutWindow();
            window.setVisible(true);
        });
    }
}
