package com.learning.client;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameGui.inventoryButtonsPanel;
import static com.learning.client.GameManager.hub;
import static org.junit.jupiter.api.Assertions.*;

class ChangeLocationHandlerTest {

    @Test
    void updateAvailableItemsInformation() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        Container container;
        hub.setHeroPosition("hangar");
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("knife");
        arrayList.add("TM");
        //hub.setHeroPosition(button.getText());
        ExploreMissionScreenHandler.getInventoryItemsButtons(hub.getHeroPosition());
        container = jFrame.getContentPane();
        container.add(jPanel);
    }
}