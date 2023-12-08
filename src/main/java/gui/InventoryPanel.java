package main.java.gui;

import main.java.model.InventoryModel;
import main.java.model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class InventoryPanel extends WindowTemplate
{
    private JTable table1;
    private JPanel rootpanel;

    private InventoryModel model;


    public void initUI(JFrame frame) {
        frame.setTitle("InventoryPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new InventoryModel();
        table1 = new JTable(model);
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
        frame.setContentPane(rootpanel);
        frame.pack();
    }

    @Override
    public void addActionListener(ActionListener e)
    {

    }

    public JComponent getRootPanel() {
        return rootpanel;
    }

    @Override
    public void update(Observable o, Object arg) {
        model.update();
        super.refresh();

    }
}
