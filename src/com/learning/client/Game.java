package com.learning.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel, hubTitlePanel, msnTitlePanel;
    JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems, hubTitleLabel, msnTitleLabel;
    JTextArea mainTextArea;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem m1, m2;

    // comments to fix

    // FONTS
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);

    // BUTTONS
    JButton startButton, missionBtn, invBtn, audioButton, returnBtn, alienMsnBtn;


    TitleScreenHandler tsHandler = new TitleScreenHandler();
    HubScreenHandler hsHandler = new HubScreenHandler();
    ReturnToHubHandler rthHandler = new ReturnToHubHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setPreferredSize(new Dimension(1280, 719));
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new JLabel(new ImageIcon("resources/StuckInSpace.jpg")));
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        con = window.getContentPane();

        // create menu bar
        menuBar = new JMenuBar();
        // create a menu
        menu = new JMenu("Menu");
        //create menu items
        m1 = new JMenuItem("Help");
        m2 = new JMenu("Leave");
        // add menu items to menu
        menu.add(m1);
        menu.add(m2);
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

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(565, 570, 140, 50);
        startButtonPanel.setBorder(null);
        startButtonPanel.setOpaque(false);

        startButton = new JButton("START");
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        window.pack();
    }

    public void createHubScreen() {

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        window.setContentPane(new JLabel(new ImageIcon("resources/The Hub Image.jpg")));
        con = window.getContentPane();

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
        mainTextPanel.setBounds(350, 300, 600, 250);
        mainTextPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Pokem ipsum dolor sit amet Caterpie Leech Life Skiploom Bouffalant Ho-oh quis " +
                "nostrud exercitation. Ice Blaziken Shroomish Jellicent Tornadus Gothorita Diglett. Fire Reuniclus. ");
        mainTextArea.setBounds(300, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Audio Button Configuration
        audioButtonPanel = new JPanel();
        audioButtonPanel.setBounds(20, 18, 120, 25);
        audioButtonPanel.setOpaque(false);
        //audioButtonPanel.setBackground(Color.blue);
        audioButtonPanel.setLayout(new GridLayout(1, 1));
        con.add(audioButtonPanel);

        audioButton = new JButton("Audio On/Off");
        audioButton.setBackground(Color.black);
        audioButton.setForeground(Color.black);
        audioButton.setFont(audioFont);
        //audioButton.addMouseListener();
        audioButtonPanel.add(audioButton);


        // Choice Button Configuration
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 525, 300, 120);
        choiceButtonPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(2, 1));
        con.add(choiceButtonPanel);

        missionBtn = new JButton("Missions");
        missionBtn.setBackground(Color.black);
        missionBtn.setForeground(Color.black);
        missionBtn.setFont(normalFont);
        missionBtn.addActionListener(hsHandler);
        choiceButtonPanel.add(missionBtn);

        invBtn = new JButton("Inventory");
        invBtn.setBackground(Color.black);
        invBtn.setForeground(Color.black);
        invBtn.setFont(normalFont);
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

        mainTextArea = new JTextArea("Pokem ipsum dolor sit amet Caterpie Leech Life Skiploom Bouffalant Ho-oh quis " +
                "nostrud exercitation. Ice Blaziken Shroomish Jellicent Tornadus Gothorita Diglett. Fire Reuniclus. ");
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
        alienMsnBtn.setForeground(Color.black);
        alienMsnBtn.setFont(normalFont);
        alienMsnBtn.addActionListener(hsHandler);
        choiceButtonPanel.add(alienMsnBtn);

        returnBtn = new JButton("Return to Hub");
        returnBtn.setBackground(Color.black);
        returnBtn.setForeground(Color.black);
        returnBtn.setFont(normalFont);
        returnBtn.addActionListener(rthHandler);
        choiceButtonPanel.add(returnBtn);
    }

    public class TitleScreenHandler implements ActionListener {
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
}
