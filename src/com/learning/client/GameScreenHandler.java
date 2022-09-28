package com.learning.client;

import com.learning.view.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.con;

public class GameScreenHandler implements ActionListener {
    static GameGui gameGui = new GameGui();
    public static void getMainScreen() {
        GameGui.setWindow();
        //GameGui.playMusic(0);
        gameGui.setCon();
        GameGui.setTitlePanel(GameGui.setTitleLabel(Menu.getGameName()));
        con.add(GameGui.getTitlePanel());
        GameGui.setStartButtonPanel(GameGui.setStartButton(Menu.getStart()));
        con.add(gameGui.getStartButtonPanel());
        GameManager.hub.initiateInventory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getMainScreen();
    }
}
