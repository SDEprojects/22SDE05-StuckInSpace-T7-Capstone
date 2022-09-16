package com.learning.client;

import javax.swing.*;
import java.awt.*;

public class GameGui {
    private final Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    private final Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private final Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    private final Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);

    JFrame window;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel;
    JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems;

    JButton startButton, choice1, choice2, choice3, choice4, audioButton;
    JTextArea mainTextArea;

    public GameGui() {
        window = new JFrame();
        mainTextPanel = new JPanel();
        mainTextArea = new JTextArea();
        con = new Container();
        titlePanel = new JPanel();
        startButtonPanel = new JPanel();
        choiceButtonPanel = new JPanel();
        playerPanel = new JPanel();
        audioButtonPanel = new JPanel();
        titleLabel = new JLabel();
        hpLabel = new JLabel();
        hpLabelNum = new JLabel();
        locLabel = new JLabel();
        locLabelCurrent = new JLabel();
        invLabel = new JLabel();
        invLabelItems = new JLabel();
        startButton = new JButton();
        choice1 = new JButton();
        choice2 = new JButton();
        choice3 = new JButton();
        choice4 = new JButton();
        audioButton = new JButton();
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow() {
        window.setPreferredSize(new Dimension(1280,719));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new JLabel(new ImageIcon("resources/StuckInSpace.jpg")));
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        //window.add(con);
        window.add(mainTextArea);
        window.pack();
    }

    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    public void setTextPanel() {
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setOpaque(false);
        mainTextPanel.add(mainTextArea);
    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public void setMainTextArea(String text) {
        mainTextArea.append(text);
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setLineWrap(true);
    }

    public void setCon() {
        con.add(mainTextPanel);
    }
}
