package com.learning.client;

import com.learning.view.Menu;
import com.learning.view.Story;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;

public class HubScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createHubScreen();
    }
    private void createHubScreen() {
        HubScreenHandler hubScreenHandler = new HubScreenHandler();
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("The Hub Image.jpg"))));
        setHubTitlePanel(setTitleLabel(Menu.getHubName()));
        setMainTextPanel(setMainTextArea(Story.gameIntro()));
        setChoiceButtonPanel(setMissionButton(Menu.getMissionsMenuItem()), setInventoryButton(Menu.getInventoryMenuItem()));

        MissionScreenHandler missionScreenHandler = new MissionScreenHandler();
        missionButton.addActionListener(missionScreenHandler);
        setMissionTitlePanel(setMissionTitleLabel(Menu.getMissionsMenuItem()));
        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(hubScreenHandler);

        InventoryScreenHandler inventoryScreenHandler = new InventoryScreenHandler();
        inventoryButton.addActionListener(inventoryScreenHandler);
        setInventoryTitlePanel(setInventoryTitleLabel(Menu.getInventoryMenuItem()));
        setReturnPanel(setReturnButton(Menu.getReturnOption()));
        returnButton.addActionListener(hubScreenHandler);

        con = window.getContentPane();
        con.add(hubTitlePanel);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }
}
