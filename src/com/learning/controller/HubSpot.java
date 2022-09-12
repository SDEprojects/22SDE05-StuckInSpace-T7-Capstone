package com.learning.controller;

import com.learning.datamodel.Hero;
import com.learning.datamodel.Item;
import com.learning.datamodel.NPC;
import com.learning.utility.FileHandler;
import com.learning.view.Menu;
import com.learning.view.SaveGame;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HubSpot {
    SaveGame savegame;
    private Hero hero;
    private Item item;
    private NPC npcs;

    // TODO: Link this to backpack ds
    private List<String> playerItems;
    JSONObject heroPosition;

    public HubSpot() {
        this.savegame = new SaveGame();
        this.heroPosition = new JSONObject();
        this.item = new Item();
        this.heroPosition.put("Current_position", "start");
        this.heroPosition.put("Previous_position", "hub");
        this.hero = new Hero();
        this.playerItems = new ArrayList<>();
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

    public void loadSavedGame(String playerName, JSONArray playerItems) {
        getHero().setHeroName(playerName);
    }

    public void setPlayerName(String name) {
        this.hero.setHeroName(name);
    }

    public String getPlayerName() {
        return this.hero.getHeroName();
    }

    public void showPlayerProfile() {
        getHero().displayHeroProfile();
    }


    public void setHeroPosition(String position) {
        updatePositions((String) this.heroPosition.get("Current_position"), position);
    }

    public String getHeroPosition() {
        return (String) this.heroPosition.get("Current_position");
    }

    public String getHeroPrevPosition() {
        return (String) this.heroPosition.get("Previous_position");
    }


    private void updatePositions(String oldPosition, String newPosition) {
        this.heroPosition.put("Previous_position", oldPosition);
        this.heroPosition.put("Current_position", newPosition);
    }

    public void getHeroStatus() {

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<String> getPlayerItems() {
        return this.item.getBackpackList();
    }

    public void setPlayerItems(List<String> playerItems) {
        this.playerItems = playerItems;
    }

    // TODO Henry added some functions starts here.

    // Create list of item by location, TODO should take data from JSON, will change if got time.
    public void initiateItemLocationList() {

        item.getItemLocationList().put("start", new ArrayList<String>());
        item.getItemLocationList().put("basement", new ArrayList<String>());
        item.getItemLocationList().put("engineRoom", new ArrayList<String>());
        item.getItemLocationList().put("controlStation", new ArrayList<String>());
        item.getItemLocationList().put("messHall", new ArrayList<String>());
        item.getItemLocationList().put("hallway", new ArrayList<String>());
        // Items found at start location.
        item.getItemLocationList().get("start").add("TM");
        item.getItemLocationList().get("start").add("knife");
        // Items found at hallway.
        item.getItemLocationList().get("hallway").add("boots");
        // Items found at basement.
        item.getItemLocationList().get("basement").add("toolkit");
        // Items found at engineRoom.
        item.getItemLocationList().get("engineRoom").add("engine");
        item.getItemLocationList().get("engineRoom").add("gloves");
        // Items found at controlStation.
        item.getItemLocationList().get("controlStation").add("pistol");
        item.getItemLocationList().get("controlStation").add("GPS");
        item.getItemLocationList().get("controlStation").add("keycard");
        // Items found at messHall.
        item.getItemLocationList().get("messHall").add("rifle");
        item.getItemLocationList().get("messHall").add("ACH");
        item.getItemLocationList().get("messHall").add("IMTV");
        item.getItemLocationList().get("messHall").add("basement_key");
//        System.out.println(item.getItemLocationList());
//        item.setItemLocationList(item.getItemLocationList());
    }

    // TODO in work, using JSON to replace initiateItemLocationList().
//    public void findNameOfLocation(String location){
//        JSONArray arrayAll = new FileHandler().readJsonFile("item_dictionary.json");
//        for (JSONArray a)
//
//
//
//        for (Object obj : arrayAll) {
//            JSONObject objAll = (JSONObject) obj;
//            JSONObject attribute = (JSONObject) objAll.get(firstName);
//            System.out.println("Array all: " + arrayAll);
//            System.out.println("Turn Array to Obj all: " + objAll);
//            System.out.println("First layer name: " + firstName);
//            System.out.println(attribute);
//            System.out.println(attribute.get("location"));
//
//        }
//        item.getItemLocationList().put
//        item.getItemLocationList().put("start", new ArrayList<String>());
//        item.getItemLocationList().get("start").add("TM");
//        item.getItemLocationList().get("start").add("knife");
//        System.out.println(a);
//        System.out.println(item.getItemLocationList());
//    }

    // This will print a list of items based on hero current location.
    public void lookAction() {
//        System.out.println(item.getItemLocationList()); // delete me.
        item.setItemFound(item.getItemLocationList().get(getHeroPosition()));
//        System.out.println("ItemFound: " + item.getItemFound()); //Delete me. For test.
        // Set a temporary variable to save the item found in place.
        ArrayList<String> itemsHere = item.getItemFound();
        // clear the list of item found based on location.
        item.setItemFound(null);
        // If there are items available in the area, show them to player.
       if (itemsHere == null){
            System.out.println("\uD83D\uDE12 No item is found at this location");
        } else {
            for (int i = 0; i < itemsHere.size(); i++) {
                item.setItemCalledOut(itemsHere.get(i));
                item.readItemFile();
                String itemFoundName = item.getItemName();
                System.out.println("\uD83D\uDE00 You found " + itemFoundName);
            }
        }
    }

    // Pick function.
    public void addToInventory() {
        // TODO add the item to backpack, remove them from itemFoundMap.
        item.setItemFound(item.getItemLocationList().get(getHeroPosition()));
        // Set a temporary variable to save the item found in place.
        ArrayList<String> itemsHere = item.getItemFound();
//        System.out.println("itemFound= " + itemsHere);//Delete me. For test.
//        System.out.println("allItemFoundMap before = " + item.getItemLocationList());//Delete me. For test.
        System.out.println("backpack before " + item.getBackpackList());//Delete me. For test.
        if (itemsHere == null) {
            System.out.println("\uD83D\uDE12 No item is found at this location");
        } else {
            for (int i = 0; i < itemsHere.size(); i++) {
                item.getBackpackList().add(itemsHere.get(i));
                item.setItemCalledOut(itemsHere.get(i));
                item.readItemFile();
                System.out.println(item.getItemName() + " is added to your backpack \uD83C\uDF92");
            }
            item.getItemLocationList().remove(getHeroPosition());
//            System.out.println("allItemFoundMap after = " + item.getItemLocationList());//Delete me. For test.
            System.out.println("backpack after " + item.getBackpackList());//Delete me. For test.
        }
    }

    // Initiate the backpack based the Hero's attribute. Will run this once when game starts.
    public void initiateInventory(){
        for (int i = 0; i < hero.getItems().size(); i++){
            item.getBackpackList().add(hero.getItems().get(i));
            }
        item.setBackpackList(item.getBackpackList());
    }
    // Show inventory function.
    public void showInventory() {
        System.out.println(item.getBackpackList());
        // TODO make it prettier.
//        ArrayList<String> inv = item.getBackpackList();
//        for (int i = 0; i < inv.size(); i++){
//            System.out.println(inv.get(i));
//            item.setItemCalledOut(inv.get(i).toString());
//            item.readItemFile();
//            System.out.println(item.getItemName());
//        }
    }

    // Generate item card function.
    public void showItemCard(String input) {
        item.setItemCalledOut(input);
        item.readItemFile();
        if (item.getItemName() != null){
            System.out.println(
                    "\n" + item.getItemName() +
                            "\n" + item.getItemDescription() +
                            "\nIt has " + item.getItemPower()
                            + " \uD83E\uDD4APower  and " + item.getItemDefense()
                            + " \uD83D\uDEE1Defense ."
            );
        } else {
            System.out.println("You don't have this item.");
        }

    }

}
