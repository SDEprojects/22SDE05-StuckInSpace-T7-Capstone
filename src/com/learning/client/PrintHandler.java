package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.runGame;

public class PrintHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        printText();
    }

    public void printText() {
        mainTextArea.append(GameManager.text);
    }
}