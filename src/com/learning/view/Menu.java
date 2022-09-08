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

    public void mainMenu() {
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                          |     Type Your Selection:    |               \n" +
                "-----------------------------------------------------------------------------------------\n" +
                "             |     Missions           |--------|     Inventory    |\n" +
                "             |       Help             |--------|       Quit       |\n");
    }

    public void inventoryMenu() {
        //TODO is there a way for this to call JSON object for inventory items? look at moveMenu
        System.out.println("----------------------------------------------------------------------------------------- \n" +
                "                            |     Inventory:    |               \n" +
                        "-----------------------------------------------------------------------------------------\n" +
                        "                     |     display inventory here     |\n");
    }

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
                        "             |     Missions           |--------|     Inventory    |\n" +
                        "             |       Help             |--------|       Quit       |\n");
    }


    public void moveMenu(JSONArray exits){
        System.out.println("--------------------------------------------------------------");
        for (Object value: exits) {
            System.out.printf("|  ");
            System.out.printf(value.toString().toUpperCase());
            System.out.printf("  |");
        }
        System.out.printf("|  LOOK  |");
        System.out.println("|  HELP");
        System.out.println("--------------------------------------------------------------");
    }

    public void helpMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("              |          Help:         |                ");
        System.out.println("     Some useful tips about game play will go here      ");
    }

    public void helpMap(String position, JSONArray exits, JSONArray items){
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
        for (Object value: exits) {
            System.out.printf("|  ");
            System.out.printf(value.toString().toUpperCase());
            System.out.printf("  |");
        }
        System.out.println();
        System.out.println("==============================================================");
    }

}


