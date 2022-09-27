package com.learning.client;

import com.learning.view.Menu;

import static com.learning.client.GameGui.con2;
import static com.learning.client.GameScreenHandler.gameGui;

public class PopUpScreenHandler {
   // static GameGui gameGui = new GameGui();
    public static void getPopUpScreen() {
        gameGui.setPopUpWindow();
        gameGui.setCon2();
        gameGui.setPopUpPanel(GameGui.setPopUpLabel(Menu.getPopUpInfo()));
        //gameGui.setTitlePanel(GameGui.setTitleLabel(Menu.getGameName()));
        con2.add(gameGui.getPopUpPanel());
        //con.add(gameGui.getTitlePanel());
        GameGui.setPopUpButtonPanel(GameGui.setPopUpButton(Menu.getOk()));
        //GameGui.setStartButtonPanel(GameGui.setStartButton(Menu.getStart()));
        con2.add(gameGui.getPopUpButtonPanel());
        //con.add(gameGui.getStartButtonPanel());
        //GameManager.hub.initiateInventory();
    }

}