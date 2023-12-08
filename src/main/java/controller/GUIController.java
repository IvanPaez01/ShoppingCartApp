package main.java.controller;

import main.java.gui.WindowTemplate;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import main.java.gui.*;
import main.java.model.Database;
import main.java.model.User;

public class GUIController
{
    private Database data;
    private final ArrayList<WindowTemplate> pages;
    public int pageIndex;

    public GUIController()
    {
        data = Database.getInstance();
        pages = new ArrayList<>();
        pages.add(new LoginWindow());
        pages.add(new ProductBrowser());
        pages.add(new ShoppingCartWindow());
        pages.add(new CheckoutWindow());
        pages.add(new InventoryPanel());
        pageIndex = 0;
    }

    public WindowTemplate getPage(int i)
    {
        return pages.get(i);
    }
    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public WindowTemplate getCurrentPage()
    {
        return getPage(pageIndex);
    }

    public void drawPage()
    {
        getPage(pageIndex).load();
        addListener();
    }

    public void drawPage(int index)
    {
        getPage(index).load();
        addListener();
    }

    public void addListener()
    {
        ActionListenerBuilder builder = new ActionListenerBuilder();
        builder.addListener(pageIndex);
    }


    class ActionListenerBuilder
    {
        public void addLoginListener (LoginWindow login)
        {
            login.addActionListener(e -> {
                String username = login.userText.getText();
                String password = new String(login.passwordText.getPassword());
                User user = data.getUser(username, password);
                if (user == null) {} else {
                    if (user.isSeller()) {
                        drawPage(4);
                    } else {
                        drawPage(2);
                    }

                }

            });
        }
        public void addBrowserListener (LoginWindow login)
        {
            login.addActionListener(e -> {
                String username = login.userText.getText();
                data.setActiveUser(username);
                String password = new String(login.passwordText.getPassword());
                User user = data.getUser(username, password);
                if (user == null) {} else {
                    if (user.isSeller()) {
                        getPage(1).load();
                    } else {
                        getPage(2).load();
                    }

                }

            });
        }
        public void addCartListener (LoginWindow login)
        {

        }
        public void addInventoryListener (InventoryPanel inventory)
        {

        }

        public void addBrowserListener (ProductBrowser browser)
        {

        }

        public void addListener(int index)
        {
            switch(index)
            {
                case 0: addLoginListener((LoginWindow) getCurrentPage());
                break;
                case 1:
                break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: addInventoryListener((InventoryPanel) getCurrentPage());
                break;
            }
        }
    }
}

