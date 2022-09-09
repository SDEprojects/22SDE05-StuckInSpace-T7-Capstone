package com.learning.datamodel;

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
    public ArrayList<String> backpackList = new ArrayList<>();
    public ArrayList<String> carryList;
    public ArrayList<String> wearList;
    private Map<String, ArrayList<String>> itemLocationList;

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
        try (InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream("item_dictionary.json")))) {
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
//    public JSONArray getItemDict() {
//        return itemDict;
//    }
    // Multiple layers JSON call ends here.

    // Display item details.


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
        Map<String, ArrayList<String>> itemLocationList = new HashMap<String, ArrayList<String>>();
        itemLocationList.put("start", new ArrayList<String>());
        itemLocationList.put("basement", new ArrayList<String>());
        itemLocationList.put("engineRoom", new ArrayList<String>());
        itemLocationList.put("controlStation", new ArrayList<String>());
        itemLocationList.put("messHall", new ArrayList<String>());
        itemLocationList.put("hallway", new ArrayList<String>());
        // Items found at start location.
        itemLocationList.get("start").add("TM");
        itemLocationList.get("start").add("knife");
        // Items found at hallway.
        itemLocationList.get("hallway").add("basement_key");
        itemLocationList.get("hallway").add("boots");
        // Items found at basement.
        itemLocationList.get("basement").add("keycard");
        itemLocationList.get("basement").add("toolkit");
        // Items found at engineRoom.
        itemLocationList.get("engineRoom").add("engine");
        itemLocationList.get("engineRoom").add("gloves");
        // Items found at controlStation.
        itemLocationList.get("controlStation").add("pistol");
        itemLocationList.get("controlStation").add("GPS");
        // Items found at messHall.
        itemLocationList.get("messHall").add("rifle");
        itemLocationList.get("messHall").add("ACH");
        itemLocationList.get("messHall").add("IMTV");

        return itemLocationList;
    }

    // Setter for item called by the player.


    public ArrayList<String> getBackpackList() {
        return backpackList;
    }

    public void setBackpackList(ArrayList<String> backpackList) {
        this.backpackList = backpackList;
    }

    public void setItemCalledOut(String itemCalledOut) {
        this.itemCalledOut = itemCalledOut;
    }

    public String getItemCalledOut() {
        return itemCalledOut;
    }


}
