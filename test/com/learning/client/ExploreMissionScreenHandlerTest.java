package com.learning.client;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.learning.client.GameManager.hub;
import static org.junit.jupiter.api.Assertions.*;

class ExploreMissionScreenHandlerTest {
    @Test
    void checkItemCondition() {
        ArrayList<String> inventoryTest = hub.item.getBackpackList();
        inventoryTest.add("TM");
        assertEquals(inventoryTest.contains("TM"), ExploreMissionScreenHandler.checkItemCondition("TM"));
    }

    @Test
    void checkItemCondition2() {
        ArrayList<String> inventoryTest = hub.item.getBackpackList();
        inventoryTest.add("TM");
        assertNotEquals(inventoryTest.contains("TM"), ExploreMissionScreenHandler.checkItemCondition("tm"));
    }
}