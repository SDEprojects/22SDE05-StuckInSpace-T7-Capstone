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
}