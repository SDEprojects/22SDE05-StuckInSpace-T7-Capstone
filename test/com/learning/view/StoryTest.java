package com.learning.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

    @Test
    void gameIntroFalse() {
        String line1 = "Test purposes";
        assertNotEquals(line1, Story.gameIntro());
    }

    @Test
    void gameIntroTrue() {
        String line1 = "You are a space traveler and you have crash landed on \nan unknown planet. \n\n";
        assertEquals(line1, Story.gameIntro());
    }
}