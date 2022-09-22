package com.learning.client;

import com.learning.view.Menu;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
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

        hangarButton.addActionListener(changeLocationHandler);
        basementButton.addActionListener(changeLocationHandler);
        engineroomButton.addActionListener(changeLocationHandler);
        controlstationButton.addActionListener(changeLocationHandler);
        messhallButton.addActionListener(changeLocationHandler);
        hallwayButton.addActionListener(changeLocationHandler);
        spaceshipButton.addActionListener(changeLocationHandler);

        con = window.getContentPane();
        con.add(playerPanel);
        con.add(missionTitlePanel);
        con.add(locationsButtonPanel);

        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(currentMissionScreenHandler);
        //con.add(returnPanel);
        con.add(getLocationsButtonPanel());
    }

    public static JPanel removeLocationsButtons () {
        locationsButtonPanel.remove(hangarButton);
        locationsButtonPanel.remove(basementButton);
        locationsButtonPanel.remove(engineroomButton);
        locationsButtonPanel.remove(controlstationButton);
        locationsButtonPanel.remove(messhallButton);
        locationsButtonPanel.remove(hallwayButton);
        locationsButtonPanel.remove(spaceshipButton);
        return locationsButtonPanel;
    }

    public static JPanel getNextLocationsButtons (String currentLocation) {
        for (Object location : mission.availableExits(currentLocation)) {
            for (JButton button : allLocationsButtons) {
                if (location.equals(button.getText())) {
                    locationsButtonPanel.add(button);
                }
            }
        }
        return locationsButtonPanel;
    }
}


