package main.java.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observer;

/**
 * @author Justin Knight
 * The WindowTemplate class is an abstract class that serves as a template for creating GUI windows.
 * It implements the Observer interface to allow windows to be notified of changes.
 */
public abstract class WindowTemplate implements Observer {

    // Reference to the JFrame associated with the window
    private JFrame window = null;

    /**
     * Loads and initializes the UI components of the window.
     * Calls initUI(JFrame frame) to set up the user interface and refreshes the window.
     */
    public void load() {
        window = getInstance();
        window.getContentPane().removeAll();
        initUI(window);
        refresh();
    }

    /**
     * Gets an instance of the JFrame associated with the window.
     * If the window is null, creates a new JFrame.
     *
     * @return The JFrame instance
     */
    private JFrame getInstance() {
        if (window == null) {
            window = new JFrame();
        }
        return window;
    }

    /**
     * Refreshes the window by validating, repainting, and making it visible.
     */
    public void refresh() {
        window.validate();
        window.repaint();
        window.setVisible(true);
    }

    /**
     * Abstract method to initialize the user interface components of the window.
     *
     * @param frame The JFrame to which the components will be added
     */
    public abstract void initUI(JFrame frame);

    /**
     * Abstract method to add an ActionListener to components in the window.
     *
     * @param e The ActionListener to be added
     */
    public abstract void addActionListener(ActionListener e);

}
