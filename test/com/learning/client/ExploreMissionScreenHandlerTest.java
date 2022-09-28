package com.learning.client;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.learning.client.GameManager.hub;
import static org.junit.jupiter.api.Assertions.*;

class ExploreMissionScreenHandlerTest {
    public static ArrayList<String> inventoryTest = hub.item.getBackpackList();
    @Test
    void checkItemCondition() {
        inventoryTest.add("TM");
        assertEquals(inventoryTest.contains("TM"), ExploreMissionScreenHandler.checkItemCondition("TM"));
    }
}