package com.learning.capstone;

public class Story {
    private String currentChapter;
    private String heroName;

    public static void gameIntro(){
        System.out.println("something");
        System.out.println("something");
    }

    public static void hub(){
        System.out.println("Crash landed on an unknown planet. We find our hero in the crash site checking repairs. ");
    }

    public static void alienOutpost(){
        System.out.println("You find yourself in a strange field. everything has been cleared out and all that stands before you is an unknown tower");
    }


    public static void exploreOutpost(){
        System.out.println("You have decided to move and explore the surrounding area.");
        System.out.println("You can LOOK around or move to an EXIT location.");
    }
}
