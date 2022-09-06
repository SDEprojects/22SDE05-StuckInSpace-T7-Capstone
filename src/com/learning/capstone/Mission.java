package com.learning.capstone;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Mission {
    private Location locations;
    private Item items;
    private NPC npcs;
    private Menu menus;

    public Mission(){
        this.locations = new Location();
        this.items = new Item();
        this.npcs = new NPC();
        this.menus = new Menu();
    }

    public Location getLocations() {
        return locations;
    }

    public void setLocations(Location locations) {
        this.locations = locations;
    }

    public Item getItems() {
        return items;
    }

    public Menu getMenus() {
        return menus;
    }

    public void setMenus(Menu menus) {
        this.menus = menus;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public NPC getNpcs() {
        return npcs;
    }

    public void setNpcs(NPC npcs) {
        this.npcs = npcs;
    }

    public void getMainMenu(){
        getMenus().mainMenu();
    }

    public void getInventoryMenu(){
        getMenus().inventoryMenu();
    }

    public void getMissionsMenu(){
        getMenus().missionsMenu();
    }

    public void getHelpMenu(){
        getMenus().helpMenu();
    }

    public boolean isExitAvailable(String start, String exit){
        boolean isExit = false;
        String exitRequest = start + "_exit";
        for (Object obj : this.locations.getLocDict()) {
            JSONObject mission = (JSONObject) obj;
            System.out.println(mission);
        }
        return isExit;
    }
}
