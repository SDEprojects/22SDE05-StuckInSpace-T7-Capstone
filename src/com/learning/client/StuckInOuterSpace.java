//package com.learning.client;
//
//import com.learning.controller.HubSpot;
//import com.learning.controller.Mission;
//import com.learning.view.Menu;
//import com.learning.view.Story;
//
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.SortedMap;
//
//import static com.learning.controller.HubSpot.checkInventoryInputType;
//
//public class StuckInOuterSpace {
//
//    public static void main(String[] args) throws IOException {
//        //Introduction to the game
//        Mission missions = new Mission();
//        HubSpot hub = new HubSpot();
//        Scanner scanner = new Scanner(System.in);
//        String input = "not-exit";
//        // display Hero and some attributes
//        System.out.println("          ___ _           _     _         ___       _             ___                  \n" +
//                "         / __| |_ _  _ __| |__ (_)_ _    / _ \\ _  _| |_ ___ _ _  / __|_ __ __ _ __ ___ \n" +
//                "         \\__ |  _| || / _| / / | | ' \\  | (_) | || |  _/ -_| '_| \\__ | '_ / _` / _/ -_)\n" +
//                "         |___/\\__|\\_,_\\__|_\\_\\ |_|_||_|  \\___/ \\_,_|\\__\\___|_|   |___| .__\\__,_\\__\\___|\n" +
//                "                                                             |_|               ");
//
//        //================================== LOADING THE GAME/NEW GAME ===========================================//
//
//        // call hub to check and see if the save object has that name loaded.
//        // if it does have that name. then load all its values to the appropriate classes.
//
//        System.out.println("-------------------------------------------------------------------------------------------- \n" +
//                "             |     1.New Game           |--------|     2.Load Game    |\n" +
//                "--------------------------------------------------------------------------------------------\n");
//        String gameInput = scanner.nextLine();
//        while (true) {
//            if (gameInput.equalsIgnoreCase("1") || gameInput.equalsIgnoreCase("new game")) {
//                //START NEW GAME
//                System.out.println("Name your hero: ");
//                String name = scanner.nextLine();
//                hub.setPlayerName(name);
//                hub.showPlayerProfile();
//                hub.initiateInventory(); // To add the items the Hero came with to the backpack.
//                hub.initiateItemLocationList();// Initiate the item list based on location.
//                Story.gameIntro();
//                System.out.println("Type next to continue");
//                String next = scanner.nextLine();
//                break;
//            } else if (gameInput.equalsIgnoreCase("2") || gameInput.equalsIgnoreCase("load game")) {
//                hub.loadSavedGame(hub.getSavegame().getSavePlayerName(), hub.getSavegame().getSavePlayerInventory());
//                hub.initiateItemLocationList();
//                System.out.println("Welcome back to the game " + hub.getPlayerName());
//                hub.showPlayerProfile();
//                break;
//            } else {
//                System.out.println("Please put a valid option for your game settings.");
//                System.out.println("-------------------------------------------------------------------------------------------- \n" +
//                        "             |     1.New Game           |--------|     2.Load Game    |\n" +
//                        "--------------------------------------------------------------------------------------------\n");
//                gameInput = scanner.nextLine();
//            }
//        }
//
//        //================================== STARTING THE GAME ===========================================//
//        while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {
//
//            //=============================== ENTERING THE HUB ===========================================//
//            while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {
//                Story.hub();
//                // printing the main menu
//                missions.getMainMenu();
//                System.out.println("What would you like to do next? ");
//                String heroInput = scanner.nextLine();
//
//                //============================ ACTIONS ITEMS FROM MENU ===================================//
//                //------------------------ inventory, missions, help, quit ------------------------------
//                if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("1")) {
//                    missions.getInventoryMenu();
//
//                    hub.showInventory();
//                    System.out.println("Which item would you like to look at? Please enter the number.");
//
//                    while (true) {
//                        String itemInput = scanner.nextLine();
//                        if (checkInventoryInputType(itemInput)) {
//                            if (Integer.parseInt(itemInput) > hub.getPlayerItems().size()) {
//                                System.out.println("Number you entered is not valid, please enter number that is corresponding to items being displayed. ");
//                            } else {
//                                hub.showItemCard(itemInput);
//                                break;
//                            }
//                        } else {
//                            System.out.println("Please enter valid number only");
//                        }
//                    }
//                } else if (heroInput.equalsIgnoreCase("missions") || heroInput.equalsIgnoreCase("2")) {
//                    missions.getMissionsMenu();
//                    System.out.println("Which mission would you like to try? ");
//                    String missionInput = scanner.nextLine();
//                    if ((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")) {
//                        missions.buildLocationMap("mission_01");
//                        StuckInOuterSpace.activateMission(missions, hub);
//                    }
//                } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
//                    missions.getHelpMenu();
//                } else if (heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4")) {
//                    input = heroInput;
//                    hub.autoSaveGame();
//                    // save the game before closing out.
//                    // hub.autoSaveGame();
//                }
//            }
//        }
//    }
//
//    private static void activateMission(Mission mission, HubSpot hub) {
//        // getters for items, locations, people save them to local variables.
//
//        Scanner scanner = new Scanner(System.in);
//        String heroInput = "null";
//        Story.alienOutpost();
//
//        while (!(heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4"))) {
//            // player status and health
//            mission.getActiveMissionMenu();
//            System.out.println("What would you like to do? ");
//            heroInput = scanner.nextLine();
////            System.out.println(heroInput);
//
//            if (exploreMission(mission, hub)) {
//                heroInput = "quit";
//            }
//            if (heroInput.equalsIgnoreCase("explore") || heroInput.equalsIgnoreCase("1")) {
//                StuckInOuterSpace.exploreMission(mission, hub);
//            } else if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("2")) {
//                mission.getInventoryMenu();
//                System.out.println("Which item would you like to look at? Please enter the number.");
//                hub.showInventory();
//                while (true) {
//                    String itemInput = scanner.nextLine();
//                    if (checkInventoryInputType(itemInput)) {
//                        if (Integer.parseInt(itemInput) > hub.getPlayerItems().size()) {
//                            System.out.println("Number you entered is not valid, please enter number that is corresponding to items being displayed. ");
//                        } else {
//                            hub.showItemCard(itemInput);
//                            break;
//                        }
//                    } else {
//                        System.out.println("Please enter valid number only");
//                    }
//                }
//            } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
//                mission.getHelpMenu();
//            }
//
//        }
//
//    }
//    static boolean isWin;
//    private static boolean exploreMission(Mission mission, HubSpot hub) {
//        Scanner scanner = new Scanner(System.in);
//        String heroInput;
//        Story.exploreOutpost();
//        do {
//            isWin = false;
//            System.out.println("Where would you like to move to? ");
//            mission.getMoveMenu(hub.getHeroPosition());
//            heroInput = scanner.nextLine();
//
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
//                //TODO: KEN - if they found the engine in the engineroom, then we need to unlock then story ending.
//                // if(item.equals("engine") && hub.getPlayerLocation().equals("engineRoom"))
//                //          Story.ending()
//                //          when they quit and go back to hub, they should escape with the new engine?
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
//        return isWin;
//    }
//}
//
