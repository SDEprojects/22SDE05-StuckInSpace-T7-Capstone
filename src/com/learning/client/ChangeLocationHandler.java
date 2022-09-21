package com.learning.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;


public class ChangeLocationHandler implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        changeLocation(ExploreMissionScreenHandler.changeLocation());
    }

    private void changeLocation(String nextLocation) {
        setPlayerPanel();
        hub.setHeroPosition(nextLocation);
        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());

        setLocationsButtonPanel();
        for (Object location : mission.availableExits(hub.getHeroPosition())) {
            setNextLocationButton((String) location);
            locationsButtonPanel.add(nextLocationButton);
            con.add(locationsButtonPanel);
        }
        con = window.getContentPane();
        con.add(playerPanel);
        con.add(locationsButtonPanel);
    }
}
