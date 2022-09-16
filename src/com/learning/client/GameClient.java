package com.learning.client;

import com.learning.controller.HubSpot;
import com.learning.controller.Mission;
import com.learning.view.Menu;
import com.learning.view.Story;

import java.io.IOException;
import java.util.Scanner;

import static com.learning.controller.HubSpot.checkInventoryInputType;

public class GameClient {

    public static void main(String[] args) throws IOException {
        GameGui game = new GameGui();
        game.setWindow();

        game.setMainTextArea("STUCK IN OUTER SPACE");
        Menu.getMainMessage();
        Menu.getFirstMenu();
        GameManager.runGame();
    }
}

