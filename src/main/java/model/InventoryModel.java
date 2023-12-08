package main.java.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InventoryModel extends AbstractTableModel
{
    ArrayList<Product> items;
    String[] headers = {"Name","Price","Quantity"};

    public InventoryModel()
    {
        update();
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Product item = items.get(rowIndex);
        return switch (columnIndex)
        {
            case 0 -> item.getName();
            case 1 -> item.getPrice();
            case 2 -> item.getQuantity();
            default -> 0;
        };
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Product item = items.get(row);
        switch(col)
        {
            case 0 -> item.setName((String) value);
            case 1 -> item.setPrice((Double) value);
            case 2 -> item.setQuantity((Integer) value);
        };
        fireTableCellUpdated(row, col);
    }
    public void update()
    {
        items = Database.getInstance().getInventory();
    }
    @Override
    public String getColumnName(int col)
    {
        return headers[col];
    }
}


