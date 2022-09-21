package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
import com.learning.view.Menu;
import com.learning.view.Story;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.learning.client.GameGui.*;
import static com.learning.client.MissionManager.activateMission;
import static com.learning.controller.HubSpot.checkInventoryInputType;

public class GameManager {

    static HubSpot hub = new HubSpot();
    public static void runGame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        GameScreenHandler.getMainScreen();

        HubScreenHandler hubScreenHandler = new HubScreenHandler();
        startButton.addActionListener(hubScreenHandler);


        //================================== LOADING THE GAME/NEW GAME ===========================================//
        Scanner scanner = new Scanner(System.in);
        String gameInput = scanner.nextLine();
        Mission missions = new Mission();

        scanner = new Scanner(System.in);
        String input = "not-exit";
        File file = new File("resources/DivKid.wav");
        while (true) {
            if (gameInput.equalsIgnoreCase("1") || gameInput.equalsIgnoreCase("new game")) {
                //Start the game
                //hub.startMusic(file);
               // hub.manageMusic(file, "start music");
                System.out.println("Name your hero: ");
                String name = scanner.nextLine();
                hub.setPlayerName(name);
                hub.showPlayerProfile();
                hub.initiateInventory(); // To add the items the Hero came with to the backpack.
                hub.initiateItemLocationList();// Initiate the item list based on location.
                Story.gameIntro();
                System.out.println("Type next to continue");

                //hub.stopMusic(file);
                String next = scanner.nextLine();
                break;
            } else if (gameInput.equalsIgnoreCase("2") || gameInput.equalsIgnoreCase("load game")) {
                hub.loadSavedGame(hub.getSavegame().getSavePlayerName(), hub.getSavegame().getSavePlayerInventory());
                hub.initiateItemLocationList();
                System.out.println("Welcome back to the game " + hub.getPlayerName());
                hub.showPlayerProfile();
                break;
            } else {
                System.out.println("Please put a valid option for your game settings.");
                Menu.getFirstMenu();
                gameInput = scanner.nextLine();
            }
        }
        //================================== STARTING THE GAME ===========================================//
        while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {

            //=============================== ENTERING THE HUB ===========================================//
            while (!(input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("4"))) {
                Story.hub();
                // printing the main menu
                missions.getMainMenu();
                System.out.println("What would you like to do next? ");
                String heroInput = scanner.nextLine();

                //============================ ACTIONS ITEMS FROM MENU ===================================//
                //------------------------ inventory, missions, help, quit ------------------------------
                if (heroInput.equalsIgnoreCase("inventory") || heroInput.equalsIgnoreCase("1")) {
                    //hub.manageMusic(file, "stop music");
                    missions.getInventoryMenu();
                    hub.showInventory();

                    System.out.println("Which item would you like to look at? Please enter the number.");

                    while (true) {
                        String itemInput = scanner.nextLine();
                        if (checkInventoryInputType(itemInput)) {
                            if (Integer.parseInt(itemInput) > hub.getPlayerItems().size() || Integer.parseInt(itemInput) < 1) {
                                System.out.println("Number you entered is not valid, please enter number that is corresponding to items being displayed. ");
                            } else {
                                hub.showItemCard(itemInput);
                                break;
                            }
                        } else {
                            System.out.println("Please enter valid number only");
                        }
                    }
                } else if (heroInput.equalsIgnoreCase("missions") || heroInput.equalsIgnoreCase("2")) {
                    missions.getMissionsMenu();
                    System.out.println("Which mission would you like to try? ");
                    String missionInput = scanner.nextLine();
                    if ((missionInput.equalsIgnoreCase("alien outpost")) || missionInput.equalsIgnoreCase("1")) {
                        missions.buildLocationMap("mission_01");
                        activateMission(missions, hub);
                    }
                }else if (heroInput.equalsIgnoreCase("stop music")){
                    hub.stopMusic(file);
                }else if (heroInput.equalsIgnoreCase("help") || heroInput.equalsIgnoreCase("3")) {
                    missions.getHelpMenu();
                } else if (heroInput.equalsIgnoreCase("quit") || heroInput.equalsIgnoreCase("4")) {
                    input = heroInput;
                    hub.autoSaveGame();
                    // save the game before closing out.
                    // hub.autoSaveGame();
                }
            }
        }
    }

}
