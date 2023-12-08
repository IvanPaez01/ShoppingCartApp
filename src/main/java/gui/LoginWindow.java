package main.java.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * @author Ivan Paez
 * @author Justin Knight
 * The LoginWindow class represents the graphical user interface for user login.
 * It extends the WindowTemplate class and implements ActionListener for handling login button clicks.
 */
public class LoginWindow extends WindowTemplate {

    // Components for the login window
    public JPanel panel;
    public JLabel userLabel;
    public JTextField userText;
    public JLabel passwordLabel;
    public JPasswordField passwordText;
    public JButton loginButton;

    /**
     * Constructs a LoginWindow instance and initializes its components.
     */
    public LoginWindow() {
        panel = new JPanel();
        userLabel = new JLabel();
        userText = new JTextField();
        passwordLabel = new JLabel();
        passwordText = new JPasswordField();
        loginButton = new JButton();
    }

    /**
     * Initializes the user interface components for the LoginWindow.
     *
     * @param frame The JFrame to which the components will be added
     */
    public void initUI(JFrame frame) {
        frame.setTitle("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
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
    }

    /**
     * Adds an ActionListener to the loginButton component.
     *
     * @param e ActionListener that triggers on login
     */
    public void addActionListener(ActionListener e) {
        loginButton.addActionListener(e);
    }

    /**
     * This method is not used in LoginWindow
     *
     * @param o   The Observable object (not used)
     * @param arg The argument passed to notifyObservers (not used)
     */
    @Override
    public void update(Observable o, Object arg) {
        // Unused
    }
}
