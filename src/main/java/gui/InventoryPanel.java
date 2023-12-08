package main.java.gui;

import main.java.model.InventoryModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Justin Knight
 * Inventory Panel to display a live inventory feed, and allow addition of products
 */
public class InventoryPanel extends WindowTemplate {

    // Components for the inventory panel
    private JTable table1;
    private JPanel rootPanel;
    private InventoryModel model;
    private JButton button;

    /**
     * Initializes the user interface components for the InventoryPanel.
     *
     * @param frame The JFrame to which the components will be added
     */
    @Override
    public void initUI(JFrame frame) {
        frame.setTitle("InventoryPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the inventory model and table
        model = new InventoryModel();
        table1 = new JTable(model);

        // Create the root panel
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));

        // Create a panel to contain the table and button
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        rootPanel.add(panel1, BorderLayout.CENTER);

        // Create a scroll pane for the table
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, BorderLayout.CENTER);
        table1.setCellSelectionEnabled(true);
        table1.setFillsViewportHeight(false);
        scrollPane1.setViewportView(table1);

        // Create a button for adding products
        button = new JButton("Add Product");

        // Create a label for product information
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setText("Your Products");

        // Add components to the panel
        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(button, BorderLayout.SOUTH);

        // Set the content pane of the frame
        frame.setContentPane(rootPanel);
        frame.pack();
    }

    /**
     * Overrides the addActionListener method from the WindowTemplate.
     *
     * @param e The ActionListener to open the "Add Product" screen
     */
    @Override
    public void addActionListener(ActionListener e) {
        button.addActionListener(e);
    }

    /**
     * Gets the root panel of the InventoryPanel.
     *
     * @return The root panel of the InventoryPanel
     */
    public JComponent getRootPanel() {
        return rootPanel;
    }

    /**
     * Updates the inventory model data and refreshes the panel on change in data.
     *
     * @param o   The Observable object
     * @param arg The data passed to by Observable
     */
    @Override
    public void update(Observable o, Object arg) {
        model.fireTableDataChanged();
        super.refresh();
    }
}
