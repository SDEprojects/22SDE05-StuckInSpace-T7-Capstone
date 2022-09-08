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
        System.out.println("              |   Stuck in Outer Space   |                 ");
        System.out.println("              |     Make a Selection:    |                 ");
        System.out.println("------------------------------------------------------------");
        System.out.println("|     1. Inventory          |--------|     2. Missions     |");
        System.out.println("|     3. Help               |--------|     4. Quit         |");
    }

    public void inventoryMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("             |          Inventory:         |                ");
    }

    public void missionsMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("              |          Missions:         |                ");
        System.out.println("------------------------------------------------------------");
        System.out.println("             |         1.Alien Outpost      |                ");

    }

    public void activeMissionMenu() {
        System.out.println("              |   Stuck in Outer Space   |                 ");
        System.out.println("              |     Make a Selection:    |                 ");
        System.out.println("------------------------------------------------------------");
        System.out.println("|     1. Move               |--------|     2. Inventory     |");
        System.out.println("|     3. Help               |--------|     4. Quit         |");
    }


    public void moveMenu(JSONArray exits){
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| EXITS:  |");
        for (Object value: exits) {
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


