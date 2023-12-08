package main.java.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InventoryModel extends AbstractTableModel
{
    ArrayList<Product> items;
    String[] headers = {"Name","Price","Quantity"};

    public InventoryModel()
    {
        items = new ArrayList<>();
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
        ArrayList<Product> all_items = Database.getInstance().getInventory();
        for(int i = 0;i<all_items.size();i++)
        {
            if(all_items.get(i).getSeller_ID().equals(Database.getInstance().getActiveUser()))
            {
                items.add(all_items.get(i));
                all_items.remove(i);
                i--;
            }
        }
    }
    @Override
    public String getColumnName(int col)
    {
        return headers[col];
    }
}


