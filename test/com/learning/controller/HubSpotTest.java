package com.learning.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HubSpotTest {
    HubSpot hubTest = new HubSpot();
    @Test
    void addItemToInventory() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("item");
        ArrayList<String> actual;
        actual = hubTest.addItemToInventory("item");
        assertEquals(expected, actual);
    }
}