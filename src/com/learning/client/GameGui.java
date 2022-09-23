package com.learning.client;

import javax.swing.*;
import java.awt.*;

public class GameGui {
    public static final Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    public static final Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public static final Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    public static final Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);
    public static final Font missionFont = new Font("Times New Roman", Font.PLAIN, 40);

    static JFrame window;
    static Container con;
    static JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel, hubTitlePanel, inventoryTitlePanel, missionTitlePanel, returnPanel, locationsButtonPanel, exploreMissionPanel, exploreInventoryPanel, inventoryButtonsPanel;
    static JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems, hubTitleLabel, inventoryTitleLabel, missionTitleLabel, exploreMissionLabel, exploreInventoryLabel;
    static JButton startButton, missionButton, inventoryButton, returnButton, nextLocationButton, hangarButton, basementButton, engineroomButton, controlstationButton, messhallButton, hallwayButton, spaceshipButton;
    static JButton fuelButton, engineButton, bioSuitButton, tmButton, keyCardButton, basementKeyButton, toolkitButton, gpsButton, knifeButton, rifleButton, pistolButton, laserGunButton, imtvButton, achButton, glovesButton, bootsButton, compassButton;
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

    public static void setPlayerPanel() {
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 5, 800, 50);
        playerPanel.setOpaque(false);
        playerPanel.setLayout(new GridLayout(1, 6));
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

    public static JLabel getLocLabel() {
        return locLabel;
    }

    public static void setLocLabel(String text) {
        locLabel = new JLabel("Current location: " + text);
        locLabel.setFont(playerFont);
        locLabel.setFont(missionFont);
        locLabel.setForeground(Color.white);
    }

    public static JPanel getLocationsButtonPanel() {
        return locationsButtonPanel;
    }

    public static void setLocationsButtonPanel() {
        locationsButtonPanel = new JPanel();
        locationsButtonPanel.setBounds(200, 200, 300, 500);
        locationsButtonPanel.setOpaque(false);
        locationsButtonPanel.setLayout(new GridLayout(7, 1));
    }

    public static JPanel getInventoryButtonsPanel() {
        return inventoryButtonsPanel;
    }

    public static void setInventoryButtonsPanel() {
        inventoryButtonsPanel = new JPanel();
        inventoryButtonsPanel.setBounds(600, 200, 300, 800);
        inventoryButtonsPanel.setOpaque(false);
        inventoryButtonsPanel.setLayout(new GridLayout(9, 2));
    }

    public static JPanel getExploreMissionPanel() {
        return exploreMissionPanel;
    }

    public static void setExploreMissionPanel(JLabel label) {
        exploreMissionPanel = new JPanel();
        exploreMissionPanel.setBounds(100, 100, 500, 500);
        exploreMissionPanel.setOpaque(false);
        exploreMissionPanel.add(label);
    }

    public static JPanel getExploreInventoryPanel() {
        return exploreInventoryPanel;
    }

    public static void setExploreInventoryPanel(JLabel label) {
        exploreInventoryPanel = new JPanel();
        exploreInventoryPanel.setBounds(600, 100, 600, 500);
        exploreInventoryPanel.setOpaque(false);
        exploreInventoryPanel.add(label);
    }

    public static JLabel getExploreMissionLabel() {
        return exploreMissionLabel;
    }

    public static JLabel setExploreMissionLabel(String text) {
        exploreMissionLabel = new JLabel(text);
        exploreMissionLabel.setFont(missionFont);
        exploreMissionLabel.setForeground(Color.white);
        return exploreMissionLabel;
    }

    public static JLabel getExploreInventoryLabel() {
        return exploreInventoryLabel;
    }

    public static JLabel setExploreInventoryLabel(String text) {
        exploreInventoryLabel = new JLabel(text);
        exploreInventoryLabel.setFont(missionFont);
        exploreInventoryLabel.setForeground(Color.white);
        return exploreInventoryLabel;
    }

    public static JButton getNextLocationButton() {
        return nextLocationButton;
    }

    public static void setNextLocationButton(String text) {
        nextLocationButton = new JButton(text);
        nextLocationButton.setBackground(Color.black);
        nextLocationButton.setForeground(Color.white);
        nextLocationButton.setFont(normalFont);
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

    public static JButton getHangarButton() {
        return hangarButton;
    }

    public static void setHangarButton() {
        hangarButton = new JButton("hangar");
        hangarButton.setBackground(Color.black);
        hangarButton.setForeground(Color.white);
        hangarButton.setFont(normalFont);
    }

    public static JButton getBasementButton() {
        return basementButton;
    }

    public static void setBasementButton() {
        basementButton = new JButton("basement");
        basementButton.setBackground(Color.black);
        basementButton.setForeground(Color.white);
        basementButton.setFont(normalFont);
    }

    public static JButton getEngineroomButton() {
        return engineroomButton;
    }

    public static void setEngineroomButton() {
        engineroomButton = new JButton("engineroom");
        engineroomButton.setBackground(Color.black);
        engineroomButton.setForeground(Color.white);
        engineroomButton.setFont(normalFont);
    }

    public static JButton getControlstationButton() {
        return controlstationButton;
    }

    public static void setControlstationButton() {
        controlstationButton = new JButton("controlstation");
        controlstationButton.setBackground(Color.black);
        controlstationButton.setForeground(Color.white);
        controlstationButton.setFont(normalFont);
    }

    public static JButton getMesshallButton() {
        return messhallButton;
    }

    public static void setMesshallButton() {
        messhallButton = new JButton("messhall");
        messhallButton.setBackground(Color.black);
        messhallButton.setForeground(Color.white);
        messhallButton.setFont(normalFont);
    }

    public static JButton getHallwayButton() {
        return hallwayButton;
    }

    public static void setHallwayButton() {
        hallwayButton = new JButton("hallway");
        hallwayButton.setBackground(Color.black);
        hallwayButton.setForeground(Color.white);
        hallwayButton.setFont(normalFont);
    }

    public static JButton getSpaceshipButton() {
        return spaceshipButton;
    }

    public static void setSpaceshipButton() {
        spaceshipButton = new JButton("spaceship");
        spaceshipButton.setBackground(Color.black);
        spaceshipButton.setForeground(Color.white);
        spaceshipButton.setFont(normalFont);
    }

    public static JButton getFuelButton() {
        return fuelButton;
    }

    public static void setFuelButton() {
        fuelButton = new JButton("fuel");
        fuelButton.setBackground(Color.black);
        fuelButton.setForeground(Color.white);
        fuelButton.setFont(normalFont);
    }

    public static JButton getEngineButton() {
        return engineButton;
    }

    public static void setEngineButton() {
        engineButton = new JButton("engine");
        engineButton.setBackground(Color.black);
        engineButton.setForeground(Color.white);
        engineButton.setFont(normalFont);
    }

    public static JButton getBioSuitButton() {
        return bioSuitButton;
    }

    public static void setBioSuitButton() {
        bioSuitButton = new JButton("bio_suit");
        bioSuitButton.setBackground(Color.black);
        bioSuitButton.setForeground(Color.white);
        bioSuitButton.setFont(normalFont);
    }

    public static JButton getTmButton() {
        return tmButton;
    }

    public static void setTmButton() {
        tmButton = new JButton("TM");
        tmButton.setBackground(Color.black);
        tmButton.setForeground(Color.white);
        tmButton.setFont(normalFont);
    }

    public static JButton getKeyCardButton() {
        return keyCardButton;
    }

    public static void setKeyCardButton() {
        keyCardButton = new JButton("keycard");
        keyCardButton.setBackground(Color.black);
        keyCardButton.setForeground(Color.white);
        keyCardButton.setFont(normalFont);
    }

    public static JButton getBasementKeyButton() {
        return basementKeyButton;
    }

    public static void setBasementKeyButton() {
        basementKeyButton = new JButton("basement_key");
        basementKeyButton.setBackground(Color.black);
        basementKeyButton.setForeground(Color.white);
        basementKeyButton.setFont(normalFont);
    }

    public static JButton getToolkitButton() {
        return toolkitButton;
    }

    public static void setToolkitButton() {
        toolkitButton = new JButton("toolkit");
        toolkitButton.setBackground(Color.black);
        toolkitButton.setForeground(Color.white);
        toolkitButton.setFont(normalFont);
    }

    public static JButton getGpsButton() {
        return gpsButton;
    }

    public static void setGpsButton() {
        gpsButton = new JButton("GPS");
        gpsButton.setBackground(Color.black);
        gpsButton.setForeground(Color.white);
        gpsButton.setFont(normalFont);
    }

    public static JButton getKnifeButton() {
        return knifeButton;
    }

    public static void setKnifeButton() {
        knifeButton = new JButton("knife");
        knifeButton.setBackground(Color.black);
        knifeButton.setForeground(Color.white);
        knifeButton.setFont(normalFont);
    }

    public static JButton getRifleButton() {
        return rifleButton;
    }

    public static void setRifleButton() {
        rifleButton = new JButton("rifle");
        rifleButton.setBackground(Color.black);
        rifleButton.setForeground(Color.white);
        rifleButton.setFont(normalFont);
    }

    public static JButton getPistolButton() {
        return pistolButton;
    }

    public static void setPistolButton() {
        pistolButton = new JButton("pistol");
        pistolButton.setBackground(Color.black);
        pistolButton.setForeground(Color.white);
        pistolButton.setFont(normalFont);
    }

    public static JButton getLaserGunButton() {
        return laserGunButton;
    }

    public static void setLaserGunButton() {
        laserGunButton = new JButton("laser_gun");
        laserGunButton.setBackground(Color.black);
        laserGunButton.setForeground(Color.white);
        laserGunButton.setFont(normalFont);
    }

    public static JButton getImtvButton() {
        return imtvButton;
    }

    public static void setImtvButton() {
        imtvButton = new JButton("IMTV");
        imtvButton.setBackground(Color.black);
        imtvButton.setForeground(Color.white);
        imtvButton.setFont(normalFont);
    }

    public static JButton getAchButton() {
        return achButton;
    }

    public static void setAchButton() {
        achButton = new JButton("ACH");
        achButton.setBackground(Color.black);
        achButton.setForeground(Color.white);
        achButton.setFont(normalFont);
    }

    public static JButton getGlovesButton() {
        return glovesButton;
    }

    public static void setGlovesButton() {
        glovesButton = new JButton("gloves");
        glovesButton.setBackground(Color.black);
        glovesButton.setForeground(Color.white);
        glovesButton.setFont(normalFont);
    }

    public static JButton getBootsButton() {
        return bootsButton;
    }

    public static void setBootsButton() {
        bootsButton = new JButton("boots");
        bootsButton.setBackground(Color.black);
        bootsButton.setForeground(Color.white);
        bootsButton.setFont(normalFont);
    }

    public static JButton getCompassButton() {
        return compassButton;
    }

    public static void setCompassButton() {
        compassButton = new JButton("compass");
        compassButton.setBackground(Color.black);
        compassButton.setForeground(Color.white);
        compassButton.setFont(normalFont);
    }
}
