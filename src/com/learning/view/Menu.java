package com.learning.view;

import org.json.simple.JSONArray;

import java.util.*;

public class Menu {


    // private ArrayList<Item> currentItems = new ArrayList<>();
    private ArrayList<String> missionNames = new ArrayList<>();

    public void addMissionNames() {
        this.missionNames.add("Alien Outpost");
    }

    public ArrayList<String> getMissionNames() {
        return missionNames;
    }

    public void setMissionNames(ArrayList<String> missionNames) {
        this.missionNames = missionNames;
    }

    public static String getGameName() {
        return "Stuck in Outer Space";
    }

    public static String getPopUpInfo() {
        return "You need to collect a minimum of 10 items, including engine";
    }

    public static String getBasementKeyMessage() {
        return "You need a basement key to get into the basement, you should look around some more.";
    }

    public static String getKeyCardMessage() {
        return "You need a key card to get into the engineroom, you should look around some more.";
    }

    public static String getHubName() {
        return "THE HUB";
    }

    public static String getStart() {
        return "START";
    }

    public static String getOk() {
        return "OK";
    }

    public static String getStartMission() {
        return "Start Mission";
    }

    public static String getMissionsMenuItem() {
        return "Missions";
    }

    public static String getInventoryMenuItem() {
        return "Inventory";
    }

    public static String getReturnOption() {
        return "Back";
    }

    public static String getExploreOption() {
        return "Let's explore";
    }

    public static String gameOverMessage() {
        return "Time is up. Game over!";
    }

    public static String winGameMessage() {
        return "You win the game!";
    }


    public static void getMainMessage() {
        System.out.println("          ___ _           _     _         ___       _             ___                  \n" +
                "         / __| |_ _  _ __| |__ (_)_ _    / _ \\ _  _| |_ ___ _ _  / __|_ __ __ _ __ ___ \n" +
                "         \\__ |  _| || / _| / / | | ' \\  | (_) | || |  _/ -_| '_| \\__ | '_ / _` / _/ -_)\n" +
                "         |___/\\__|\\_,_\\__|_\\_\\ |_|_||_|  \\___/ \\_,_|\\__\\___|_|   |___| .__\\__,_\\__\\___|\n" +
                "                                                             |_|               ");
    }

    public static void getFirstMenu() {
        System.out.println("-------------------------------------------------------------------------------------------- \n" +
                "             |     1.New Game           |--------|     2.Load Game    |\n" +
                "--------------------------------------------------------------------------------------------\n");
    }

    public void mainMenu() {
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                          |     Type Your Selection:    |               \n" +
                "-----------------------------------------------------------------------------------------\n" +
                "             |     Missions           |--------|     Inventory    |\n" +
                "             |       Help             |--------|       Quit       |\n");
    }

    public void inventoryMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("             |          Inventory:         |                ");
        System.out.println("      |     Enter item name to inspect the item    |        ");
        System.out.println("       |       These are the items you have:      |         ");
        System.out.println("------------------------------------------------------------");
    }

    public void itemFoundMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("             |      Item in this area:     |                ");
        System.out.println("------------------------------------------------------------");
    }

    public void pickItemMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("      |   Enter PICK to add the items in backpack  |        ");
        System.out.println("------------------------------------------------------------");
    }

    ;


    // TODO Henry added some functions ends here.
    public void missionsMenu() {
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                                 |     Missions:    |               \n" +
                "-----------------------------------------------------------------------------------------\n" +
                "                             |      Alien Outpost     |\n");

    }

    /*public void alienoutpostMenu() {
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                          |     What would you like to do?    |               \n" +
                "-----------------------------------------------------------------------------------------\n" +
                "             |      Enter           |--------|     Inventory    |\n" +
                "             |       Help           |--------|       Quit       |\n");

    } */

    public void activeMissionMenu() {
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                          |     Type Your Selection:    |               \n" +
                "-----------------------------------------------------------------------------------------\n" +
                "             |      Explore           |--------|     Inventory    |\n" +
                "             |       Help             |--------|       Quit       |\n");
    }


    public void moveMenu(JSONArray exits) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| EXITS:  |");
        for (Object value : exits) {
            System.out.printf("|  ");
            System.out.printf(value.toString().toUpperCase());
            System.out.printf("  |");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.printf("|  LOOK  |");
        System.out.printf("|  HELP  |");
        System.out.println("|  LEAVE |");
        System.out.println("--------------------------------------------------------------");
    }

    public void helpMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("              |          Help:         |                ");
        System.out.println("     Some useful tips about game play will go here      ");
    }

    public void helpMap(String position, JSONArray exits, JSONArray items) {
        /**
         * TODO: takes in current location, exits to current location, and items in the current location
         *
         */
        System.out.println("==============================================================");
        System.out.println("| You are Here:  " + position.toUpperCase());
        System.out.println("==============================================================");
        System.out.println("**************************************************************");
        System.out.println("==============================================================");
        System.out.printf("| KNOWN EXITS:  |");
        for (Object value : exits) {
            System.out.printf("|  ");
            System.out.printf(value.toString().toUpperCase());
            System.out.printf("  |");
        }
        System.out.println();
        System.out.println("==============================================================");
    }

}


