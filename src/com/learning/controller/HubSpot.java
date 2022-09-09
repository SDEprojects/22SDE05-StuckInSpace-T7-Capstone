package com.learning.controller;

import com.learning.datamodel.Hero;
import com.learning.datamodel.Item;
import com.learning.datamodel.NPC;
import com.learning.view.SaveGame;
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

    public void autoSaveGame() {
        this.savegame.saveGame();
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
        return playerItems;
    }

    public void setPlayerItems(List<String> playerItems) {
        this.playerItems = playerItems;
    }

    // TODO Henry added some functions starts here.
    ArrayList<String> itemFound = new ArrayList<>();

    public void getLookAround() {
        // This will print a list of items based on hero current location.
        Mission mission = new Mission(); // TODO Henry needs to fix this.
        HubSpot hub = new HubSpot();// TODO Henry needs to fix this.

        itemFound.clear();
        itemFound = mission.getItems().getItemLocationList().get(hub.getHeroPosition());
//        System.out.println(hub.heroPosition);
//        System.out.println(hub.getHeroPosition());

        if (itemFound.size() > 0) {

            for (int i = 0; i < itemFound.size(); i++) {
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
    public void addToInventory() {
        Mission mission = new Mission();// TODO Henry needs to fix this.
        Map itemFoundMap = mission.getItems().getItemLocationList();
//        System.out.println("itemFound= " + itemFound);
//        System.out.println("itemFoundMap = " + itemFoundMap);
        if (itemFoundMap.size() > 0) {
            for (int i = 0; i < itemFound.size(); i++) {
                item.backpackList.add(itemFound.get(i));
                item.setItemCalledOut(itemFound.get(i));
                item.readItemFile();
                System.out.println(item.getItemName() + " is added to your backpack \uD83C\uDF92");
            }
            itemFoundMap.remove(getHeroPosition());
//            System.out.println("backpack = " + item.backpackList);
//            System.out.println("itemFound= " + itemFound);
//            System.out.println("itemFoundMap = " + itemFoundMap);
        }

    }

    // Show inventory function.
    public void showInventory() {
        ArrayList itemInInv = item.backpackList;
        for (int i = 0; i < itemInInv.size(); i++) {
            System.out.println(itemInInv.get(i));
        }
    }

    // Generate item card function.
    public void showItemCard() {
        System.out.println(
                "\n" + item.getItemName() +
                        "\n" + item.getItemDescription() +
                        "\nIt has " + item.getItemPower()
                        + " \uD83E\uDD4APower  and " + item.getItemDefense()
                        + " \uD83D\uDEE1Defense ."
        );
    }

}
