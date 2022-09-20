package com.learning.client;

import com.learning.view.Menu;

import static com.learning.client.GameGui.con;

public class GameScreenHandler {
    static GameGui gameGui = new GameGui();
    public static void getMainScreen() {
        gameGui.setWindow();
        gameGui.setCon();
        gameGui.setTitlePanel(gameGui.setTitleLabel(Menu.getGameName()));
        con.add(gameGui.getTitlePanel());
        gameGui.setStartButtonPanel(gameGui.setStartButton(Menu.getStart()));
        con.add(gameGui.getStartButtonPanel());
    }

}
