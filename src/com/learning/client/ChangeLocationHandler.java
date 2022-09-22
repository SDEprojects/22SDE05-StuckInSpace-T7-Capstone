package com.learning.client;

import com.learning.view.Menu;
import com.learning.view.Story;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static com.learning.client.ExploreMissionScreenHandler.allLocationsButtons;
import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;


public class ChangeLocationHandler implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == hangarButton) {
            updateLocationInformation(hangarButton);
        }
        if (e.getSource() == basementButton) {
            updateLocationInformation(basementButton);
        }
        if (e.getSource() == engineroomButton) {
            updateLocationInformation(engineroomButton);
        }
        if (e.getSource() == controlstationButton) {
            updateLocationInformation(controlstationButton);
        }
        if (e.getSource() == messhallButton) {
            updateLocationInformation(messhallButton);
        }
        if (e.getSource() == hallwayButton) {
            updateLocationInformation(hallwayButton);
        }
        if (e.getSource() == spaceshipButton) {
            updateLocationInformation(spaceshipButton);
        }
    }

    public static void updateLocationInformation(JButton button) {
        playerPanel.remove(locLabel);
        hub.setHeroPosition(button.getText());
        setPlayerPanel();

        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());

        setLocationsButtonPanel();
        ExploreMissionScreenHandler.getNextLocationsButtons(hub.getHeroPosition());

        con = window.getContentPane();
        con.add(playerPanel);
        con.add(locationsButtonPanel);
    }
}
