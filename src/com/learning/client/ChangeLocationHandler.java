package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;


public class ChangeLocationHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == hangarButton) {
            updateLocationInformation(hangarButton);
            updateAvailableItemsInformation(hangarButton);
        } else if (e.getSource() == basementButton) {
            updateLocationInformation(basementButton);
            updateAvailableItemsInformation(basementButton);
        } else if (e.getSource() == engineroomButton) {
            updateLocationInformation(engineroomButton);
            updateAvailableItemsInformation(engineroomButton);
        } else if (e.getSource() == controlstationButton) {
            updateLocationInformation(controlstationButton);
            updateAvailableItemsInformation(controlstationButton);
        } else if (e.getSource() == messhallButton) {
            updateLocationInformation(messhallButton);
            updateAvailableItemsInformation(messhallButton);
        } else if (e.getSource() == hallwayButton) {
            updateLocationInformation(hallwayButton);
            updateAvailableItemsInformation(hallwayButton);
        } else if (e.getSource() == spaceshipButton) {
            updateLocationInformation(spaceshipButton);
            updateAvailableItemsInformation(spaceshipButton);
        }
    }

    public static void updateLocationInformation(JButton button) {
        playerPanel.remove(locLabel);
        locationsButtonPanel.setVisible(false);
        hub.setHeroPosition(button.getText());

        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());

        setLocationsButtonPanel();
        ExploreMissionScreenHandler.getNextLocationsButtons(hub.getHeroPosition());

        con = window.getContentPane();
        con.add(playerPanel);
        con.add(locationsButtonPanel);
    }

    public static void updateAvailableItemsInformation(JButton button) {
        inventoryButtonsPanel.setVisible(false);
        hub.setHeroPosition(button.getText());

        setInventoryButtonsPanel();
        ExploreMissionScreenHandler.getInventoryItemsButtons(hub.getHeroPosition());

        con = window.getContentPane();
        con.add(inventoryButtonsPanel);
    }
}
