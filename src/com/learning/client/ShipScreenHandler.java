package com.learning.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;

public class ShipScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        enterShip();
    }

    private void enterShip() {
        ShipScreenHandler shipScreenHandler = new ShipScreenHandler();
        ExploreMissionScreenHandler exploreMissionScreenHandler = new ExploreMissionScreenHandler();

        con = window.getContentPane();
        con.add(missionTitlePanel);
        con.add(mainTextPanel);
        con.add(startButtonPanel);
        con.add(returnPanel);

    }
}