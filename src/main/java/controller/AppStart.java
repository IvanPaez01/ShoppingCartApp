package main.java.controller;

import main.java.gui.InventoryPanel;
import main.java.gui.LoginWindow;
import main.java.gui.*;
import main.java.model.Database;
import main.java.model.User;

import javax.swing.*;

public class AppStart
{
    public static void main(String[] args) {
        GUIController gui = new GUIController();
        gui.drawPage();
        gui.addLoginListener();


    }
}
