package com.learning.controller;

import com.learning.datamodel.Hero;
import com.learning.datamodel.NPC;
import com.learning.view.SaveGame;
import org.json.simple.JSONObject;

public class HubSpot {
    SaveGame savegame;
    private Hero hero;
    private NPC npcs;
    JSONObject heroPosition;

    public HubSpot(){
        this.savegame = new SaveGame();
        this.heroPosition = new JSONObject();
        this.heroPosition.put("Current_position", "start");
        this.heroPosition.put("Previous_position", "hub");
        this.hero = new Hero();
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public NPC getNpcs() {
        return npcs;
    }

    public void setNpcs(NPC npcs) {
        this.npcs = npcs;
    }

    public void autoSaveGame(){
        this.savegame.saveGame();
    }

    public void setPlayerName(String name){
        this.hero.setHeroName(name);
    }

    public String getPlayerName(){
        return this.hero.getHeroName();
    }

    public void showPlayerProfile(){
        getHero().displayHeroProfile();
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
