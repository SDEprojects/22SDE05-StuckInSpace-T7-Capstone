package com.learning.client;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.Object;
import java.text.DecimalFormat;
import javax.swing.*;

import static com.learning.client.GameGui.*;

public class TimeHandler {
    static Timer timer;
    static int second, minute;
    static String ddSecond;
    static String ddMinute;
    static DecimalFormat decimalFormat = new DecimalFormat("00");

    public static void setTimer() {

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
                }
            }
        });
    }

}
