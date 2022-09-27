package com.learning.client;

import com.learning.view.Menu;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.text.DecimalFormat;
import java.util.Objects;
import javax.swing.*;

import static com.learning.client.GameGui.*;

public class TimeHandler {
    static Timer timer;
    static int second, minute;
    static String ddSecond;
    static String ddMinute;
    static DecimalFormat decimalFormat = new DecimalFormat("00");
    static final JFrame newWindow = new JFrame("Game over");

    public static void setTimer() {
        HubScreenHandler hubScreenHandler = new HubScreenHandler();
        GameScreenHandler gameScreenHandler = new GameScreenHandler();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                ddSecond = decimalFormat.format(second);
                ddMinute = decimalFormat.format(minute);
                countTimeLabel.setText(ddMinute + ":" + ddSecond);
                if (second == -1) {
                    second = 59;
                    minute --;
                    ddSecond = decimalFormat.format(second);
                    ddMinute = decimalFormat.format(minute);
                    countTimeLabel.setText(ddMinute + ":" + ddSecond);
                }
                if (minute == 0 && second == 0) {
                    timer.stop();
                    try {
                        Thread.sleep(2);
                        window.setVisible(false);
                        window.setLayout(new FlowLayout());
                        window.setVisible(true);
                        window.setContentPane(new JLabel(new ImageIcon(Objects.requireNonNull(ExploreMissionScreenHandler.class.getClassLoader().getResource("StuckInSpace.jpg")))));
                        con = window.getContentPane();
                        setTitlePanel(setTitleLabel(Menu.gameOverMessage()));
                        window.add(getTitlePanel());
                        con.add(mainTextPanel);
//                        setStartButtonPanel(setStartButton("Restart"));
//                        con.add(startButtonPanel);
                        window.pack();
//                        startButton.addActionListener(hubScreenHandler);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

}
