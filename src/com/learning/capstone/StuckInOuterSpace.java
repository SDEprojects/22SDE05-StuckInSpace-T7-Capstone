package com.learning.capstone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class StuckInOuterSpace {

    public static void main(String[] args) throws IOException {
        /**
         * Introduction to the game
         * TODO:
         * 1. game story intro printed out on terminal, story.gameIntro()
         * 2. PROMPT USER to put the hero name the would like to use
         * 3. set character attributes (currentChapter, currentItems, currentPosition, etc.)
         * 4. create Hub object and instantiate its values. HubSpot hub = new Hubspot()
        * */
        Location locations = new Location();
        Scanner scanner = new Scanner(System.in);
        String input = "welcome";
        // display Hero and some attributes
        System.out.println("Pick a Hero? ");
        String hero = scanner.nextLine();
        System.out.println("Output: " + hero );
        HubSpot hub = new HubSpot();
        Story.chapterOne();

        //================================== STARTING THE GAME ===========================================//
        while(!input.equals("quit")){

            //=============================== ENTERING THE HUB ===========================================//
            while(!input.equals("quit")){
                /**
                 * TODO:
                 * 1. check if currentChapter is equal to chapter 1
                 *     1a. create Mission Object and instantiate its values
                 *     1b. Welcome user to the Hub (crash landing site?) explain
                 *          their surroundings, near by npc's, and to check for new missions.
                 *     1c. Hub.showAllMenus()
                 *         1d. PROMPT USER
                 */
                System.out.println("THIS IS WHERE WE PRINT THE MENU");
                System.out.println("---------------------------------------------------------");
                System.out.println("You find yourself sitting in the bay of the ship, what's the next move? ");
                String heroInput = scanner.nextLine();

                if(heroInput.equals("items")){
                    System.out.println("THIS IS WHERE WE PRINT OUT THE LIST OF ITEMS ON THE HERO");
                    System.out.println("Which item would you like to look at? ");
                    String itemInput = scanner.nextLine();
                    // itemDict.forEach((name) -> items.parseItemObject((JSONObject) name, item))
                } else if (heroInput.equals("missions")) {
                    System.out.println("THIS IS WHERE WE PRINT OUT THE LIST OF AVAILABLE MISSIONS");
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if(missionInput.equals("alien outpost")){
                        Story.alienOutpost();
                        StuckInOuterSpace.activateMission(locations,"chapter 1");
                    } else {
                        break;
                    }
                } else if (heroInput.equals("quit")) {

                }
                /**
                 * Item menu - Hub.showItemMenu();
                 *       prompt user - gun
                 *       Hub.checkItem(gun); -> parseItemObject (Item.get(gun); gun.get(description));
                 * missions - Hub.showMissionsMenu();
                 * npcs - Hub.showNpcs();
                 */
                input = "quit";
            }


        }

    }

    private static void activateMission(Location mission, String chapter){
        // getters for items, locations, people save them to local variables.
        mission.getLocDict().forEach((loc) -> mission.parseLocationObject((JSONObject) loc, chapter, "start_position"));
        Scanner scanner = new Scanner(System.in);
        String itemInput = "nothing";
        System.out.println("SHOW THE MISSION MENU ---[MOVE     INVENTORY       SEARCH]---");
        Story.alienOutpost();
        while(true){
            System.out.println("What would you like to do? ");
            itemInput = scanner.nextLine();
            System.out.println(itemInput);
            if(itemInput.equals("move")){
                System.out.println("Your Current Location (currentLocation)");
                System.out.println("Where would you like to move to? ");
                System.out.println("---[EXIT     EXIT1       EXIT2      LEAVE]---");
                itemInput = scanner.nextLine();
            }
            break;
        }
        System.out.println("Something said");
    }

}
