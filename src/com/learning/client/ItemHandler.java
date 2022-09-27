package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.learning.client.ExploreMissionScreenHandler.allInventoryButtons;
import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;

public class ItemHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fuelButton) {
            fuelButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(fuelButton.getText());
            updateInventoryCount(fuelButton, hub.getHeroPosition());

        } else if (e.getSource() == engineButton) {
            engineButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(engineButton.getText());
            updateInventoryCount(engineButton, hub.getHeroPosition());

        } else if (e.getSource() == bioSuitButton) {
            bioSuitButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(bioSuitButton.getText());
            updateInventoryCount(bioSuitButton, hub.getHeroPosition());

        } else if (e.getSource() == tmButton) {
            tmButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(tmButton.getText());
            updateInventoryCount(tmButton, hub.getHeroPosition());

        } else if (e.getSource() == keyCardButton) {
            keyCardButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(keyCardButton.getText());
            updateInventoryCount(keyCardButton, hub.getHeroPosition());

        } else if (e.getSource() == basementKeyButton) {
            basementKeyButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(basementKeyButton.getText());
            updateInventoryCount(basementKeyButton, hub.getHeroPosition());

        } else if (e.getSource() == toolkitButton) {
            toolkitButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(toolkitButton.getText());
            updateInventoryCount(toolkitButton, hub.getHeroPosition());

        } else if (e.getSource() == gpsButton) {
            gpsButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(gpsButton.getText());
            updateInventoryCount(gpsButton, hub.getHeroPosition());

        } else if (e.getSource() == knifeButton) {
            knifeButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(knifeButton.getText());
            updateInventoryCount(knifeButton, hub.getHeroPosition());

        } else if (e.getSource() == rifleButton) {
            rifleButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(rifleButton.getText());
            updateInventoryCount(rifleButton, hub.getHeroPosition());

        } else if (e.getSource() == pistolButton) {
            pistolButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(pistolButton.getText());
            updateInventoryCount(pistolButton, hub.getHeroPosition());

        } else if (e.getSource() == laserGunButton) {
            laserGunButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(laserGunButton.getText());
            updateInventoryCount(laserGunButton, hub.getHeroPosition());

        } else if (e.getSource() == imtvButton) {
            imtvButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(imtvButton.getText());
            updateInventoryCount(imtvButton, hub.getHeroPosition());

        } else if (e.getSource() == achButton) {
            achButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(achButton.getText());
            updateInventoryCount(achButton, hub.getHeroPosition());

        } else if (e.getSource() == glovesButton) {
            glovesButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(glovesButton.getText());
            updateInventoryCount(glovesButton, hub.getHeroPosition());

        } else if (e.getSource() == bootsButton) {
            bootsButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(bootsButton.getText());
            updateInventoryCount(bootsButton, hub.getHeroPosition());

        } else if (e.getSource() == compassButton) {
            compassButton.setVisible(false);
            GameGui.playSE(3);
            hub.addItemToInventory(compassButton.getText());
            updateInventoryCount(compassButton, hub.getHeroPosition());
        }
    }

    public static ArrayList<String> getInventoryButtonsList(String currentLocation) {
        ArrayList<String> items = new ArrayList<>();
        hub.initiateItemLocationList();
        for (Object item : hub.lookAction(currentLocation)) {
            for (JButton button : allInventoryButtons) {
                if (item.equals(button.getText())) {
                    items.add(button.getText());
                }
            }
        }
        return items;
    }

    static ArrayList<String> inventory = hub.item.getBackpackList();

    public static void updateInventoryCount(JButton button, String currentLocation) {
        hub.item.setItemFound(getInventoryButtonsList(currentLocation));
        inventory.add(button.getText());

        hub.item.setItemCalledOut(button.getText());
        hub.item.parseItemObject();
        hub.item.getItemLocationList().remove(hub.getHeroPosition());

        playerPanel.remove(inventoryLabel);

        hub.setPlayerItems(inventory);
        setInventoryLabel(String.valueOf(inventory.size()));
        playerPanel.add(inventoryLabel);
    }
}
