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
}