package com.learning.client;

import com.learning.controller.HubSpot;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameGui.inventoryButtonsPanel;
import static com.learning.client.GameManager.hub;
import static org.junit.jupiter.api.Assertions.*;

class ChangeLocationHandlerTest {

    HubSpot testHub = new HubSpot();

    @Test
    void updateAvailableItemsInformation() {
        ArrayList<Object> expected = new ArrayList<>();
        expected.add("knife");
        expected.add("TM");
        //setInventoryButtonsPanel();
        ArrayList<String> actual = new ArrayList<>();
        testHub.setHeroPosition("hangar");
        actual = ExploreMissionScreenHandler.getArrayInventoryItemsButtons(testHub.getHeroPosition());
        assertEquals(expected, actual);
    }
}