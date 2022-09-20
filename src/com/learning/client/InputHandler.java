package com.learning.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.learning.client.GameGui.*;
import static com.learning.client.GameManager.runGame;

public class InputHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        getInput(inputField);
        printText(GameManager.text);
    }

    public static String getInput(JTextField input) {
        return input.getText();
    }
    public void printText(String text) {
        mainTextArea.append(text);
    }

    public static void reset(JTextField input) {
        input.setText("");
    }
}
