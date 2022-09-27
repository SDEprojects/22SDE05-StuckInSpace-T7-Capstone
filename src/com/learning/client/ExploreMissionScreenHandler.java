package com.learning.client;

import com.learning.view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;

public class ExploreMissionScreenHandler implements ActionListener {
    static ArrayList<JButton> allLocationsButtons = new ArrayList<>();
    static ArrayList<JButton> allInventoryButtons = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            changeLocation();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void changeLocation() throws InterruptedException {
        ChangeLocationHandler changeLocationHandler = new ChangeLocationHandler();
        CurrentMissionScreenHandler currentMissionScreenHandler = new CurrentMissionScreenHandler();

        titlePanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/hangar2.jpg")));
        window.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(ExploreMissionScreenHandler.class.getClassLoader().getResource("hangar2.jpg")))));
        con = window.getContentPane();

        setPlayerPanel();
        setLocLabel(hub.getHeroPosition());
        playerPanel.add(getLocLabel());
        setInventoryLabel(String.valueOf(hub.getPlayerItems().size()));
        playerPanel.add(inventoryLabel);

        setExploreMissionPanel(setExploreMissionLabel("You can go to: "));

        setExploreInventoryPanel(setExploreInventoryLabel("Available items (click to get item): "));

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

        getLocationListener(hangarButton);
        getLocationListener(basementButton);
        getLocationListener(engineroomButton);
        getLocationListener(controlstationButton);
        getLocationListener(messhallButton);
        getLocationListener(hallwayButton);
        getLocationListener(spaceshipButton);

        setInventoryButtonsPanel();

        setFuelButton();
        setEngineButton();
        setBioSuitButton();
        setTmButton();
        setKeyCardButton();
        setBasementKeyButton();
        setToolkitButton();
        setGpsButton();
        setKnifeButton();
        setRifleButton();
        setPistolButton();
        setLaserGunButton();
        setImtvButton();
        setAchButton();
        setGlovesButton();
        setBootsButton();
        setCompassButton();

        allInventoryButtons.add(fuelButton);
        allInventoryButtons.add(engineButton);
        allInventoryButtons.add(bioSuitButton);
        allInventoryButtons.add(tmButton);
        allInventoryButtons.add(keyCardButton);
        allInventoryButtons.add(basementKeyButton);
        allInventoryButtons.add(toolkitButton);
        allInventoryButtons.add(gpsButton);
        allInventoryButtons.add(knifeButton);
        allInventoryButtons.add(rifleButton);
        allInventoryButtons.add(pistolButton);
        allInventoryButtons.add(laserGunButton);
        allInventoryButtons.add(imtvButton);
        allInventoryButtons.add(achButton);
        allInventoryButtons.add(glovesButton);
        allInventoryButtons.add(bootsButton);
        allInventoryButtons.add(compassButton);

        getInventoryItemsButtons(hub.getHeroPosition());

        getItemListener(fuelButton);
        getItemListener(engineButton);
        getItemListener(bioSuitButton);
        getItemListener(tmButton);
        getItemListener(keyCardButton);
        getItemListener(basementKeyButton);
        getItemListener(toolkitButton);
        getItemListener(gpsButton);
        getItemListener(knifeButton);
        getItemListener(rifleButton);
        getItemListener(pistolButton);
        getItemListener(laserGunButton);
        getItemListener(imtvButton);
        getItemListener(achButton);
        getItemListener(glovesButton);
        getItemListener(bootsButton);
        getItemListener(compassButton);

        con = window.getContentPane();
        con.add(playerPanel);
        con.add(exploreMissionPanel);
        con.add(exploreInventoryPanel);
        con.add(locationsButtonPanel);
        con.add(inventoryButtonsPanel);

        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(currentMissionScreenHandler);
        //con.add(returnPanel);

        setCountTimeLabel();
        countTimeLabel.setText("1:30");
        TimeHandler.second = 30;
        TimeHandler.minute = 1;
        TimeHandler.setTimer();
        TimeHandler.timer.start();
        playerPanel.add(countTimeLabel);
    }

    public static void getNextLocationsButtons(String currentLocation) {
        for (Object location : mission.availableExits(currentLocation)) {
            for (JButton button : allLocationsButtons) {

                if (location.equals(button.getText())) {
                    locationsButtonPanel.add(button);
                }
            }
        }
    }

    public static void getLocationListener(JButton button) {
        ChangeLocationHandler changeLocationHandler = new ChangeLocationHandler();
        button.addActionListener(changeLocationHandler);
    }

    public static void getInventoryItemsButtons(String currentLocation) {
        hub.initiateItemLocationList();
        for (Object item : hub.lookAction(currentLocation)) {
            for (JButton button : allInventoryButtons) {
                if (item.equals(button.getText())) {
                    inventoryButtonsPanel.add(button);
                }
            }
        }
    }

    public static void getItemListener(JButton button) {
        ItemHandler itemHandler = new ItemHandler();
        button.addActionListener(itemHandler);
    }
    //Deny access to engineroom
    //public static void accessEngineroom(ActionEvent e, ){}
    //Deny access to ship
    /*public static boolean checkWinCondition(){
    if ()
    }*/
}


