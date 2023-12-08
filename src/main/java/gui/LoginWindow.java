package main.java.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;

public class LoginWindow extends WindowTemplate {
    public JPanel panel;
    public JLabel userLabel;
    public JTextField userText;
    public JLabel passwordLabel;
    public JPasswordField passwordText;
    public JButton loginButton;

    public LoginWindow() {
        panel = new JPanel();
        userLabel = new JLabel();
        userText = new JTextField();
        passwordLabel = new JLabel();
        passwordText = new JPasswordField();
        loginButton = new JButton();
    }

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
        };

    public void addActionListener(ActionListener e)
    {
        loginButton.addActionListener(e);
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }
}