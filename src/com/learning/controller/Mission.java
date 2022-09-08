package com.learning.controller;

import com.learning.datamodel.Item;
import com.learning.datamodel.Location;
import com.learning.view.Menu;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Mission {
    private Location locations;
    private Item items;
    private Menu menus;

    public Mission(){
        this.locations = new Location();
        this.items = new Item();
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

    public void getMoveMenu(String start){
        getMenus().moveMenu(availableExits(start));
    }

    public void getActiveMissionMenu(){
        getMenus().activeMissionMenu();
    }

    public boolean isExitAvailable(String start, String exit){
        boolean isExit = false;
        String exitRequest = start + "_exit";
        for (Object obj : this.locations.getLocDict()) {
            JSONObject mission = (JSONObject) obj;
            JSONObject position = (JSONObject) mission.get("mission_01");
            JSONArray availableExits = (JSONArray) position.get(exitRequest);
            for (Object value: availableExits) {
                if (exit.equals(value)){
                    isExit = true;
                }
            }
        }
        return isExit;
    }
    private JSONArray availableExits(String start){
        JSONArray exits = null;
        String exitRequest = start + "_exit";
        for (Object obj : this.locations.getLocDict()) {
            JSONObject mission = (JSONObject) obj;
            JSONObject position = (JSONObject) mission.get("mission_01");
            exits = (JSONArray) position.get(exitRequest);
        }
        return exits;
    }


    // TODO Henry added some functions starts here.
    // TODO Look function needs to be moved up a level.

    public void lookAround(){
        for (Object obj : this.items.getItemDict()) {
            JSONObject items = (JSONObject) obj;
            JSONObject itemName = (JSONObject) items.get("fuel");
            JSONArray itemLocation = (JSONArray) itemName.get("location");
            System.out.println(items);
            System.out.println(itemName);
            System.out.println(itemLocation);
        }

    }

    public void pickItem(){

    }

    public void inspectItem(){
//        System.out.println(
//                "\n" + itemName +
//                        "\n" + itemDescription +
//                        "\nIt has " + itemPower
//                        + " \uD83E\uDD4APower  and " + itemDefense
//                        + " \uD83D\uDEE1Defense ."
//        );
    }


//    ArrayList<String> itemFound = mission.getItems().getItemLocationList().get(hub.getHeroPosition());
//                System.out.println("The hero found these items here.");
//                System.out.println(itemFound);
//                System.out.println("Enter \"Pick\" to grab the items");
//
//    // Adding pick function.
//                if (heroInput.equalsIgnoreCase("pick")){
//        System.out.println("You have added them to your inventory");
//        ArrayList<String> currentInventory = new ArrayList<String>();
//        currentInventory.addAll(itemFound);
//        System.out.println(currentInventory);

//    }

    // TODO Henry added functions ends here.

}
