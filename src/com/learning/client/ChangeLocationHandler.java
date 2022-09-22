package com.learning.client;

import com.learning.view.Menu;
import com.learning.view.Story;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Objects;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.hub;
import static com.learning.client.GameManager.mission;


public class ChangeLocationHandler implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextLocationButton) {
            if (Objects.equals(nextLocationButton.getText(), "spaceship")) {
                playerPanel.remove(locLabel);
                hub.setHeroPosition(nextLocationButton.getText());
                setPlayerPanel();
                setLocLabel(hub.getHeroPosition());
                playerPanel.add(getLocLabel());
                con = window.getContentPane();
                con.add(playerPanel);
                nextLocationButton.setText("The button clicked");
            }
        }
    }
}
