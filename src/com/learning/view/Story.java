package com.learning.view;

public class Story {
    private String currentChapter;
    private String heroName;

    public static String gameIntro() {
        String line1 = "You are a space traveler and you have crash landed on \nan unknown planet. \n\n";
        //String line2 = "-----------------------------------------------------------------------------------------\n";
        //String line3 = "     ||||        Read and use the menu to navigate through the game        ||||    \n";
        //String line4 = "----------------------------------------------------------------------------------------- \n";

        return line1;
    }

    public static void hub() {
        System.out.println("\n" +
                "                       ▀█▀ █░█ █▀▀   █░█ █░█ █▄▄\n" +
                "                       ░█░ █▀█ ██▄   █▀█ █▄█ █▄█ \n");
        System.out.println("      You are at the hub. Here you may choose the mission you'd like to play, \n" +
                "                  check your inventory, get help, or exit the game. ");
    }

    public static String getMission1Name() {
        return "Alien Outpost";
    }

    public static String alienOutpost() {
        //System.out.println("\n" +
         //       "        ▄▀█ █░░ █ █▀▀ █▄░█   █▀█ █░█ ▀█▀ █▀█ █▀█ █▀ ▀█▀\n" +
         //       "        █▀█ █▄▄ █ ██▄ █░▀█   █▄█ █▄█ ░█░ █▀▀ █▄█ ▄█ ░█░\n");
        return "You find yourself in a strange field. \n\nEverything has been cleared out and all that \nstands before you is an unknown tower. \n\nCollect minimum 10 items including engine and return \nto the spaceship before time is up.";
    }


    public static void exploreOutpost() {
        System.out.println("You have decided to move and explore the surrounding area.");
        System.out.println("You can LOOK around or move to an EXIT location.");
    }
}
