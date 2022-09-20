package com.learning.view;

public class Story {
    private String currentChapter;
    private String heroName;

    public static String gameIntro() {
        String line1 = " You are a space traveler and you have crash landed on an unknown planet.\n In order to leave" +
                " and continue on your journey, you need to collect fuel and engine \n" +
                " to repair your craft.";
        String line2 = "-----------------------------------------------------------------------------------------\n";
        String line3 = "     ||||        Read and use the menu to navigate through the game        ||||    \n";
        String line4 = "----------------------------------------------------------------------------------------- \n";

        return line1 + line2 + line3 + line4;
    }

    public static void hub() {
        System.out.println("\n" +
                "                       ▀█▀ █░█ █▀▀   █░█ █░█ █▄▄\n" +
                "                       ░█░ █▀█ ██▄   █▀█ █▄█ █▄█ \n");
        System.out.println("      You are at the hub. Here you may choose the mission you'd like to play, \n" +
                "                  check your inventory, get help, or exit the game. ");
    }

    public static void alienOutpost() {
        System.out.println("\n" +
                "        ▄▀█ █░░ █ █▀▀ █▄░█   █▀█ █░█ ▀█▀ █▀█ █▀█ █▀ ▀█▀\n" +
                "        █▀█ █▄▄ █ ██▄ █░▀█   █▄█ █▄█ ░█░ █▀▀ █▄█ ▄█ ░█░\n");
        System.out.println("You find yourself in a strange field. everything has been cleared out and all that \n " +
                "stands before you is an unknown tower");
    }


    public static void exploreOutpost() {
        System.out.println("You have decided to move and explore the surrounding area.");
        System.out.println("You can LOOK around or move to an EXIT location.");
    }
}
