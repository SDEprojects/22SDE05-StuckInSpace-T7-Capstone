package com.learning.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container con;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel;
    JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);
    JButton startButton, choice1, choice2, choice3, choice4, audioButton;
    JTextArea mainTextArea;



    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        window = new JFrame();
        // Just for refresh purposes and for background image
        window.setSize(800,600);
        /**window.setSize(1279,718);
        window.setSize(1280,719);**/
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        // future implementation of background image
        //window.setContentPane(new JLabel(new ImageIcon("resources/StuckInSpace.jpg")));
        window.setLayout(null);
        window.pack();
        window.setVisible(true);
        con = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100,150,600,250);
        // sizing for image bg
        //titlePanel.setBounds(340,50,600,100);
        titlePanel.setOpaque(false);
        titleLabel = new JLabel("Stuck In Outer Space");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        // sizing for image bg
        //startButtonPanel.setBounds(560,575,140,50);
        startButtonPanel.setBorder(null);
        startButtonPanel.setOpaque(false);

        startButton = new JButton("START");
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        con.add(titlePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen(){

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // main text area configuration
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setOpaque(false);
        //mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Pokem ipsum dolor sit amet Caterpie Leech Life Skiploom Bouffalant Ho-oh quis " +
                "nostrud exercitation. Ice Blaziken Shroomish Jellicent Tornadus Gothorita Diglett. Fire Reuniclus. ");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Audio Button Configuration
        audioButtonPanel = new JPanel();
        audioButtonPanel.setBounds(20, 28, 120, 25);
        audioButtonPanel.setOpaque(false);
        //audioButtonPanel.setBackground(Color.blue);
        audioButtonPanel.setLayout(new GridLayout(1,1));
        con.add(audioButtonPanel);

        audioButton = new JButton("Audio On/Off");
        audioButton.setBackground(Color.black);
        audioButton.setForeground(Color.black);
        audioButton.setFont(audioFont);
        audioButton.addActionListener(tsHandler);
        audioButtonPanel.add(audioButton);


        // Choice Button Configuration
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 325, 150);
        choiceButtonPanel.setOpaque(false);
        //choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(200,15,600,50);
        playerPanel.setOpaque(false);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(playerFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);


    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }
}
