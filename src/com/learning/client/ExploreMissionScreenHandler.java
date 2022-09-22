package com.learning.client;

import com.learning.view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;

public class ExploreMissionScreenHandler implements ActionListener {
    static ArrayList<JButton> allLocationsButtons = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        changeLocation();
    }

    static void changeLocation() {

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

        setHangarButton();
        setBasementButton();
        setEngineroomButton();
        setControlstationButton();
        setMesshallButton();
        setHallwayButton();
        setSpaceshipButton();

        allLocationsButtons.add(hangarButton);
        allLocationsButtons.add(basementButton);
        allLocationsButtons.add(engineroomButton);
        allLocationsButtons.add(controlstationButton);
        allLocationsButtons.add(messhallButton);
        allLocationsButtons.add(hallwayButton);
        allLocationsButtons.add(spaceshipButton);

        getNextLocationsButtons(hub.getHeroPosition());

        getListener(hangarButton);
        getListener(basementButton);
        getListener(engineroomButton);
        getListener(controlstationButton);
        getListener(messhallButton);
        getListener(hallwayButton);
        getListener(spaceshipButton);

        con = window.getContentPane();
        con.add(playerPanel);
        con.add(missionTitlePanel);
        con.add(locationsButtonPanel);

        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(currentMissionScreenHandler);
        //con.add(returnPanel);
        con.add(getLocationsButtonPanel());
    }

    public static void getNextLocationsButtons (String currentLocation) {
        for (Object location : mission.availableExits(currentLocation)) {
            for (JButton button : allLocationsButtons) {
                if (location.equals(button.getText())) {
                    locationsButtonPanel.add(button);
                }
            }
        }
    }

    public static void getListener(JButton button) {
        ChangeLocationHandler changeLocationHandler = new ChangeLocationHandler();
        button.addActionListener(changeLocationHandler);
    }
}


