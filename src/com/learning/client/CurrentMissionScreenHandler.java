package com.learning.client;

import com.learning.view.Menu;
import com.learning.view.Story;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;

public class CurrentMissionScreenHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        activateMission();
    }

    private void activateMission() {
        MissionScreenHandler missionScreenHandler = new MissionScreenHandler();
        ExploreMissionScreenHandler exploreMissionScreenHandler = new ExploreMissionScreenHandler();

        titlePanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("alien base.png"))));

        setMissionTitlePanel(setMissionTitleLabel(Story.getMission1Name()));
        setMainTextPanel(setMainTextArea(Story.alienOutpost()));
        setStartButtonPanel(setStartButton(Menu.getExploreOption()));
        setReturnPanel(setReturnButton(Menu.getReturnOption()));

        startButton.addActionListener(exploreMissionScreenHandler);

        con = window.getContentPane();
        con.add(missionTitlePanel);
        con.add(mainTextPanel);
        con.add(startButtonPanel);
        returnButton.addActionListener(missionScreenHandler);
        con.add(returnPanel);
    }
}
