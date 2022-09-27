package com.learning.client;

import com.learning.controller.Mission;
import com.learning.view.Menu;

import java.util.Timer;

import static com.learning.client.GameGui.con;

public class GameScreenHandler {
    static GameGui gameGui = new GameGui();
    public static void getMainScreen() {
        gameGui.setWindow();
        gameGui.setCon();
        gameGui.setTitlePanel(GameGui.setTitleLabel(Menu.getGameName()));
        con.add(gameGui.getTitlePanel());
        GameGui.setStartButtonPanel(GameGui.setStartButton(Menu.getStart()));
        con.add(gameGui.getStartButtonPanel());
        GameManager.hub.initiateInventory();
    }
}
