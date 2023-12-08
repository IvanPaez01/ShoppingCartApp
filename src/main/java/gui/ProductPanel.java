package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * @author Justin Knight
 * The ProductPanel class represents the graphical user interface for adding products.
 * It extends the WindowTemplate class and implements ActionListener for handling user actions.
 */
public class ProductPanel extends WindowTemplate {

    // Components for the product panel
    public JTextField productNameField;
    public JTextField quantityField;
    public JTextField costField;
    public JButton addButton;
    public JLabel costLabel;
    public JLabel quantityLabel;

    /**
     * Initializes the user interface components for the ProductPanel.
     *
     * @param frame The JFrame to which the components will be added
     */
    public void initUI(JFrame frame) {
        // Set up the frame
        frame.setTitle("Add Product");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Components
        JLabel productNameLabel = new JLabel("Product Name:");
        productNameField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField();

        addButton = new JButton("Add Product");

        // Add components to the panel
        mainPanel.add(productNameLabel);
        mainPanel.add(productNameField);
        mainPanel.add(quantityLabel);
        mainPanel.add(quantityField);
        mainPanel.add(costLabel);
        mainPanel.add(costField);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(addButton);
        frame.setContentPane(mainPanel);
    }

    /**
     * Overrides the addActionListener method from the WindowTemplate.
     * Adds an ActionListener to the addButton component.
     *
     * @param e The ActionListener to be added to the addButton
     */
    @Override
    public void addActionListener(ActionListener e) {
        addButton.addActionListener(e);
    }

    /**
     * Overrides the update method from the Observable class.
     * This method is not used in ProductPanel, as there are no observers to notify.
     *
     * @param o   The Observable object (not used)
     * @param arg The argument passed to notifyObservers (not used)
     */
    @Override
    public void update(Observable o, Object arg) {
        // Not used in ProductPanel
    }
}
