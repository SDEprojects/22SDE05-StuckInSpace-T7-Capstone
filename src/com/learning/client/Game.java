package com.learning.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, hubTitlePanel, msnTitlePanel, introPanel,
    continueBtnPanel, alienTextPanel, alienTitlePanel, hangarBtnPanel;
    JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems, hubTitleLabel, msnTitleLabel, alienTitleLabel;
    JTextArea mainTextArea, introTextArea, alienTextArea;
    JMenuBar menuBar;
    JMenu menu, Audio;
    JMenuItem help, quit, AudioOn, AudioOff;

    //        //================================== FONTS ===========================================//
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);

    //        //================================== BUTTONS ===========================================//
    JButton startButton, missionBtn, invBtn, returnBtn, alienMsnBtn, continueBtn, messBtn, shipBtn;

    //        //================================== SCREEN HANDLERS ===========================================//
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    HubScreenHandler hsHandler = new HubScreenHandler();
    ReturnToHubHandler rthHandler = new ReturnToHubHandler();
    IntroScreenHandler isHandler = new IntroScreenHandler();
    AlienScreenHandler aoHandler = new AlienScreenHandler();
    InventoryHandler invHandler = new InventoryHandler();
    HangarScreenHandler hangarHandler = new HangarScreenHandler();
    HallwayScreenHandler hallHandler = new HallwayScreenHandler();
    MessHallScreenHandler messHandler = new MessHallScreenHandler();
    CSScreenHandler csHandler = new CSScreenHandler();
    SpaceShipScreenHandler spHandler = new SpaceShipScreenHandler();
    BasementScreenHandler bsHandler = new BasementScreenHandler();




    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setPreferredSize(new Dimension(1280, 719));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        //window.setContentPane(new JLabel(new ImageIcon("resources/StuckInSpace.jpg")));
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        con = window.getContentPane();

        // create menu bar
        menuBar = new JMenuBar();
        // create a menu
        menu = new JMenu("Menu");
        Audio = new JMenu("Audio");
        //create menu items
        help = new JMenuItem("Help");
        quit = new JMenuItem("Quit");
        AudioOn = new JMenuItem("Audio On");
        AudioOff = new JMenuItem("Audio Off");

        // add menu items to menu
        menu.add(Audio);
        menu.add(help);
        menu.add(quit);
        Audio.add(AudioOn);
        Audio.add(AudioOff);
        // add menu to menu bar
        menuBar.add(menu);
        // add menu bar to JFrame
        window.setJMenuBar(menuBar);

        titlePanel = new JPanel();
        titlePanel.setBounds(340, 40, 600, 100);
        titlePanel.setOpaque(false);
        titleLabel = new JLabel("Stuck In Outer Space");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);
        con.add(titlePanel);

        // Start Button Configuration
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(565, 570, 140, 50);
        startButtonPanel.setBorder(null);
        startButtonPanel.setOpaque(false);

        startButton = new JButton("New Game");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        window.pack();
    }

    public void introScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        //con = window.getContentPane();

        // main text area configuration
        introPanel = new JPanel();
        introPanel.setBounds(350, 50, 600, 300);
        introPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(introPanel);

        introTextArea = new JTextArea("You are an ex-Army, introverted, solo space\n traveler with a very particular set " +
                "of skills. He is currently on a journey to the deserted planet Surt, to find the ultimate solitude.\n" +
                "Your skills: 9th degree red belt, sharp shooter,\n superb engineer.\n" +
                "Items currently in your possession are a compass and laser gun");
        introTextArea.setBounds(300, 50, 600, 300);
        introTextArea.setBackground(Color.black);
        introTextArea.setForeground(Color.white);
        introTextArea.setFont(normalFont);
        introTextArea.setLineWrap(true);
        introPanel.add(introTextArea);

        // Choice Button Configuration
        continueBtnPanel = new JPanel();
        continueBtnPanel.setBounds(550, 400, 200, 80);
        continueBtnPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        continueBtnPanel.setLayout(new GridLayout(1, 1));
        con.add(continueBtnPanel);

        continueBtn = new JButton("Continue");
        continueBtn.setBackground(Color.black);
        continueBtn.setForeground(Color.white);
        continueBtn.setFont(normalFont);
        continueBtn.addActionListener(isHandler);
        continueBtnPanel.add(continueBtn);
    }
    public void createHubScreen() {

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        /**window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();**/

        hubTitlePanel = new JPanel();
        hubTitlePanel.setBounds(500, 70, 300, 100);
        hubTitlePanel.setOpaque(false);
        hubTitleLabel = new JLabel("THE HUB");
        hubTitleLabel.setForeground(Color.white);
        hubTitleLabel.setFont(titleFont);
        hubTitlePanel.add(hubTitleLabel);
        con.add(hubTitlePanel);

        // main text area configuration
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(350, 200, 600, 250);
        mainTextPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("You are at the hub. Here you may choose the\n mission you would like to play\n " +
                "or check your inventory.");
        mainTextArea.setBounds(300, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Choice Button Configuration
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 400, 300, 120);
        choiceButtonPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2, 1));
        con.add(choiceButtonPanel);

        missionBtn = new JButton("Missions");
        missionBtn.setBackground(Color.black);
        missionBtn.setForeground(Color.white);
        missionBtn.setFont(normalFont);
        missionBtn.addActionListener(hsHandler);
        choiceButtonPanel.add(missionBtn);

        invBtn = new JButton("Inventory");
        invBtn.setBackground(Color.black);
        invBtn.setForeground(Color.white);
        invBtn.setFont(normalFont);
        invBtn.addActionListener(invHandler);
        choiceButtonPanel.add(invBtn);

        // Player Status Panel
        playerPanel = new JPanel();
        playerPanel.setBounds(400, 5, 800, 50);
        playerPanel.setOpaque(false);
        playerPanel.setLayout(new GridLayout(1, 6));
        con.add(playerPanel);

        // HP Status
        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(playerFont);
        hpLabel.setForeground(Color.white);
        hpLabelNum = new JLabel();
        hpLabelNum.setFont(playerFont);
        hpLabelNum.setForeground(Color.white);

        // Location Status
        locLabel = new JLabel("Location: ");
        locLabel.setFont(playerFont);
        locLabel.setForeground(Color.white);
        locLabelCurrent = new JLabel();
        locLabelCurrent.setFont(playerFont);
        locLabelCurrent.setForeground(Color.white);

        // Inventory Status
        invLabel = new JLabel("Inventory: ");
        invLabel.setFont(playerFont);
        invLabel.setForeground(Color.white);
        invLabelItems = new JLabel();
        invLabelItems.setFont(playerFont);
        invLabelItems.setForeground(Color.white);

        //Player Panel Displayed
        playerPanel.add(hpLabel);
        playerPanel.add(hpLabelNum);
        playerPanel.add(locLabel);
        playerPanel.add(locLabelCurrent);
        playerPanel.add(invLabel);
        playerPanel.add(invLabelItems);
    }

    public void inventoryScreen() {
        hubTitlePanel.setVisible(false);
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/inventory.png")));
        //con = window.getContentPane();


    }
    public void createMissionScreen() {

        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        hubTitlePanel.setVisible(false);

        msnTitlePanel = new JPanel();
        msnTitlePanel.setBounds(500, 70, 300, 100);
        msnTitlePanel.setOpaque(false);
        msnTitleLabel = new JLabel("Missions");
        msnTitleLabel.setForeground(Color.white);
        msnTitleLabel.setFont(titleFont);
        msnTitlePanel.add(msnTitleLabel);
        con.add(msnTitlePanel);

        // main text area configuration
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(350, 250, 600, 250);
        mainTextPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("You are at the hub. Here you may choose the\n mission you'd like to play, " +
                "check your inventory, get help, or return to the Hub. ");
        mainTextArea.setBounds(300, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Choice Button Configuration
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 425, 300, 120);
        choiceButtonPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2, 1));
        con.add(choiceButtonPanel);

        alienMsnBtn = new JButton("Alien Outpost");
        alienMsnBtn.setBackground(Color.black);
        alienMsnBtn.setForeground(Color.white);
        alienMsnBtn.setFont(normalFont);
        alienMsnBtn.addActionListener(aoHandler);
        choiceButtonPanel.add(alienMsnBtn);

        returnBtn = new JButton("Return to Hub");
        returnBtn.setBackground(Color.black);
        returnBtn.setForeground(Color.white);
        returnBtn.setFont(normalFont);
        returnBtn.addActionListener(rthHandler);
        choiceButtonPanel.add(returnBtn);
    }

    public void alienOutpostScreen() {
        choiceButtonPanel.setVisible(false);
        msnTitlePanel.setVisible(false);
        mainTextPanel.setVisible(false);

        alienTitlePanel = new JPanel();
        alienTitlePanel.setBounds(350, 100, 600, 100);
        alienTitlePanel.setOpaque(false);
        alienTitleLabel = new JLabel("ALIEN OUTPOST");
        alienTitleLabel.setForeground(Color.white);
        alienTitleLabel.setFont(titleFont);
        alienTitlePanel.add(alienTitleLabel);
        con.add(alienTitlePanel);

        // main text area configuration
        alienTextPanel = new JPanel();
        alienTextPanel.setBounds(350, 250, 600, 250);
        alienTextPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(alienTextPanel);

        alienTextArea = new JTextArea("You find yourself in a strange field. Everything\n has been cleared out and" +
                "all that stands before\n you is an unknown tower.");
        alienTextArea.setBounds(300, 100, 600, 250);
        alienTextArea.setBackground(Color.black);
        alienTextArea.setForeground(Color.white);
        alienTextArea.setFont(normalFont);
        alienTextArea.setLineWrap(true);
        alienTextPanel.add(alienTextArea);

        // Choice Button Configuration
        continueBtnPanel = new JPanel();
        continueBtnPanel.setBounds(550, 400, 200, 80);
        continueBtnPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        continueBtnPanel.setLayout(new GridLayout(1, 1));
        con.add(continueBtnPanel);

        continueBtn = new JButton("Let's explore!");
        continueBtn.setBackground(Color.black);
        continueBtn.setForeground(Color.white);
        continueBtn.setFont(normalFont);
        continueBtn.addActionListener(hangarHandler);
        continueBtnPanel.add(continueBtn);
    }

    public void hangarScreen() {
        alienTitlePanel.setVisible(false);
        alienTextPanel.setVisible(false);
        continueBtnPanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/hangar2.jpg")));
        //con = window.getContentPane();

        // Choice Button Configuration
        hangarBtnPanel = new JPanel();
        hangarBtnPanel.setBounds(500, 400, 300, 120);
        hangarBtnPanel.setOpaque(false);
        choiceButtonPanel.setBackground(Color.black);
        hangarBtnPanel.setLayout(new GridLayout(2, 1));
        con.add(hangarBtnPanel);

        messBtn = new JButton("Hallway");
        messBtn.setBackground(Color.black);
        messBtn.setForeground(Color.white);
        messBtn.setFont(normalFont);
        messBtn.addActionListener(hallHandler);
        hangarBtnPanel.add(messBtn);

        shipBtn = new JButton("Space Ship");
        shipBtn.setBackground(Color.black);
        shipBtn.setForeground(Color.white);
        shipBtn.setFont(normalFont);
        shipBtn.addActionListener(spHandler);
        hangarBtnPanel.add(shipBtn);
    }

    public void hallwayScreen() {
        hangarBtnPanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/hallway.jpg")));
        //con = window.getContentPane();
    }

    public void messHallScreen() {

    }

    public void basementScreen() {

    }

    public void controlScreen() {

    }

    public void spaceshipScreen() {
        hangarBtnPanel.setVisible(false);
        //window.setContentPane(new JLabel(new ImageIcon("resources/Spaceship_Cockpit.jpg")));
        //con = window.getContentPane();
    }

    //        //================================== ACTION LISTENERS ===========================================//
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            introScreen();
        }
    }
    public class IntroScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            createHubScreen();
        }
    }
    public class HubScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            createMissionScreen();
        }
    }
    public class ReturnToHubHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            createHubScreen();
        }
    }
    public class InventoryHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            inventoryScreen();
        }
    }
    public class AlienScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            alienOutpostScreen();
        }
    }
    public class HangarScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            hangarScreen();
        }
    }
    public class HallwayScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            hallwayScreen();
        }
    }
    public class BasementScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }
    public class MessHallScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }
    public class CSScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {

        }
    }
    public class SpaceShipScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            spaceshipScreen();
        }
    }
}
