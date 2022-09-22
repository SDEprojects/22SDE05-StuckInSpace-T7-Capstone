package com.learning.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.bootsButton;

public class ItemHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bootsButton) {
            bootsButton.setVisible(false);
        }
    }
}
