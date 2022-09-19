package com.learning.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui {
    public static final Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    public static final Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public static final Font audioFont = new Font("Times New Roman", Font.PLAIN, 15);
    public static final Font playerFont = new Font("Times New Roman", Font.PLAIN, 25);

    static JFrame window;
    static Container con;
    static JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, audioButtonPanel;
    static JLabel titleLabel, hpLabel, hpLabelNum, locLabel, locLabelCurrent, invLabel, invLabelItems;

    static JButton startButton, choice1, choice2, choice3, choice4, audioButton;
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
        inputField = new JTextField();
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

    public void setMainTextPanel() {
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setOpaque(false);
        mainTextPanel.add(mainTextArea);
    }

    public JTextArea getMainTextArea() {
        return mainTextArea;
    }

    public void setMainTextArea(String text) {
        mainTextArea.append(text);
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setLineWrap(true);
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

    public void setStartButtonPanel(JButton startButton) {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(565, 570, 140, 50);
        startButtonPanel.setBorder(null);
        startButtonPanel.setOpaque(false);
        startButtonPanel.add(startButton);
    }

    public JPanel getChoiceButtonPanel() {
        return choiceButtonPanel;
    }

    public void setChoiceButtonPanel(JPanel choiceButtonPanel) {
        this.choiceButtonPanel = choiceButtonPanel;
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

    public JLabel setTitleLabel(String text) {
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

    public JButton setStartButton(String text) {
        startButton = new JButton(text);
        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        return startButton;
    }

    public JButton getChoice1() {
        return choice1;
    }

    public void setChoice1(JButton choice1) {
        this.choice1 = choice1;
    }

    public JButton getChoice2() {
        return choice2;
    }

    public void setChoice2(JButton choice2) {
        this.choice2 = choice2;
    }

    public JButton getChoice3() {
        return choice3;
    }

    public void setChoice3(JButton choice3) {
        this.choice3 = choice3;
    }

    public JButton getChoice4() {
        return choice4;
    }

    public void setChoice4(JButton choice4) {
        this.choice4 = choice4;
    }

    public JButton getAudioButton() {
        return audioButton;
    }

    public void setAudioButton(JButton audioButton) {
        this.audioButton = audioButton;
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
}
