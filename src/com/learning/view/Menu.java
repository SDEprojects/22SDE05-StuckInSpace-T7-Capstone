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
        System.out.println("                                                            ");
        System.out.println("                 |     Make a Selection:    |               ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|     Inventory          |--------|     Missions     |");
        System.out.println("|       Help             |--------|       Quit       |");
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

    public void helpMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("              |          Help:         |                ");
        System.out.println("     Some useful tips about game play will go here      ");
    }

    public void activeMissionMenu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("                  |     Missions:    |                  ");
        System.out.println("--------------------------------------------------------");
        System.out.println("|     1. Move          |--------|     2. Inventory     |");
        System.out.println("|     3. Help          |--------|     4. Quit          |");
    }


    public void moveMenu(JSONArray exits){
        System.out.println("--------------------------------------------------------------");
        for (Object value: exits) {
            System.out.printf("|  ");
            System.out.printf(value.toString().toUpperCase());
            System.out.printf("  |");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }

}


