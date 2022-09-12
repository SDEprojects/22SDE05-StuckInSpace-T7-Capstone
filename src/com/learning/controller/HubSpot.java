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
import java.util.*;
import java.util.List;

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

    // Create list of item by location,

    public void initiateItemLocationList(){
//        JSONArray itemJSON = new FileHandler().readJsonFile("item_dictionary.json");
        JSONArray itemJSON = item.getItemDict();

        for (Object obj : itemJSON) {
            JSONObject objAll = (JSONObject) obj; // Turn item JSON into obj.
            Set allName = objAll.keySet(); // Get all the first layer of names item.json.
            // turn all first layer of names into a list.
            List<String> keyList = new ArrayList<>(allName.size()); // keyList if the list of first layer names.
            for (Object keyItemName : allName){
                keyList.add(keyItemName.toString());
            }
            // Create a list using location as the key.
            for (String keyItemName : keyList){
                JSONObject attribute = (JSONObject) objAll.get(keyItemName); // All attributes for each item.
                String itemLoc = attribute.get("location").toString();
                item.getItemLocationList().put(itemLoc, new ArrayList<>());
            }

           // Print each item in their location.
            for (String keyItemName : keyList) {
//                System.out.println(keyItemName);
                JSONObject attribute = (JSONObject) objAll.get(keyItemName); // All attributes for each item.
                String itemLoc = attribute.get("location").toString();
                item.getItemLocationList().get(itemLoc).add(keyItemName);
            }
//            System.out.println(item.getItemLocationList()); // Delete me, for test.
        } // This } closes (Object obj : itemJSON) for loop line 146.
    } // This } closes the findNameOfLocation function.

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
                item.parseItemObject();
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
        if (itemsHere == null) {
            System.out.println("\uD83D\uDE12 No item is found at this location");
        } else {
            for (int i = 0; i < itemsHere.size(); i++) {
                item.getBackpackList().add(itemsHere.get(i));
                item.setItemCalledOut(itemsHere.get(i));
                item.parseItemObject();
                System.out.println(item.getItemName() + " is added to your backpack \uD83C\uDF92");
            }
            item.getItemLocationList().remove(getHeroPosition());
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
//        System.out.println(item.getBackpackList()); // Delete me, for test.
        ArrayList<String> inv = item.getBackpackList();
        for (int i = 0; i < inv.size(); i++){
//            System.out.println(inv.get(i)); // Delete me, for test.
            JSONArray itemJSON = item.getItemDict();
            for (Object obj : itemJSON) {
                JSONObject objAll = (JSONObject) obj; // Turn item JSON into obj.
                JSONObject attribute = (JSONObject) objAll.get(inv.get(i));

                System.out.println((i + 1) + ". " + attribute.get("name"));
            }

        }

    }


    // Generate item card function.
    public void showItemCard(String itemNum) {
        Integer itemNumInput = Integer.parseInt(itemNum);
        String it = item.getBackpackList().get(itemNumInput - 1);
        item.setItemCalledOut(it);
        item.parseItemObject();
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
