package com.learning.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[5];

    public Sound() {
        soundURL[0] = getClass().getClassLoader().getResource("Infinity_Clip.wav");
        soundURL[1] = getClass().getClassLoader().getResource("Item_PU.wav");
        soundURL[2] = getClass().getClassLoader().getResource("alien_cackle.wav");
        soundURL[3] = getClass().getClassLoader().getResource("item_pickup.wav");
        soundURL[4] = getClass().getClassLoader().getResource("deepscan.wav");

    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
        }
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
