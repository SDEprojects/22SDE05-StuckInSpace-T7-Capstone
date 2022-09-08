package com.learning.view;

import com.learning.utility.FileHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

public class SaveGame {
    // TODO The following variables should read from current game status.
    String saveCharName;
    String saveCharLocation;
    JSONArray saveCharInventory;

    public void saveGame(){
        // Add saved info
    }

    public String getSaveCharName() {
        return saveCharName;
    }

    public void setSaveCharName(String saveCharName) {
        this.saveCharName = saveCharName;
    }

    public String getSaveCharLocation() {
        return saveCharLocation;
    }

    public void setSaveCharLocation(String saveCharLocation) {
        this.saveCharLocation = saveCharLocation;
    }

    public JSONArray getSaveCharInventory() {
        return saveCharInventory;
    }

    public void setSaveCharInventory(JSONArray saveCharInventory) {
        this.saveCharInventory = saveCharInventory;
    }
}
