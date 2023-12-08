package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

public class LoginWindow extends WindowTemplate {
    // Declare userText and passwordText as instance variables
    public JTextField userText;
    public JPasswordField passwordText;

    public void initUI(JFrame frame) {
        frame.setTitle("Group 11 Shopping Cart App - Login");
        frame.setSize(700, 600); // Updated size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Group 11 Shopping Cart App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Increased font size
        int panelHeight = frame.getHeight();
        int titleLabelHeight = 30;
        int titleLabelY = (panelHeight - titleLabelHeight) / 10; // Adjusted Y position
        int titleLabelX = 200; // Initial X position
        titleLabel.setBounds(titleLabelX, titleLabelY, 600, titleLabelHeight); // Adjusted bounds for width and centered vertically
        panel.add(titleLabel);




        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(200, 150, 80, 25);
        panel.add(userLabel);

        // Use the instance variables here
        userText = new JTextField(20);
        userText.setBounds(300, 150, 200, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 200, 80, 25);
        panel.add(passwordLabel);

        // Use the instance variables here
        passwordText = new JPasswordField(20);
        passwordText.setBounds(300, 200, 200, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 250, 200, 30);
        panel.add(loginButton);

        frame.add(panel);
        addActionListener(e -> {
            // Handle login logic
            // Example: authenticateUser(userText.getText(), new String(passwordText.getPassword()));
            // After successful login, navigate to the next window
            // Example: new ProductBrowser().load();
        });
    }

    @Override
    public void addActionListener(ActionListener e) {
        // This method can be left empty in LoginWindow
    }

    @Override
    public void update(Observable o, Object arg) {
        // This method can be left empty in LoginWindow
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.load();
        });
    }
}
