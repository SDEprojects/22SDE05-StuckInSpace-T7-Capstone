package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
import com.learning.view.Story;

import java.util.Scanner;

import static com.learning.controller.HubSpot.checkInventoryInputType;

public class MissionManager {

    public static void activateMission(Mission mission, HubSpot hub) {

        Scanner scanner = new Scanner(System.in);
        String heroInput = "null";
        Story.alienOutpost();

        while (!(heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4"))) {
            do{
                // player status and health
                mission.getActiveMissionMenu();
                System.out.println("What would you like to do? ");
                heroInput = scanner.nextLine();

                if (heroInput.equalsIgnoreCase("explore") || heroInput.equalsIgnoreCase("1")) {
                    exploreMission(mission, hub);
                } else if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("2")) {
                    mission.getInventoryMenu();
                    System.out.println("Which item would you like to look at? Please enter the number.");
                    hub.showInventory();
                    while (true) {
                        String itemInput = scanner.nextLine();
                        if (checkInventoryInputType(itemInput)) {
                            if (Integer.parseInt(itemInput) > hub.getPlayerItems().size() || Integer.parseInt(itemInput) < 1) {
                                System.out.println("Number you entered is not valid, please enter number that is corresponding to items being displayed. ");
                            } else {
                                hub.showItemCard(itemInput);
                                break;
                            }
                        } else {
                            System.out.println("Please enter valid number only");
                        }
                    }
                } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                    mission.getHelpMenu();
                }
            } while (!isWin);
            heroInput = "quit";
        }

    }

    static boolean isWin;

    public static boolean exploreMission(Mission mission, HubSpot hub) {
        Scanner scanner = new Scanner(System.in);
        String heroInput;
        Story.exploreOutpost();
        do {
            isWin = false;
            System.out.println("Where would you like to move to? ");
            mission.getMoveMenu(hub.getHeroPosition());
            heroInput = scanner.nextLine();

            if (heroInput.equalsIgnoreCase("look")) {

                mission.getLookMenu();
                hub.lookAction();

                // Condition when there is no item to pick.
                if (hub.itemFoundHere() && !hub.getPlayerItems().contains(hub.getItem().getItemFound().get(0))) {
                    mission.getPickMenu();
                    heroInput = scanner.nextLine();
                    if (heroInput.equalsIgnoreCase("pick")) {
                        hub.addToInventory();
                    }
                }
                //TODO: KEN - if they found the engine in the engineroom, then we need to unlock then story ending.
                // if(item.equals("engine") && hub.getPlayerLocation().equals("engineRoom"))
                //          Story.ending()
                //          when they quit and go back to hub, they should escape with the new engine?

            } else if (hub.getHeroPosition().equals("start") && heroInput.equalsIgnoreCase("spaceship")) {
                boolean hasEngine = false;
                for (String item : hub.getPlayerItems()) {
                    if (item.equalsIgnoreCase("engine")) {
                        hasEngine = true;
                        if (hub.getPlayerItems().size() > 10) {
                            System.out.println("You had an engine and enough items to get into the spaceship. Congratulations! You win this mission!");
                            hub.getPlayerItems().subList(2, hub.getPlayerItems().size()).clear();
                            isWin = true;
                            break;
                        } else {
                            System.out.println("You found the engine, but you need more items to enter the spaceship to win this mission.");
                        }
                    }
                }
                if (!hasEngine) {
                    System.out.println("You need to find engine and other items to get into the spaceship and win this mission. You should look around some more.");
                }
                break;
            } else if (heroInput.equalsIgnoreCase("help")) {
                mission.getMoveHelpMenu(hub.getHeroPosition());
            } else if (!heroInput.equalsIgnoreCase("leave")) {
                if (mission.isExitAvailable(hub.getHeroPosition(), heroInput)) {
                    if (hub.getHeroPosition().equalsIgnoreCase("basement") && heroInput.equalsIgnoreCase("engineroom")) {
                        boolean hasKeyCard = false;
                        for (String item : hub.getPlayerItems()) {
                            if (item.equalsIgnoreCase("keycard")) {
                                hasKeyCard = true;
                                System.out.println("You had the key card and was able to move into the engine room.");
                                hub.setHeroPosition(heroInput);
                            }
                        }
                        if (!hasKeyCard) {
                            System.out.println("You need a key card to get into this room, you should look around some more.");
                        }
                    } else if (hub.getHeroPosition().equals("hallway") && heroInput.equalsIgnoreCase("basement")) {
                        boolean hasKeyCard = false;
                        for (String item : hub.getPlayerItems()) {
                            if (item.equalsIgnoreCase("basement_key")) {
                                hasKeyCard = true;
                                System.out.println("You had the basement key and was able to move into the basement.");
                                hub.setHeroPosition(heroInput);
                            }
                        }
                        if (!hasKeyCard) {
                            System.out.println("You need a basement key to get into this room, you should look around some more.");
                        }
                    } else {
                        hub.setHeroPosition(heroInput.toLowerCase().replaceAll("\\s", ""));
                    }
                }
            }
        } while (!heroInput.equalsIgnoreCase("leave") || isWin);
        return isWin;
    }
}
