package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameGui.returnPanel;

public class InventoryItemsHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        showInventoryList();
    }

    private void showInventoryList() {
        ExploreMissionScreenHandler exploreMissionScreenHandler = new ExploreMissionScreenHandler();

        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("inventory.png")))));
        con = window.getContentPane();
        con.add(inventoryTitlePanel);
        StringBuilder result = new StringBuilder();
        for (String i : GameManager.hub.showInventory()) {
            result.append(i).append("\n");
        }
        setMainTextPanel(setMainTextArea(String.valueOf(result)));
        setReturnPanel(setReturnButton("Back to Mission"));
        returnButton.addActionListener(exploreMissionScreenHandler);
        con.add(mainTextPanel);
        con.add(returnPanel);

        window.remove(playerPanel);
        window.remove(exploreMissionPanel);
        window.remove(exploreInventoryPanel);
    }
}
