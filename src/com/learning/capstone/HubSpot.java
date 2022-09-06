package com.learning.capstone;

import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;

public class HubSpot {
    SaveGame savegame;

    private Hero hero;
    JSONObject heroPosition = new JSONObject();

    public HubSpot(){
        List<String> saveCharInventory = Arrays.asList("basement_key", "TM");
        this.savegame = new SaveGame();
        this.heroPosition.put("Current_position", "start");
        this.heroPosition.put("Previous_position", "hub");
        this.heroPosition.put("current_exits", saveCharInventory);
    }

    public void autoSaveGame(){
        this.savegame.saveGame();
    }

    public void setHeroPosition(String position){
        updatePositions((String) this.heroPosition.get("Current_position"), position);
    }

    public String getHeroPosition(){
        return (String) this.heroPosition.get("Current_position");
    }


    private void updatePositions(String oldPosition, String newPosition){
        this.heroPosition.put("Previous_position", oldPosition);
        this.heroPosition.put("Current_position", newPosition);
    }

    public void getHeroStatus(){

    }


}
