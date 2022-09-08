package com.learning.controller;

import com.learning.datamodel.Hero;
import com.learning.datamodel.Item;
import com.learning.datamodel.Location;
import com.learning.datamodel.NPC;
import com.learning.view.Menu;
import com.learning.view.SaveGame;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HubSpot {
    SaveGame savegame;

    private Hero hero;
    private NPC npcs;
    JSONObject heroPosition = new JSONObject();

    public HubSpot(){
        this.savegame = new SaveGame();
        this.heroPosition.put("Current_position", "start");
        this.heroPosition.put("Previous_position", "hub");
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

    // TODO Henry added some functions starts here.
    ArrayList<String> itemFound = new ArrayList<>();
    public void getLookAround(){
        // This will print a list of items based on hero current location.
        Mission mission = new Mission();
        Item item = new Item();
        HubSpot hub = new HubSpot();

        itemFound.clear();
        itemFound = mission.getItems().getItemLocationList().get(hub.getHeroPosition());
//        System.out.println(hub.heroPosition);
//        System.out.println(hub.getHeroPosition()); // TODO hero location locked at start
        if (itemFound.size() > 0){

            for (int i = 0; i < itemFound.size(); i++){
                item.setItemCalledOut(itemFound.get(i));
                item.readItemFile();
                String itemFoundName = item.getItemName();
                System.out.println("\uD83D\uDE00 You found " + itemFoundName);
            }

        } else {
            System.out.println("\uD83D\uDE12 No item is found at this location");
        }

    }

    // Pick function.
    public void addToInventory(){
        Mission mission = new Mission();
        Item item = new Item();
        HubSpot hub = new HubSpot();
        Map itemFoundMap = mission.getItems().getItemLocationList();
//        System.out.println(itemFoundMap.size());
        if (itemFound.size() > 0){
            for (int i = 0; i < itemFound.size(); i++){
                item.backpackList.add(itemFound.get(i));
                item.setItemCalledOut(itemFound.get(i));
                item.readItemFile();
                System.out.println(item.getItemName() + " is added to your backpack \uD83C\uDF92" );
            }
            itemFoundMap.remove(hub.getHeroPosition());

        }

    }



    // TODO Henry added some functions ends here.

}


