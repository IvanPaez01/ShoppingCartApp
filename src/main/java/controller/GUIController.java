package main.java.controller;

import main.java.gui.WindowTemplate;

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

    public Object getCurrentPage()
    {
        return getPage(pageIndex);
    }

    public void drawPage()
    {
        getPage(pageIndex).load();
    }

    public void addLoginListener ()
    {
        LoginWindow login = (LoginWindow) getCurrentPage();
            login.addActionListener(e -> {
            String username = login.userText.getText();
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
}

