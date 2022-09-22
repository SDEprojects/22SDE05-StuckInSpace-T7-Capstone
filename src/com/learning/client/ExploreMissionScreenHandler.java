package com.learning.client;

import com.learning.view.Menu;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;

public class ExploreMissionScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        changeLocation();
    }

    static void changeLocation() {

        ExploreMissionScreenHandler exploreMissionScreenHandler = new ExploreMissionScreenHandler();
        ChangeLocationHandler changeLocationHandler = new ChangeLocationHandler();
        CurrentMissionScreenHandler currentMissionScreenHandler = new CurrentMissionScreenHandler();

        titlePanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/hangar2.jpg")));

        setPlayerPanel();
        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());

        setMissionTitlePanel(setMissionTitleLabel("You can go to: "));
        setLocationsButtonPanel();
        for (Object location : mission.availableExits(hub.getHeroPosition())) {
            setNextLocationButton((String) location);
            locationsButtonPanel.add(nextLocationButton);
            con.add(locationsButtonPanel);
            nextLocationButton.addActionListener(changeLocationHandler);
        }
        con = window.getContentPane();
        con.add(playerPanel);
        con.add(missionTitlePanel);
        con.add(locationsButtonPanel);

        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(currentMissionScreenHandler);
        con.add(returnPanel);
        con.add(getLocationsButtonPanel());
    }

    public static void main(String[] args) {
        String nextLocation = "";
        //System.out.println(hub.getHeroPosition());
        hub.setHeroPosition("hallway");

        for (Object location : mission.availableExits(hub.getHeroPosition())) {
            //System.out.println((String) location);
            setNextLocationButton((String) location);
            //locationsButtonPanel.add(nextLocationButton);
            //con.add(locationsButtonPanel);
            nextLocation = nextLocationButton.getText();
            System.out.println(nextLocation);
        }
    }
}


