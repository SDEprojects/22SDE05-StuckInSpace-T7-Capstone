package com.learning.client;

import com.learning.view.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;

public class ExploreMissionScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        changeLocation();
    }

    static String changeLocation() {
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
        //setMissionTitlePanel(setMissionTitleLabel("Where would you like to move to? "));

        setMissionTitlePanel(setMissionTitleLabel("You can go to: "));
        setLocationsButtonPanel();
        for (Object location : mission.availableExits(hub.getHeroPosition())) {
            setNextLocationButton((String) location);
            locationsButtonPanel.add(nextLocationButton);
            con.add(locationsButtonPanel);
            nextLocationButton.addActionListener(changeLocationHandler);
        }


//            if (heroInput.equalsIgnoreCase("look")) {
//
//                mission.getLookMenu();
//                hub.lookAction();
//
//                // Condition when there is no item to pick.
//                if (hub.itemFoundHere() && !hub.getPlayerItems().contains(hub.getItem().getItemFound().get(0))) {
//                    mission.getPickMenu();
//                    heroInput = scanner.nextLine();
//                    if (heroInput.equalsIgnoreCase("pick")) {
//                        hub.addToInventory();
//                    }
//                }
//
//            } else if (hub.getHeroPosition().equals("start") && heroInput.equalsIgnoreCase("spaceship")) {
//                boolean hasEngine = false;
//                for (String item : hub.getPlayerItems()) {
//                    if (item.equalsIgnoreCase("engine")) {
//                        hasEngine = true;
//                        if (hub.getPlayerItems().size() > 10) {
//                            System.out.println("You had an engine and enough items to get into the spaceship. Congratulations! You win this mission!");
//                            hub.getPlayerItems().subList(2, hub.getPlayerItems().size()).clear();
//                            isWin = true;
//                            break;
//                        } else {
//                            System.out.println("You found the engine, but you need more items to enter the spaceship to win this mission.");
//                        }
//                    }
//                }
//                if (!hasEngine) {
//                    System.out.println("You need to find engine and other items to get into the spaceship and win this mission. You should look around some more.");
//                }
//                break;
//            } else if (heroInput.equalsIgnoreCase("help")) {
//                mission.getMoveHelpMenu(hub.getHeroPosition());
//
//                //God mode
//            } else if (heroInput.equalsIgnoreCase("goddess")) {
//                hub.setPlayerItems(hub.godMode());
//                hub.getPlayerItems();
//                System.out.println(hub.getPlayerItems());
//
//            } else if (!heroInput.equalsIgnoreCase("leave")) {
//                if (mission.isExitAvailable(hub.getHeroPosition(), heroInput)) {
//                    if (hub.getHeroPosition().equalsIgnoreCase("basement") && heroInput.equalsIgnoreCase("engineroom")) {
//                        boolean hasKeyCard = false;
//                        for (String item : hub.getPlayerItems()) {
//                            if (item.equalsIgnoreCase("keycard")) {
//                                hasKeyCard = true;
//                                System.out.println("You had the key card and was able to move into the engine room.");
//                                hub.setHeroPosition(heroInput);
//                            }
//                        }
//                        if (!hasKeyCard) {
//                            System.out.println("You need a key card to get into this room, you should look around some more.");
//                        }
//                    } else if (hub.getHeroPosition().equals("hallway") && heroInput.equalsIgnoreCase("basement")) {
//                        boolean hasKeyCard = false;
//                        for (String item : hub.getPlayerItems()) {
//                            if (item.equalsIgnoreCase("basement_key")) {
//                                hasKeyCard = true;
//                                System.out.println("You had the basement key and was able to move into the basement.");
//                                hub.setHeroPosition(heroInput);
//                            }
//                        }
//                        if (!hasKeyCard) {
//                            System.out.println("You need a basement key to get into this room, you should look around some more.");
//                        }
//                    } else {
//                        hub.setHeroPosition(heroInput.toLowerCase().replaceAll("\\s", ""));
//                    }
//                }
//            }
//        } while (!heroInput.equalsIgnoreCase("leave") || isWin);


//            setLocationsButtonPanel();
//            for (Object location : mission.availableExits(hub.getHeroPosition())) {
//                setNextLocationButton((String) location);
//                locationsButtonPanel.add(nextLocationButton);
//                con.add(getLocationsButtonPanel());
//            }


        con = window.getContentPane();
        con.add(playerPanel);
        con.add(missionTitlePanel);
        con.add(locationsButtonPanel);

        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(currentMissionScreenHandler);
        con.add(returnPanel);
        con.add(getLocationsButtonPanel());
        return nextLocationButton.getText();
    }
}


