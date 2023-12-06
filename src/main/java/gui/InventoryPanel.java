package main.java.gui;

import main.java.model.InventoryModel;
import main.java.model.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InventoryPanel
{
    private JTable table1;
    private JPanel rootpanel;

    private void createUIComponents() {
        ArrayList<Product> items = new ArrayList<>();
        //TODO: 3948 needs to be dynamic ID from observer
        InventoryModel model = new InventoryModel(items);
        table1 = new JTable(model);
    }

    public void open(){
        JFrame frame = new JFrame("InventoryPanel");
        frame.setContentPane(new InventoryPanel().rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    {
        initUI();
    }


    private void initUI() {
        createUIComponents();
        rootpanel = new JPanel();
        rootpanel.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        rootpanel.add(panel1, BorderLayout.CENTER);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, BorderLayout.CENTER);
        table1.setCellSelectionEnabled(true);
        table1.setFillsViewportHeight(false);
        scrollPane1.setViewportView(table1);
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setText("Your Products");
        panel1.add(label1, BorderLayout.NORTH);
    }

    public JComponent getRootPanel() {
        return rootpanel;
    }

}
