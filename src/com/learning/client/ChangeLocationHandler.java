package com.learning.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;


public class ChangeLocationHandler implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        changeLocation();
    }

    private void changeLocation() {
        hub.setHeroPosition("TEST");
        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());
        con = window.getContentPane();
        con.add(playerPanel);
        //con.add(missionTitlePanel);
        con.add(locationsButtonPanel);
    }
}
