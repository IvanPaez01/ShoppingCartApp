package main.java.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observer;

public abstract class WindowTemplate implements Observer
{
    private JFrame window = null;


    public void load()
    {
        window = getInstance();
        window.getContentPane().removeAll();
        initUI(window);
        window.validate();
        window.repaint();
        window.setVisible(true);
    }

    private JFrame getInstance()
    {
        if(window == null){window = new JFrame();}
        return window;
    }


    public abstract void initUI(JFrame frame);
    public abstract void addActionListener(ActionListener e);

}
