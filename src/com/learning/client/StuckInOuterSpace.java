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
        String input = "welcome";
        // display Hero and some attributes
        System.out.println("          ___ _           _     _         ___       _             ___                  \n" +
                    "         / __| |_ _  _ __| |__ (_)_ _    / _ \\ _  _| |_ ___ _ _  / __|_ __ __ _ __ ___ \n" +
                    "         \\__ |  _| || / _| / / | | ' \\  | (_) | || |  _/ -_| '_| \\__ | '_ / _` / _/ -_)\n" +
                    "         |___/\\__|\\_,_\\__|_\\_\\ |_|_||_|  \\___/ \\_,_|\\__\\___|_|   |___| .__\\__,_\\__\\___|\n" +
                    "                                                             |_|               ");
        System.out.println("Name your hero: ");
        String hero = scanner.nextLine();
        System.out.println("Welcome " + hero + "!");
        Story.gameIntro();
        System.out.println("Type next to continue");
        String next = scanner.nextLine();
        Story.hub();



        //================================== STARTING THE GAME ===========================================//
        while(!input.equals("quit")){

            //=============================== ENTERING THE HUB ===========================================//
            while(!input.equals("quit")){
                // printing the main menu
                missions.getMainMenu();
                System.out.println("YWhat would you like to do next? ");
                String heroInput = scanner.nextLine();

                //============================ ACTIONS ITEMS FROM MENU ===================================//
                //------------------------ inventory, missions, help, quit ------------------------------
                if(heroInput.equalsIgnoreCase("inventory")){
                    missions.getInventoryMenu();
                    System.out.println("Which item would you like to look at? ");
                    String itemInput = scanner.nextLine();
                } else if (heroInput.equalsIgnoreCase("missions")) {
                    missions.getMissionsMenu();
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")){
                        StuckInOuterSpace.activateMission(missions, hub,"1");
                    } else {
                        break;
                    }
                } else if (heroInput.equalsIgnoreCase("help")) {
                    missions.getHelpMenu();
                } else if (heroInput.equalsIgnoreCase("quit")) {
                    input = heroInput;
                    // save the game before closing out.
                    hub.autoSaveGame();
                }
            }


        }

    }

    private static void activateMission(Mission mission, HubSpot hub, String chapter){
        // getters for items, locations, people save them to local variables.

        Scanner scanner = new Scanner(System.in);
        String heroInput = "null";
        Story.alienOutpost();
        
        while(!heroInput.equalsIgnoreCase("quit")){
            mission.getActiveMissionMenu();
            System.out.println("What would you like to do? ");
            heroInput = scanner.nextLine();
            System.out.println(heroInput);
            if(heroInput.equalsIgnoreCase("move")){
                StuckInOuterSpace.move(mission, hub);
            } else if (heroInput.equalsIgnoreCase("inventory")) {
                mission.getInventoryMenu();
                System.out.println("Which item would you like to look at? ");
                String itemInput = scanner.nextLine();
            }  else if (heroInput.equalsIgnoreCase("help")) {
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
