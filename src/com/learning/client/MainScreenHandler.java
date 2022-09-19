package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;

public class MainScreenHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        createHubScreen();
    }
    private void createHubScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();
        con.add(inputField);
        con.add(mainTextArea);
    }
}
