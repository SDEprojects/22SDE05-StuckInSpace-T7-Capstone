package com.learning.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameGui.compassButton;
import static com.learning.client.GameManager.hub;

public class ItemHandler implements ActionListener {
    int itemCount = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fuelButton) {
            fuelButton.setVisible(false);
            hub.addItemToInventory(fuelButton.getText());
        } else if (e.getSource() == engineButton) {
            engineButton.setVisible(false);
            hub.addItemToInventory(engineButton.getText());
        } else if (e.getSource() == bioSuitButton) {
            bioSuitButton.setVisible(false);
            hub.addItemToInventory(bioSuitButton.getText());
        } else if (e.getSource() == tmButton) {
            tmButton.setVisible(false);
            hub.addItemToInventory(tmButton.getText());
        } else if (e.getSource() == keyCardButton) {
            keyCardButton.setVisible(false);
            hub.addItemToInventory(keyCardButton.getText());
        } else if (e.getSource() == basementKeyButton) {
            basementKeyButton.setVisible(false);
            hub.addItemToInventory(basementKeyButton.getText());
        } else if (e.getSource() == toolkitButton) {
            toolkitButton.setVisible(false);
            hub.addItemToInventory(toolkitButton.getText());
        } else if (e.getSource() == gpsButton) {
            gpsButton.setVisible(false);
            hub.addItemToInventory(gpsButton.getText());
        } else if (e.getSource() == knifeButton) {
            knifeButton.setVisible(false);
            hub.addItemToInventory(knifeButton.getText());
        } else if (e.getSource() == rifleButton) {
            rifleButton.setVisible(false);
            hub.addItemToInventory(rifleButton.getText());
        } else if (e.getSource() == pistolButton) {
            pistolButton.setVisible(false);
            hub.addItemToInventory(pistolButton.getText());
        } else if (e.getSource() == laserGunButton) {
            laserGunButton.setVisible(false);
            hub.addItemToInventory(laserGunButton.getText());
        } else if (e.getSource() == imtvButton) {
            imtvButton.setVisible(false);
            hub.addItemToInventory(imtvButton.getText());
        } else if (e.getSource() == achButton) {
            achButton.setVisible(false);
            hub.addItemToInventory(achButton.getText());
        } else if (e.getSource() == glovesButton) {
            glovesButton.setVisible(false);
            hub.addItemToInventory(glovesButton.getText());
        } else if (e.getSource() == bootsButton) {
            bootsButton.setVisible(false);
            hub.addItemToInventory(bootsButton.getText());
        } else if (e.getSource() == compassButton) {
            compassButton.setVisible(false);
            hub.addItemToInventory(compassButton.getText());
        }
    }

    public static void updateInventoryCount() {

    }
}
