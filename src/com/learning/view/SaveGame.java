package com.learning.view;
import com.learning.utility.FileHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SaveGame {
    // TODO The following variables should read from current game status.
    private JSONArray savedGameStatus; //holds saved game data
    private String savePlayerName;
    //String savePlayerLocation;
    private JSONArray savePlayerInventory;

    //public static void newGame(){}

    public SaveGame(){
        //When game starts should save:
        //hero name, location, items in inventory, map status
        this.savedGameStatus = new FileHandler().readJsonFile("player_save.json");
        buildSavedGame(); //instantiate variables from game status
    }

    public void buildSavedGame () {
        JSONObject gameStatus = (JSONObject) this.savedGameStatus.get(0); //converts to JSON object
        this.savePlayerName = (String) gameStatus.get("playerName");
        //this.savePlayerLocation = (String) gameStatus.get("playerLocation");
        this.savePlayerInventory = (JSONArray) gameStatus.get("playerInventory");
    }

    public boolean loadGame() {
        boolean isLoadFile = false;
        JSONObject savedData = (JSONObject) this.savedGameStatus.get(0);
        if (!(savedData.get("playerName").equals("default"))) {

        }
        return isLoadFile;
    }

    public String getSavePlayerName() {
        return savePlayerName;
    }

    public void setSavePlayerName(String savePlayerName) {
        this.savePlayerName = savePlayerName;
    }

    public JSONArray getSavePlayerInventory() {
        return savePlayerInventory;
    }

    public void setSavePlayerInventory(JSONArray savePlayerInventory) {
        this.savePlayerInventory = savePlayerInventory;
    }

    public JSONArray getSavedGameStatus() {
        return savedGameStatus;
    }

    public void setSavedGameStatus(JSONArray savedGameStatus) {
        this.savedGameStatus = savedGameStatus;
    }
}
