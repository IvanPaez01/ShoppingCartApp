package main.java.controller;

import main.java.model.Database;

public class AppStart
{
    public static void main(String[] args)
    {
        Database.getInstance();
        GUIController gui = new GUIController();
        gui.drawPage();


    }
}
