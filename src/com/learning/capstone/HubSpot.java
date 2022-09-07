package com.learning.capstone;

import org.json.simple.JSONObject;


public class HubSpot {
    SaveGame savegame;

    private Hero hero;
    JSONObject heroPosition = new JSONObject();

    public HubSpot(){
        this.savegame = new SaveGame();
        this.heroPosition.put("Current_position", "start");
        this.heroPosition.put("Previous_position", "hub");
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

    public String getHeroPrevPosition(){
        return (String) this.heroPosition.get("Previous_position");
    }


    private void updatePositions(String oldPosition, String newPosition){
        this.heroPosition.put("Previous_position", oldPosition);
        this.heroPosition.put("Current_position", newPosition);
    }

    public void getHeroStatus(){

    }


}
