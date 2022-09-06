package com.learning.capstone;

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
        Mission missions = new Mission();
        HubSpot hub = new HubSpot();
        Scanner scanner = new Scanner(System.in);
        String input = "welcome";
        // display Hero and some attributes
        System.out.println("Pick a Hero?");
        String hero = scanner.nextLine();
        System.out.println("Output: " + hero );
        Story.hub();

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

                // printing the main menu
                missions.getMainMenu();
                System.out.println("---------------------------------------------------------");
                System.out.println("TODO: IMPROVE INTRO");
                System.out.println("You find yourself sitting in the bay of the ship, what's the next move? ");
                String heroInput = scanner.nextLine();

                if(heroInput.equalsIgnoreCase("inventory")){
                    missions.getInventoryMenu();
                    System.out.println("Which item would you like to look at? ");
                    String itemInput = scanner.nextLine();
                    // itemDict.forEach((name) -> items.parseItemObject((JSONObject) name, item))
                } else if (heroInput.equalsIgnoreCase("missions")) {
                    missions.getMissionsMenu();
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")){
//                        Story.alienOutpost();
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
                /**
                 * Item menu - Hub.showItemMenu();
                 *       prompt user - gun
                 *       Hub.checkItem(gun); -> parseItemObject (Item.get(gun); gun.get(description));
                 * missions - Hub.showMissionsMenu();
                 * npcs - Hub.showNpcs();
                 */
            }


        }

    }

    private static void activateMission(Mission mission, HubSpot hub, String chapter){
        // getters for items, locations, people save them to local variables.

        Scanner scanner = new Scanner(System.in);
        String heroInput = "null";
        Story.alienOutpost();
        
        while(!heroInput.equalsIgnoreCase("quit")){
            System.out.println("SHOW THE MISSION MENU ---[MOVE     INVENTORY       HELP        QUIT_MISSION]---");
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
            System.out.println("Your position: " + hub.getHeroPosition());
            System.out.println("Where would you like to move to? ");
            System.out.println("---[EXIT     EXIT1      EXIT2      LOOK[PHRASE]    LEAVE]---");
            heroInput = scanner.nextLine();
            if (heroInput.equalsIgnoreCase("look")){
                System.out.println("Your hero takes the time to investigate his surroundings.");
                // call to check and see if there are items in this section of our locations.
                // if there is an item, give it to the player and add it to their inventory.
            } else if (!heroInput.equalsIgnoreCase("leave")) {
                if(mission.isExitAvailable(hub.getHeroPosition(), heroInput)){
                    hub.setHeroPosition(heroInput);
                }
            }
        }while(!heroInput.equalsIgnoreCase("leave"));
    }

}
