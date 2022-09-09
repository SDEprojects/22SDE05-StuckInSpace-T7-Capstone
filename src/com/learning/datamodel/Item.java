package com.learning.datamodel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

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
        this.itemDict = readItemFile();
    }

    // create a function to get data from JSON


    public JSONArray readItemFile() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray itemList = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try (FileReader reader = new FileReader(classLoader.getResource("item_dictionary.json").getFile())) {
            //Read JSON file
            Object item_obj = jsonParser.parse(reader);
            itemList = (JSONArray) item_obj;
//            System.out.println(itemList); // **** for dev process only, need to Delete.

            //Iterator over item array
            itemList.forEach(item -> parseItemObject((JSONObject) item));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void parseItemObject(JSONObject item) {

        //Get single object within list
        JSONObject itemObject = (JSONObject) item.get(itemCalledOut);

        //Get item name, description, location, store, power, defense.
        itemName = (String) itemObject.get("name");
        itemDescription = (String) itemObject.get("description");
        itemLocation = (String) itemObject.get("location");
        itemStore = (String) itemObject.get("store");
        itemPower = (String) itemObject.get("power");
        itemDefense = (String) itemObject.get("defense");

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
