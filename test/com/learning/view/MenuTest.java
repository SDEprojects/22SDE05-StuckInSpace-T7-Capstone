package com.learning.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getGameName() {
        String expectedName = "Stuck in Outer Space";
        String actualName = Menu.getGameName();
        assertEquals(expectedName, actualName);
    }

    @Test
    void getGameName2() {
        String expectedName = "Stuck in Outer Space2";
        String actualName = Menu.getGameName();
        assertNotEquals(expectedName, actualName);
    }
}