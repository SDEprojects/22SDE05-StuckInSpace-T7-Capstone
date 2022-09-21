package com.learning.client;

import com.learning.view.Menu;
import com.learning.view.Story;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameGui.mainTextPanel;

public class MissionScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createMissionScreen();
    }

    private void createMissionScreen() {
        CurrentMissionScreenHandler currentMissionScreenHandler = new CurrentMissionScreenHandler();
        titlePanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        setMainTextPanel(setMainTextArea(Story.getMission1Name()));
        setStartButtonPanel(setStartButton(Menu.getStartMission()));
        //setReturnPanel(setReturnButton(Menu.getReturnOption()));
        startButton.addActionListener(currentMissionScreenHandler);

        con = window.getContentPane();
        con.add(missionTitlePanel);
        con.add(mainTextPanel);
        con.add(returnPanel);
        con.add(startButtonPanel);
    }
}
