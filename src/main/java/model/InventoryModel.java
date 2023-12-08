package main.java.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author Justin Knight
 * The InventoryModel class represents the table model for displaying inventory data in a GUI.
 * It extends AbstractTableModel and provides methods to interact with and update the inventory table.
 */
public class InventoryModel extends AbstractTableModel {

    // List of products in the inventory
    ArrayList<Product> items;

    // Column headers for the inventory table
    String[] headers = {"Name", "Price", "Quantity"};

    /**
     * Constructs an InventoryModel instance and initializes the list of items.
     */
    public InventoryModel() {
        items = new ArrayList<>();
        update();
    }

    /**
     * Gets the number of rows in the inventory table.
     *
     * @return The number of rows
     */
    @Override
    public int getRowCount() {
        return items.size();
    }

    /**
     * Gets the number of columns in the inventory table.
     *
     * @return The number of columns
     */
    @Override
    public int getColumnCount() {
        return headers.length;
    }

    /**
     * Gets the value at the specified row and column in the inventory table.
     *
     * @param rowIndex    The index of the row
     * @param columnIndex The index of the column
     * @return The value at the specified row and column
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product item = items.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> item.getName();
            case 1 -> item.getPrice();
            case 2 -> item.getQuantity();
            default -> 0;
        };
    }

    /**
     * Sets the value at the specified row and column in the inventory table.
     * Updates the corresponding Product object and notifies listeners of the change.
     *
     * @param value The new value
     * @param row   The index of the row
     * @param col   The index of the column
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        Product item = items.get(row);
        switch (col) {
            case 0 -> item.setName((String) value);
            case 1 -> item.setPrice((Double) value);
            case 2 -> item.setQuantity((Integer) value);
        }
        fireTableCellUpdated(row, col);
    }

    /**
     * Updates the inventory by filtering items based on the active user.
     */
    public void update() {
        ArrayList<Product> allItems = Database.getInstance().getInventory();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getSeller_ID().equals(Database.getInstance().getActiveUser())) {
                items.add(allItems.get(i));
                allItems.remove(i);
                i--;
            }
        }
    }

    /**
     * Gets the column name for the specified column index.
     *
     * @param col The index of the column
     * @return The column name
     */
    @Override
    public String getColumnName(int col) {
        return headers[col];
    }
}
