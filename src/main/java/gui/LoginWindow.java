package main.java.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginWindow {
    public JLabel userLabel;
    public JTextField userText;
    public JLabel passwordLabel;
    public JPasswordField passwordText;
    public JButton loginButton;

    public LoginWindow() {
        // Frame setup
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel setup
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Make frame visible
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // User label and text field
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        // Password label and password field
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        // Login button
        loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        };

    public void addListener(ActionListener e)
    {
        loginButton.addActionListener(e);
    }
}