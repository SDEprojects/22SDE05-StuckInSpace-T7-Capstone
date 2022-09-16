package com.learning.client;

import com.learning.view.Menu;

import java.io.IOException;

public class GameClient {

    public static void main(String[] args) throws IOException {
        Menu.getMainMessage();
        Menu.getFirstMenu();
        GameManager.runGame();
    }
}

