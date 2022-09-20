package com.learning.client;

import com.learning.view.Menu;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameClient {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Menu.getMainMessage();
        Menu.getFirstMenu();
        GameManager.runGame();
    }
}

