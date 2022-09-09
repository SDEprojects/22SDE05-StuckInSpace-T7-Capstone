package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
import com.learning.datamodel.Item;
import com.learning.view.Story;

import java.io.IOException;
import java.util.Scanner;

public class StuckInOuterSpace {
    public static void main(String[] args) throws IOException {
        /**
         * Introduction to the game
         * */
        Mission missions = new Mission();
        HubSpot hub = new HubSpot();
        Scanner scanner = new Scanner(System.in);
        String input = "not-exit";
        // display Hero and some attributes
        System.out.println("          ___ _           _     _         ___       _             ___                  \n" +
                "         / __| |_ _  _ __| |__ (_)_ _    / _ \\ _  _| |_ ___ _ _  / __|_ __ __ _ __ ___ \n" +
                "         \\__ |  _| || / _| / / | | ' \\  | (_) | || |  _/ -_| '_| \\__ | '_ / _` / _/ -_)\n" +
                "         |___/\\__|\\_,_\\__|_\\_\\ |_|_||_|  \\___/ \\_,_|\\__\\___|_|   |___| .__\\__,_\\__\\___|\n" +
                "                                                             |_|               ");

        // do you want to load a character? y/n
        // what is your characters name? take the name as input.
        // call hub to check and see if the save object has that name loaded.
        // if it does have that name. then load all its values to the appropriate classes.

        // the following will be a part of an if else check
        System.out.println("Name your hero: ");
        String name = scanner.nextLine();
        hub.setPlayerName(name);
        hub.showPlayerProfile();
        hub.initiateInventory(); // To add the items the Hero came with to the backpack.
        hub.initiateItemLocationList(); // Initiate the item list based on location.
        Story.gameIntro();
        System.out.println("Type next to continue");
        String next = scanner.nextLine();


        //================================== STARTING THE GAME ===========================================//
        while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {

            //=============================== ENTERING THE HUB ===========================================//
            while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {
                Story.hub();
                // printing the main menu
                missions.getMainMenu();
                System.out.println("What would you like to do next? ");
                String heroInput = scanner.nextLine();

                //============================ ACTIONS ITEMS FROM MENU ===================================//
                //------------------------ inventory, missions, help, quit ------------------------------
                if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("1")) {
                    missions.getInventoryMenu();
                    hub.showInventory();
                    System.out.println("Which item would you like to look at? ");
                    String itemInput = scanner.nextLine();
                    hub.showItemCard(itemInput);


                } else if (heroInput.equalsIgnoreCase("missions") || heroInput.equalsIgnoreCase("2")) {
                    missions.getMissionsMenu();
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if ((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")) {
                        missions.buildLocationMap("mission_01");
                        StuckInOuterSpace.activateMission(missions, hub);
                    } else {
                        break;
                    }
                } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                    missions.getHelpMenu();
                } else if (heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4")) {
                    input = heroInput;
                    hub.autoSaveGame();
                    // save the game before closing out.
                    // hub.autoSaveGame();
                }
            }
        }
    }

    private static void activateMission (Mission mission, HubSpot hub){
                    // getters for items, locations, people save them to local variables.

        Scanner scanner = new Scanner(System.in);
        String heroInput = "null";
        Story.alienOutpost();

        while (!(heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4"))) {
            // player status and health
            mission.getActiveMissionMenu();
            System.out.println("What would you like to do? ");
            heroInput = scanner.nextLine();
            System.out.println(heroInput);
            if (heroInput.equalsIgnoreCase("explore") || heroInput.equalsIgnoreCase("1")) {
                StuckInOuterSpace.exploreMission(mission, hub);
            } else if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("2")) {
                mission.getInventoryMenu();
                System.out.println("Which item would you like to look at? ");
                hub.showInventory();
                String itemInput = scanner.nextLine();
                hub.showItemCard(itemInput);

            } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                mission.getHelpMenu();
            }
        }
    }

    private static void exploreMission(Mission mission, HubSpot hub){
        Scanner scanner = new Scanner(System.in);
        String heroInput;

        Story.exploreOutpost();
        do {
            System.out.println("Where would you like to move to? ");
            mission.getMoveMenu(hub.getHeroPosition());
            heroInput = scanner.nextLine();
            if (heroInput.equalsIgnoreCase("look")) {

                // TODO Henry added some functions starts here.
                // call to check and see if there are items in this section of our locations.
                // if there is an item, give it to the player and add it to their inventory.

                mission.getLookMenu();
                hub.lookAction();
                // TODO, need to add condition when there is no item to pick.
                mission.getPickMenu();
                heroInput = scanner.nextLine();
                if (heroInput.equalsIgnoreCase("pick")) {
                    hub.addToInventory();
                }
                //TODO: KEN - if they found the engine in the engineroom, then we need to unlock then story ending.


                // TODO Henry added functions ends here.
            } else if (heroInput.equalsIgnoreCase("help")) {
                mission.getMoveHelpMenu(hub.getHeroPosition());
            } else if (!heroInput.equalsIgnoreCase("leave")) {
                if (mission.isExitAvailable(hub.getHeroPosition(), heroInput)) {
                    if(hub.getHeroPosition().equalsIgnoreCase("basement") && heroInput.equalsIgnoreCase("engineroom")){
                        boolean hasKeyCard = false;
                        for (String item: hub.getPlayerItems()) {
                            if (item.equalsIgnoreCase("keycard")){
                                hasKeyCard = true;
                                System.out.println("You had the key card and was able to move into the engine room.");
                                hub.setHeroPosition(heroInput);
                            }
                        }
                        if(hasKeyCard == false){
                            System.out.println("You need a key card to get into this room, you should look around some more.");
                        }
                    } else if (hub.getHeroPosition().equals("hallway") && heroInput.equalsIgnoreCase("basement")) {
                        boolean hasKeyCard = false;
                        for (String item: hub.getPlayerItems()) {
                            if (item.equalsIgnoreCase("basement_key")){
                                hasKeyCard = true;
                                System.out.println("You had the basement key and was able to move into the basement.");
                                hub.setHeroPosition(heroInput);
                            }
                        }
                        if(hasKeyCard == false){
                            System.out.println("You need a basement key to get into this room, you should look around some more.");
                        }

                    } else{
                        hub.setHeroPosition(heroInput);
                    }
                }
            }
        } while (!heroInput.equalsIgnoreCase("leave"));
    }

}

