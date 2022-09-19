package com.learning.client;

import com.learning.view.Menu;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.learning.client.GameGui.*;

public class GameClient {

    public static void main(String[] args) throws IOException {
        Menu.getMainMessage();
        Menu.getFirstMenu();
        GameManager.runGame();
    }
}

