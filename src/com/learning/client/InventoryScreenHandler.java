package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;

public class InventoryScreenHandler implements ActionListener {
    HubScreenHandler hubScreenHandler = new HubScreenHandler();

    @Override
    public void actionPerformed(ActionEvent e) {
        createInventoryScreen();
    }

    private void createInventoryScreen() {
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();
        con.add(inventoryTitlePanel);
        StringBuilder result = new StringBuilder();
        for (String i : GameManager.hub.showInventory()) {
            result.append(i).append("\n");
        }
        setMainTextPanel(setMainTextArea(String.valueOf(result)));
        con.add(mainTextPanel);
        con.add(returnPanel);
    }
}
