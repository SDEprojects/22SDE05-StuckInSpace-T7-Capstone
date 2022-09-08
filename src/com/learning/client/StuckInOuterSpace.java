package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
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
        System.out.println("  ___ _           _     _         ___       _             ___                  \n" +
                    " / __| |_ _  _ __| |__ (_)_ _    / _ \\ _  _| |_ ___ _ _  / __|_ __ __ _ __ ___ \n" +
                    " \\__ |  _| || / _| / / | | ' \\  | (_) | || |  _/ -_| '_| \\__ | '_ / _` / _/ -_)\n" +
                    " |___/\\__|\\_,_\\__|_\\_\\ |_|_||_|  \\___/ \\_,_|\\__\\___|_|   |___| .__\\__,_\\__\\___|\n" +
                    "                                                             |_|               ");
        System.out.println("Name your hero: ");
        String name = scanner.nextLine();
        hub.setPlayerName(name);
        hub.showPlayerProfile();
        Story.gameIntro();
        Story.hub();

        //================================== STARTING THE GAME ===========================================//
        while(!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))){

            //=============================== ENTERING THE HUB ===========================================//
            while(!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))){
                // printing the main menu
                missions.getMainMenu();
                System.out.println("You find yourself sitting in the bay of the ship, what's the next move? ");
                String heroInput = scanner.nextLine();

                //============================ ACTIONS ITEMS FROM MENU ===================================//
                //------------------------ inventory, missions, help, quit ------------------------------
                if(heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("1")){
                    missions.getInventoryMenu();
                    System.out.println("Which item would you like to look at? ");
                    String itemInput = scanner.nextLine();
                } else if (heroInput.equalsIgnoreCase("missions") || heroInput.equalsIgnoreCase("2")) {
                    missions.getMissionsMenu();
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")){
                        missions.buildLocationMap("mission_01");
                        StuckInOuterSpace.activateMission(missions, hub);
                    } else {
                        break;
                    }
                } else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                    missions.getHelpMenu();
                } else if (heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4")) {
                    input = heroInput;
                    // save the game before closing out.
                    hub.autoSaveGame();
                }
            }


        }

    }

    private static void activateMission(Mission mission, HubSpot hub){
        // getters for items, locations, people save them to local variables.

        Scanner scanner = new Scanner(System.in);
        String heroInput = "null";
        Story.alienOutpost();
        
        while(!(heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4"))){
            mission.getActiveMissionMenu();
            System.out.println("What would you like to do? ");
            heroInput = scanner.nextLine();
            System.out.println(heroInput);
            if(heroInput.equalsIgnoreCase("move") || heroInput.equalsIgnoreCase("1")){
                StuckInOuterSpace.move(mission, hub);
            } else if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("2")) {
                mission.getInventoryMenu();
                System.out.println("Which item would you like to look at? ");
                String itemInput = scanner.nextLine();
            }  else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                mission.getHelpMenu();
            }
        }
    }

    private static void move(Mission mission, HubSpot hub){
        Scanner scanner = new Scanner(System.in);
        String heroInput;

        Story.exploreOutpost();
        do {
            System.out.println("Where would you like to move to? ");
            mission.getMoveMenu(hub.getHeroPosition());
            heroInput = scanner.nextLine();
            if (heroInput.equalsIgnoreCase("look")){
                System.out.println("Your hero takes the time to investigate his surroundings.");
            } else if (heroInput.equalsIgnoreCase("help")) {
                mission.getMoveHelpMenu(hub.getHeroPosition());
            } else if (!heroInput.equalsIgnoreCase("leave")) {
                if(mission.isExitAvailable(hub.getHeroPosition(), heroInput)){
                    hub.setHeroPosition(heroInput);
                }
                else{

                }
            }
        }while(!heroInput.equalsIgnoreCase("leave"));
    }



}
