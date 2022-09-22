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

        if (e.getSource() == hallwayButton) {
            playerPanel.remove(locLabel);
            hub.setHeroPosition(hallwayButton.getText());
            setPlayerPanel();
            setLocLabel(hub.getHeroPosition());
            playerPanel.add(getLocLabel());

            setLocationsButtonPanel();
            for (Object location : mission.availableExits(hub.getHeroPosition())) {
                for (JButton button : allLocationsButtons) {
                    if (location.equals(button.getText())) {
                        locationsButtonPanel.add(button);
                    }
                }
            }
            con = window.getContentPane();
            con.add(playerPanel);
            con.add(locationsButtonPanel);




//
//
//
//
//            if (Objects.equals(nextLocationButton.getText(), "spaceship")) {
//                playerPanel.remove(locLabel);
//                hub.setHeroPosition(nextLocationButton.getText());
//                setPlayerPanel();
//                setLocLabel(hub.getHeroPosition());
//                playerPanel.add(getLocLabel());
//                con = window.getContentPane();
//                con.add(playerPanel);
//                nextLocationButton.setText("The button clicked");
//            }
        }
    }
}
