package com.learning.client;

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
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();
        con.add(missionTitlePanel);
        setMainTextPanel(setMainTextArea(Story.getMission1Name()));
        mainTextArea.append(Story.alienOutpost());
        con.add(mainTextPanel);
        con.add(returnPanel);
    }
}
