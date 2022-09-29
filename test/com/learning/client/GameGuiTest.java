package com.learning.client;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GameGuiTest {

    @Test
    void setGpsButton() {
        Object expectedGpsIcon = Objects.requireNonNull(GameGui.class.getClassLoader().getResource("map.png"));
        Object actualGpsIcon = Objects.requireNonNull(GameGui.class.getClassLoader().getResource("rifle.png"));
        assertNotEquals(expectedGpsIcon, actualGpsIcon);
    }

    @Test
    void setGpsButton2() {
        Object expectedGpsIcon = Objects.requireNonNull(GameGui.class.getClassLoader().getResource("map.png"));
        Object actualGpsIcon = Objects.requireNonNull(GameGui.class.getClassLoader().getResource("map.png"));
        assertEquals(expectedGpsIcon, actualGpsIcon);
    }
}