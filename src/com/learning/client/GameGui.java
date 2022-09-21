package com.learning.client;

import javax.swing.*;
import java.awt.*;

public class GameGui {
    public static final Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    public static final Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public static final Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    public static final Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);

    static JFrame window;
    static Container con;
    static JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel, hubTitlePanel, inventoryTitlePanel, missionTitlePanel, returnPanel;
    static JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems, hubTitleLabel, inventoryTitleLabel, missionTitleLabel;
    static JButton startButton, missionButton, inventoryButton, returnButton;
    static JTextArea mainTextArea;
    static JMenuBar menuBar;
    static JMenu menu;
    static JMenuItem menuItem;
    static JTextField inputField;


    public GameGui() {
        window = new JFrame();
        mainTextPanel = new JPanel();
        mainTextArea = new JTextArea();
        con = new Container();
        titlePanel = new JPanel();
        startButtonPanel = new JPanel();
        titleLabel = new JLabel();
        startButton = new JButton();
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow() {
        window.setPreferredSize(new Dimension(1280, 719));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new JLabel(new ImageIcon("resources/StuckInSpace.jpg")));
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.pack();
    }

    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    public static void setMainTextPanel(JTextArea textArea) {
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(350, 300, 600, 250);
        mainTextPanel.setOpaque(false);
        mainTextPanel.add(textArea);
    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public static JTextArea setMainTextArea(String text) {
        mainTextArea = new JTextArea();
        mainTextArea.append(text);
        mainTextArea.setBounds(300, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        return mainTextArea;
    }

    public JPanel getInventoryTitlePanel() {
        return inventoryTitlePanel;
    }

    public static void setInventoryTitlePanel(JLabel label) {
        inventoryTitlePanel = new JPanel();
        inventoryTitlePanel.setBounds(500, 70, 300, 100);
        inventoryTitlePanel.setOpaque(false);
        inventoryTitlePanel.add(label);
    }

    public JLabel getInventoryTitleLabel() {
        return inventoryTitleLabel;
    }

    public static JLabel setInventoryTitleLabel(String text) {
        inventoryTitleLabel = new JLabel(text);
        inventoryTitleLabel.setForeground(Color.white);
        inventoryTitleLabel.setFont(titleFont);
        return inventoryTitleLabel;
    }

    public static JPanel getMissionTitlePanel() {
        return missionTitlePanel;
    }

    public static void setMissionTitlePanel(JLabel label) {
        missionTitlePanel = new JPanel();
        missionTitlePanel.setBounds(340, 40, 600, 100);
        missionTitlePanel.setOpaque(false);
        missionTitlePanel.add(label);
    }

    public static JLabel getMissionTitleLabel() {
        return missionTitleLabel;
    }

    public static JLabel setMissionTitleLabel(String text) {
        missionTitleLabel = new JLabel(text);
        missionTitleLabel.setForeground(Color.white);
        missionTitleLabel.setFont(titleFont);
        return missionTitleLabel;
    }

    public Container getCon() {
        return con;
    }

    public void setCon() {
        con = new Container();
        con.add(mainTextArea);
        con = window.getContentPane();
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JLabel titleLabel) {
        titlePanel = new JPanel();
        titlePanel.setBounds(340, 40, 600, 100);
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
    }

    public JPanel getStartButtonPanel() {
        return startButtonPanel;
    }

    public static void setStartButtonPanel(JButton startButton) {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(565, 570, 200, 50);
        startButtonPanel.setBorder(null);
        startButtonPanel.setOpaque(false);
        startButtonPanel.add(startButton);
    }

    public static JPanel getChoiceButtonPanel() {
        return choiceButtonPanel;
    }

    public static void setChoiceButtonPanel(JButton button1, JButton button2) {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 525, 300, 120);
        choiceButtonPanel.setOpaque(false);
        choiceButtonPanel.setLayout(new GridLayout(2, 1));
        choiceButtonPanel.add(button1);
        choiceButtonPanel.add(button2);
    }

    public static JButton getMissionButton() {
        return missionButton;
    }

    public static JButton setMissionButton(String text) {
        missionButton = new JButton(text);
        missionButton.setBackground(Color.black);
        missionButton.setForeground(Color.white);
        missionButton.setFont(normalFont);
        return missionButton;
    }

    public static JButton getInventoryButton() {
        return inventoryButton;
    }

    public static JButton setInventoryButton(String text) {
        inventoryButton = new JButton(text);
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        return inventoryButton;
    }

    public static JPanel getReturnPanel() {
        return returnPanel;
    }

    public static void setReturnPanel(JButton button) {
        returnPanel = new JPanel();
        returnPanel.setBounds(50, 50, 120, 50);
        returnPanel.setBorder(null);
        returnPanel.setOpaque(false);
        returnPanel.add(button);
    }

    public static JButton getReturnButton() {
        return returnButton;
    }

    public static JButton setReturnButton(String text) {
        returnButton = new JButton(text);
        returnButton.setBackground(Color.black);
        returnButton.setForeground(Color.white);
        returnButton.setFont(normalFont);
        return returnButton;
    }

    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    public void setPlayerPanel(JPanel playerPanel) {
        this.playerPanel = playerPanel;
    }

    public JPanel getAudioButtonPanel() {
        return audioButtonPanel;
    }

    public void setAudioButtonPanel(JPanel audioButtonPanel) {
        this.audioButtonPanel = audioButtonPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public static JLabel setTitleLabel(String text) {
        titleLabel = new JLabel(text);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);
        return titleLabel;
    }

    public JLabel getHpLabel() {
        return hpLabel;
    }

    public void setHpLabel(JLabel hpLabel) {
        this.hpLabel = hpLabel;
    }

    public JLabel getHpLabelNum() {
        return hpLabelNum;
    }

    public void setHpLabelNum(JLabel hpLabelNum) {
        this.hpLabelNum = hpLabelNum;
    }

    public JLabel getLocLabel() {
        return locLabel;
    }

    public void setLocLabel(JLabel locLabel) {
        this.locLabel = locLabel;
    }

    public JLabel getLocLabelCurrent() {
        return locLabelCurrent;
    }

    public void setLocLabelCurrent(JLabel locLabelCurrent) {
        this.locLabelCurrent = locLabelCurrent;
    }

    public JLabel getInvLabel() {
        return invLabel;
    }

    public void setInvLabel(JLabel invLabel) {
        this.invLabel = invLabel;
    }

    public JLabel getInvLabelItems() {
        return invLabelItems;
    }

    public void setInvLabelItems(JLabel invLabelItems) {
        this.invLabelItems = invLabelItems;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public static JButton setStartButton(String text) {
        startButton = new JButton(text);
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        return startButton;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar() {
        menuBar = new JMenuBar();
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(String text) {
        menu.add(text);
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem() {
        menuItem = new JMenuItem();
    }

    public static JTextField getInputField() {
        return inputField;
    }

    public void setInputField() {
        inputField = new JTextField("Please enter a text ", 200);
        inputField.setBounds(50, 570, 500, 50);
        inputField.setForeground(Color.black);
        inputField.setBackground(Color.white);
    }

    public JPanel getHubTitlePanel() {
        return hubTitlePanel;
    }

    public static void setHubTitlePanel(JLabel label) {
        hubTitlePanel = new JPanel();
        hubTitlePanel.setBounds(500, 70, 300, 100);
        hubTitlePanel.setOpaque(false);
        hubTitlePanel.add(label);
    }

    public static JLabel getHubTitleLabel() {
        return hubTitleLabel;
    }

    public static JLabel setHubTitleLabel(String text) {
        hubTitleLabel = new JLabel(text);
        hubTitleLabel.setForeground(Color.white);
        hubTitleLabel.setFont(titleFont);
        return hubTitleLabel;
    }
}
