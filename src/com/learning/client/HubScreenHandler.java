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
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();
        con.add(hubTitlePanel);
        con.add(mainTextPanel);
        con.add(choiceButtonPanel);
    }
}
