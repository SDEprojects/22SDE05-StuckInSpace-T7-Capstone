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
        System.out.println("------------------------------------------------------------");
        System.out.println("             |          Inventory:         |                ");
        System.out.println("      |     Enter item name to inspect the item    |        ");
        System.out.println("       |       These are the items you have:      |         ");
        System.out.println("------------------------------------------------------------");
    }

    public void itemFoundMenu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("             |      Item in this area:     |                ");
        System.out.println("------------------------------------------------------------");
    }

    public void pickItemMenu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("      |   Enter PICK to add the items in backpack  |        ");
        System.out.println("------------------------------------------------------------");
    };

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


    public void moveMenu(JSONArray exits){
        System.out.println("--------------------------------------------------------------");
        System.out.print("| EXITS:  |");
        for (Object value: exits) {
            System.out.print("|  ");
            System.out.print(value.toString().toUpperCase());
            System.out.print("  |");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.print("|  LOOK  |");
        System.out.print("|  HELP  |");
        System.out.println("|  LEAVE |");
        System.out.println("--------------------------------------------------------------");
    }

    public void helpMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("              |          Help:         |                ");
        System.out.println("     Some useful tips about game play will go here      ");
    }

    public void helpMap(String position, JSONArray exits, JSONArray items){
        // Takes in current location, exits to current location, and items in the current location
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


