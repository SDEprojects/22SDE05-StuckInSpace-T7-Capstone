package com.learning.client;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.learning.client.GameManager.hub;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemHandlerTest {

    @Test
    void getInventoryButtonsList() {
        //HubSpot hubTest = new HubSpot();
        ArrayList<String> expectedArrayList = new ArrayList<>();
        expectedArrayList.add("boots");
        //expectedArrayList.add("TM");
        hub.initiateItemLocationList();
        ArrayList<String> actualArrayList=ItemHandler.getInventoryButtonsList("hallway");
        assertEquals(expectedArrayList, actualArrayList);


    }


    @Test
    void updateInventoryCount() {
        ArrayList<String> updateInventoryTest= hub.item.getBackpackList();
    }
}