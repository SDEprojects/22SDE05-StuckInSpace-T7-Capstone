package com.learning.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HubSpotTest {
    @Test
    void addItemToInventory() {
        HubSpot hubTest = new HubSpot();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("item");
        ArrayList<String> actual;
        actual = hubTest.addItemToInventory("item");
        assertEquals(expected, actual);
    }

    @Test
    void addItemToInventory2() {
        HubSpot hubTest = new HubSpot();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("item");
        ArrayList<String> actual;
        actual = hubTest.addItemToInventory("item2");
        assertNotEquals(expected, actual);
    }

    @Test
    void godMode() {
        HubSpot hubTest = new HubSpot();
        ArrayList<String>expectedArrayList = new ArrayList<>();
        ArrayList<String>actualArrayList = hubTest.godMode();
        expectedArrayList.add("fuel");
        expectedArrayList.add("engine");
        expectedArrayList.add("bio_suit");
        expectedArrayList.add("TM");
        expectedArrayList.add("keycard");
        expectedArrayList.add("basement_key");
        expectedArrayList.add("toolkit");
        expectedArrayList.add("GPS");
        expectedArrayList.add("knife");
        expectedArrayList.add("rifle");
        expectedArrayList.add("pistol");
        expectedArrayList.add("laser_gun");
        expectedArrayList.add("IMTV");
        expectedArrayList.add("ACH");
        expectedArrayList.add("gloves");
        expectedArrayList.add("boots");
        expectedArrayList.add("Compass");
        expectedArrayList.add("TBD");

        assertEquals(expectedArrayList.contains("fuel"),actualArrayList.contains("fuel"));
       // assertEquals(expectedArrayList.stream().sorted().toString(),actualArrayList.stream().sorted().toString());
        //assertEquals(expectedArrayList.size(),actualArrayList.size());
    }
    @Test
    void godMode2(){
        HubSpot hubTest = new HubSpot();
        ArrayList<String>expectedArrayList = new ArrayList<>();
        ArrayList<String>actualArrayList = hubTest.godMode();
        expectedArrayList.add("fuel");
        expectedArrayList.add("engine");
        expectedArrayList.add("bio_suit");
        expectedArrayList.add("TM");
        expectedArrayList.add("keycard");
        expectedArrayList.add("basement_key");
        expectedArrayList.add("toolkit");
        expectedArrayList.add("GPS");
        expectedArrayList.add("knife");
        expectedArrayList.add("rifle");
        expectedArrayList.add("pistol");
        expectedArrayList.add("laser_gun");
        expectedArrayList.add("IMTV");
        expectedArrayList.add("ACH");
        expectedArrayList.add("gloves");
        expectedArrayList.add("boots");
        expectedArrayList.add("Compass");
        expectedArrayList.add("TBD");

        assertEquals(expectedArrayList.size(),actualArrayList.size());

    }
}