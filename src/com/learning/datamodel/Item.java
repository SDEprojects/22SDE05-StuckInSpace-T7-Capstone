package com.learning.datamodel;

import com.learning.utility.FileHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class Item {
    // Define variable to parse JSON file.
    private JSONArray itemDict;
    // This is the variable when game called out an item.
    private String itemCalledOut = "fuel";

    // Define variables from JSON file, so they could be used to create getters.
    private String itemName;
    private String itemDescription;
    private String itemLocation;
    private String itemStore;
    private String itemPower;
    private String itemDefense;

    // Define variables for inventory lists.
    private ArrayList<String> backpackList = new ArrayList<>();
//    private ArrayList<String> carryList; // For the future.
//    private ArrayList<String> wearList; // For the future.
    private Map<String, ArrayList<String>> itemLocationList = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> itemFound = new ArrayList<>();

    // Multiple layers JSON call starts here.
    public Item() {
        this.itemDict = new FileHandler().readJsonFile("item_dictionary.json");
    }

    public void parseItemObject() {

        JSONObject searchItem = (JSONObject) getItemDict().get(0);
        JSONObject target = (JSONObject) searchItem.get(itemCalledOut);
        //Get item name, description, location, store, power, defense.
        itemName = (String) target.get("name");
        itemDescription = (String) target.get("description");
        itemLocation = (String) target.get("location");
        itemStore = (String) target.get("store");
        itemPower = (String) target.get("power");
        itemDefense = (String) target.get("defense");
    }

    public JSONArray getItemDict() {
        return itemDict;
    }

    // Getters for each attribute of the item.

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public String getItemStore() {
        return itemStore;
    }

    public String getItemPower() {
        return itemPower;
    }

    public String getItemDefense() {
        return itemDefense;
    }

    // Getter that generate an items list based on location.
    public Map<String, ArrayList<String>> getItemLocationList() {
        return itemLocationList;
    }

    public void setItemLocationList(Map<String, ArrayList<String>> itemLocationList) {
        this.itemLocationList = itemLocationList;
    }


    // Setter for item called by the player.
    public void setItemCalledOut(String itemCalledOut) {
        this.itemCalledOut = itemCalledOut;
    }

    public String getItemCalledOut() {
        return itemCalledOut;
    }

    // Setter and getter for the items found in current area.
    public ArrayList<String> getItemFound() {
        return itemFound;
    }

    public void setItemFound(ArrayList<String> itemFound) {
        this.itemFound = itemFound;
    }

    // Setter and getter for the backpack/ inventory.

    public ArrayList<String> getBackpackList() {
        return backpackList;
    }

    public void setBackpackList(ArrayList<String> backpackList) {
        this.backpackList = backpackList;
    }
}
