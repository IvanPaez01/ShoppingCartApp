package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

public class CheckoutWindow extends WindowTemplate {
    private JTextArea checkoutArea;
    private JButton payButton;

    public CheckoutWindow() {
    }

    public void initUI(JFrame frame) {
        frame.setTitle("Checkout");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkoutArea = new JTextArea("Review your items here...");
        checkoutArea.setEditable(false);

        payButton = new JButton("Pay");
        payButton.addActionListener(e -> performPayment(frame));

        frame.getContentPane().add(new JScrollPane(checkoutArea), BorderLayout.CENTER);
        frame.getContentPane().add(payButton, BorderLayout.SOUTH);
    }

    @Override
    public void addActionListener(ActionListener e) {

    }

    public void performPayment(JFrame frame) {
        // Logic to handle payment
        JOptionPane.showMessageDialog(frame, "Payment Successful!", "Payment", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void update(Observable o, Object arg)
    {
    }
}
