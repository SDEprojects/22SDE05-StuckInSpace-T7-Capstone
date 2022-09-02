package com.learning.capstone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

public class SaveGame {
    // TODO The following variables should read from current game status.
    String saveCharName = "Nina";
    String saveCharLocation = "Alien Outpost";
    List<String> saveCharInventory = Arrays.asList("basement_key", "TM");

    public void saveGame(){
        // Add saved info
        JSONObject saveOBJ = new JSONObject();
        saveOBJ.put("playerName", saveCharName);
        saveOBJ.put("playerLocation", saveCharLocation);
        saveOBJ.put("playerInventory", saveCharInventory);
        System.out.println(saveOBJ); // Test

        // Add saved info to list
        JSONArray saveList = new JSONArray();
        saveList.add(saveOBJ);
        System.out.println(saveList);

        // Write to JSON file
        try (FileWriter file = new FileWriter("player_save.json")) {
            file.write(saveList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
